create database Ecommerce_DB;
use Ecommerce_DB;
create table Categories(
    catalog_id int primary key auto_increment,
    catalog_name varchar(100) not null unique,
    catalog_description text,
    catalog_status bit
);
DELIMITER &&
create procedure find_all_categories()
begin
    select * from Categories;
end &&
DELIMITER &&;