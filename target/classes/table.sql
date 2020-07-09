drop table if exists t_files;
create table t_files(
id bigint not null auto_increment,
file_name varchar(255), -- 文件的原始名称
group_name varchar(32), -- 文件在FastDFS 中的卷名
remote_file_name varchar(255), -- 文件在FastDFS 中的文件名， UUID
file_path varchar(255), -- 文件在FastDFS 中的路径， 就是卷名+远程文件名
primary key(id)
);