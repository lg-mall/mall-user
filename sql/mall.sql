SELECT @@global.time_zone;
SET GLOBAL time_zone = '+8:00';


create database if not exists mall;
use mall;

create table if not exists merchant
(
    id            bigint primary key auto_increment comment '主键',
    merchant_name varchar(60) unique key comment '商户名',
    password      varchar(20) comment '密码',
    phone_num     varchar(20) unique key comment '手机号码',
    create_date   datetime default CURRENT_TIMESTAMP() comment '创建时间',
    update_date   datetime default current_timestamp() on update CURRENT_TIMESTAMP() comment '修改时间'
);
