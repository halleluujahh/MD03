# Dữ liệu được tổ chức dưới các Bảng (Table)
# Mỗi cột của bảng gọi là column (hoặc property)
# Mỗi hàng (bản ghi/ record) của bảng gọi là row (hoặc turple)
# Ngôn ngữ SQL không phân biệt hoa thường

# MYSQL Server: máy chủ của Hệ quản trị cơ sở dữ liệu
# tạo cơ sở dữ liệu đại diện cho dữ liệu của một ứng dụng
# cách 1: dùng tool workbench
# chuột phải -> create schema -> đặt tên cơ sở dữ liệu -> apply
# cách 2: dùng câu lệnh
CREATE Database quanlysinhvien;
# Xóa cơ sở dữ liệu
DROP database quanlysinhvien;
# Select database muốn tạo bảng
use quanlysinhvien;
#Tạo bảng
create table Student(
    id int,
    name varchar(100),
    age int
);