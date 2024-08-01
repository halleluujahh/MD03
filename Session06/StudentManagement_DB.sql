create database StudentManagement;
use StudentManagement;
create table Student(
    student_id int primary key auto_increment,
    student_name varchar(100) not null,
    age int not null,
    student_status bit
);
DELIMITER \\
create procedure get_all_student()
begin
    select * from Student;
end \\
DELIMITER \\;
DELIMITER \\
create procedure insert_student(
    name_in varchar(100),
    age_in int,
    status_in bit
)
begin
    insert into Student(student_name, age, student_status)
        values (name_in,age_in,status_in);
end \\
DELIMITER \\;
DELIMITER \\
create procedure update_student(
    id_in int,
    name_in varchar(100),
    age_in int,
    status_in bit
)
begin
    update Student
        set student_name = name_in,
            age = age_in,
            student_status = status_in
    where student_id = id_in;
end \\
DELIMITER \\;

DELIMITER \\
create procedure delete_Student(
    id_in int
)
begin
    delete from student where student_id = id_in;
end \\
DELIMITER \\;

DELIMITER \\
create procedure get_cnt_student(
    OUT cnt_student int
)
begin
    set cnt_student = (Select count(Student.student_id) from student);
end \\
DELIMITER \\;

DELIMITER \\
create procedure get_Student_By_id(id_in int)
begin
    select * from Student where student_id = id_in;
end \\
DELIMITER \\;
