package com.gowithlight.controller;

import com.gowithlight.entity.FileInfo;
import com.gowithlight.service.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @Auther: Elton Ge
 * @Date: 9/7/20
 * @Description: com.gowithlight.controller
 * @version: 1.0
 */
@Controller
public class UploadController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/uploadFile")
    public String uploadFile(MultipartFile uploadFile) {

        boolean flag = fileService.upload(uploadFile);
        System.out.println(flag ? "上传成功" : "上传失败");
        return "redirect:/index";
    }

    @RequestMapping(value = {"/", "/index"})
    public String toIndex(Model model) {
        List<FileInfo> list = fileService.findAll();
        model.addAttribute("list", list);
        return "/index.jsp";
    }

    /**
     * @param fileInfoId
     */
    @RequestMapping("/downloadFile/{fileInfoId}")
    public void downloadFile(@PathVariable Long fileInfoId, HttpServletResponse response) {
        //获取要传递给客户端到数据
        InputStream inputStream = null;
        try {
            inputStream = fileService.getFile(fileInfoId);
            FileInfo fileInfo = fileService.getFileInfoById(fileInfoId);
            //设置响应头
            response.setContentType("application/octet-stream");
            response.setHeader("content-disposition", "attachment;filename=" + fileInfo.getFileName());
            //通过输出流输出文件到客户端
            OutputStream outputStream = response.getOutputStream();
           /* byte[] temp = new byte[512];
            int len = 0;
            while ((len = (inputStream.read(temp))) != -1) {
                outputStream.write(temp, 0, len);
            }
            outputStream.flush();*/
            IOUtils.copy(inputStream,outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
