create database quanlynhansu
use quanlynhansu;

create table department
(
    Id   int primary key auto_increment,
    Name varchar(100) not null unique check ( length(Name) >= 6 )
);

create table levels
(
    id              int primary key auto_increment,
    name            varchar(100) not null unique,
    basicsalary     float        not null check ( basicsalary >= 3500000 ),
    allowancesalary float default 500000
);
create table employee(
    id int primary key auto_increment,
    name varchar(150) not null ,
    email varchar(150) not null unique check ( email regexp('^[\\w\\d]+@[\\w\\d]+\\.([\\w\\D]+){2,4}$') ),
  phone varchar(50) not NULL unique ,
    address varchar(255),
    gender tinyint not null check ( gender in (0,1,2)),
    birthday date not null ,
    levelid int not null ,
    departmentid int not null ,
    foreign key (levelid) references levels(id),
    foreign key (departmentid) references department(Id)
);
create table timesheets(
    id int primary key auto_increment,
    attendancedate date not null default (current_date),
    employeeid int not null ,
    value float not null default 1 check ( value IN (0,0.5,1)),
    foreign key (employeeid) references employee(id)
);
create table salary(
    id int primary key auto_increment,
    employeeid int not null ,
    bonussalary float default 0,
    insurrance float not null
)


