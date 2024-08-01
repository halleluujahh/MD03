create database book_management;
use book_management;

create table Category(
	id int primary key auto_increment,
    name varchar(100) not null,
    status tinyint default(1) check (status in (0,1))
);
create table Author(
	id int primary key auto_increment,
    name varchar(100) not null unique,
    totalbook int default(0)
);
create table book(
	id int primary key auto_increment,
    name varchar(150) not null,
    status tinyint default(1) check (status in (0,1)),
    price float not null check (price >= 100000),
    createddate date,
    categoryid int not null,
    foreign key(categoryid) references Category(id),
    authorid int not null,
    foreign key(authorid) references Author(id)
);

delimiter &&
create trigger createdDateBookTrigger before insert on book
for each row
begin
    if new.createddate is null then set new.createddate = current_date();
    end if;
end &&
delimiter &&;

create table customer(
	id int primary key auto_increment,
    name varchar(150) not null,
    email varchar(150) not null unique,
    phone varchar(50) not null unique,
    address varchar(255),
    createddate date,
    gender tinyint not null check (gender in (0, 1, 2)),
    birthday date not null
);

delimiter &&
create trigger createdDateTrigger before insert on customer
for each row
begin
    if new.createddate < current_date() then signal sqlstate '45000' set message_text = 'must be greater or equal than current date';
    else set new.createddate = current_date();
    end if;
end &&
delimiter &&;

create table ticket(
	id int primary key auto_increment,
    customerid int not null,
    status tinyint default(1) check (status between 0 and 3),
    ticketdate datetime,
    foreign key(customerid) references customer(id)
);
delimiter &&
create trigger ticketdate before insert on ticket
for each row
begin
	if new.ticketdate is null then set new.ticketdate = current_date();
    end if;
END &&
delimiter &&;

create table ticketdetail(
	ticketid int not null,
    bookid int not null,
    quantity int not null check (quantity>0),
    depositprice float not null,
    rentcost float  not null,
    foreign key(ticketid) references ticket(id),
    foreign key(bookid) references book(id)
);

DELIMITER &&
CREATE TRIGGER before_insert_rentcost
BEFORE INSERT ON ticketdetail
FOR EACH ROW
BEGIN
    if new.depositPrice not IN (select price from book) then signal sqlstate '45000' set message_text = 'deposit price must be equal book price';
    else set  NEW.RentCost = NEW.depositPrice * 0.10;
    end if;
END &&
DELIMITER &&;
 


use book_management;
insert into category(name, status) values ('Văn Học', 1), ('Thơ ca', 0), ('Ngụ ngôn',1), ('Châm biếm',1), ('Văn xuôi', 1);
insert into author(name, totalbook) values ('Nguyễn Du',5), ('Nguyễn Đình Thi', 10), ('Tô Hoài', 13), ('Ngô Tất Tố', 16), ('Nguyên Ngọc', 12);
insert into book(name, price, categoryid, authorid) values ('Rừng Xà Nu', 100000, 5, 5),('Tắt đèn', 200000, 1, 4),('Dế Mèn Phiêu Lưu Ký', 165000, 3, 3)
,('Truyện Kiều', 150000,2, 1),('Đất Nước', 130000, 5, 2),('Trong Cát Bụi', 210000, 5, 2),('Sóng reo', 162000, 1, 2),('Cỏ dại', 180000, 2, 3)
,('Núi Cứu Quốc', 135000, 2, 3),('Quê Người', 145000, 2, 3);
insert into customer(name, email, phone, address, gender, birthday) 
values 
('Nam', 'nam@gmail.com', '0123456789', 'So 1 Thanh Cong', 1, '1999-07-31'),
('Giang', 'giang@gmail.com', '0981234560', 'So 6 Me Tri', 0, '1992-02-14'),
('Linh', 'link@gmail.com', '0832165523', 'So 18 Hoan Kiem', 2, '1995-05-28');
insert into ticket(customerid, status) 
values 
(13, 1),
(14,2),
(15,3);
insert into ticketdetail(ticketid,bookid,quantity,depositprice)
values
(7,52,5,200000),
(8,53,3,165000),
(9,54,2,150000);


use book_management;
select * from author;
select * from category;
select * from book;
select * from customer;
select * from ticket;
select * from ticketdetail;

-- REQUIREMENT 1 -- 
-- 1.	Lấy ra danh sách Book có sắp xếp giảm dần theo Price gồm các cột sau: 
-- Id, Name, 	Price, Status, CategoryName, AuthorName, CreatedDate -- 

	select b.id, b.name, b.price, b.status, c.name categoryname, a.name, b.createddate from book b
    join category c on c.id = b.categoryid
    join author a on a.id = b.authorid
    order by b.price desc;

-- 2.	Lấy ra danh sách Category gồm: Id, Name, TotalProduct, Status 
-- (Trong đó cột Status nếu = 0 là Ẩn, = 1 là Hiển thị ) --
    
    select  c.id, c.name, count(b.id) TotalProduct, case c.status when c.status = 0 then 'Ẩn' else 'Hiển thị' end as status  from book b
    join category c on c.id = b.categoryid
	group by c.id;

-- 3.	Truy vấn danh sách Customer gồm: Id, Name, Email, Phone, Address, CreatedDate, Gender, BirthDay, Age
-- (Age là cột suy ra từ BirthDay, Gender nếu = 0 là Nam, 1 là Nữ,2 là khác ) --

	select c.id, c.name, c.email, c.phone, c.address, c.createddate, (YEAR(current_date()) - YEAR(c.birthday)) as age, 
    CASE c.gender WHEN 0 then 'Nam' WHEN 1 then 'Nữ' else 'Khác' end as gender 
    from customer c;

-- 4.	Truy vấn xóa Author chưa có sách nào --   

	delete a from author a
    where a.id in (select distinct a.id from book b join author a on a.id = b.authorid);

-- 5.	Cập nhật Cột TotalBook trong bảng Author = Tổng số Book của mỗi Author theo Id của Author -- 

	CREATE TEMPORARY TABLE temp_author_books AS
	SELECT authorid, COUNT(id) AS book_count
	FROM book
	GROUP BY authorid;
	select * from temp_author_books

	UPDATE author a
	JOIN temp_author_books t ON a.id = t.authorid
	SET a.TotalBook = t.book_count;
    
    -- REQUIREMENT 2 --
    -- 1.	View v_getBookInfo thực hiện lấy ra danh sách các Book được mượn nhiều hơn 3 cuốn  --
    
		create view v_getBookInfo as 
        (
			select td.bookid, count(td.bookid) 'số lần mượn' from ticketdetail td
			group by td.bookid
			having 'số lần mượn' > 3
        );
        
    -- 2.	View v_getTicketList hiển thị danh sách Ticket gồm: Id, TicketDate, Status, CusName, Email, Phone,TotalAmount 
    -- (Trong đó TotalAmount là tổng giá trị tiền phải trả, cột Status nếu = 0 thì hiển thị Chưa trả, = 1 Đã trả, = 2 Quá hạn, 3 Đã hủy)  --

    create view v_getTicketList as
    (
		select t.id, t.ticketdate, case t.status when 0 then 'Chưa trả' when 1 then 'Đã trả' when 2 then 'Quá hạn' when 3 then 'Đã hủy' end as status
        , c.name, c.email, c.phone, (td.quantity*td.rentcost) totalamount
        from ticket t 
        join ticketdetail td on td.ticketid = t.id 
        join customer c on c.id = t.customerid
    );
    
    -- REQUIREMENT 3 --
    -- 1.	Thủ tục addBookInfo thực hiện thêm mới Book, khi gọi thủ tục truyền đầy đủ các giá trị của bảng Book ( Trừ cột tự động tăng ) 
    
    delimiter &&
		create procedure addBookInfo
        (
			_name varchar(150),
			_status tinyint,
			_price float,
			_categoryid int,
			_authorid int
        )
        begin
			insert into book (name, status, price, categoryid, authorid) values (_name, _status, _price, _categoryid, _authorid);
        end &&
    delimiter &&;
    call addBookInfo('Trong Rừng Nho', 0, 125000, 5, 4);
    
    -- a.	Thủ tục getTicketByCustomerId hiển thị danh sách đơn hàng của khách hàng theo Id khách hàng gồm: Id, TicketDate, Status, TotalAmount 
    -- (Trong đó cột Status nếu =0 Chưa trả, = 1  Đã trả, = 2 Quá hạn, 3 đã hủy ), Khi gọi thủ tục truyền vào id cuả khách hàng -- 
    
    delimiter &&
		create procedure getTicketByCustomerId
        (
			_id int
        )
        begin
			select t.id, t.ticketdate, case t.status when 0 then 'Chưa trả' when 1 then 'Đã trả' when 2 then 'Quá hạn' else 'Đã hủy' end as status, (td.quantity*td.rentcost) totalamount
            from ticket t 
            join ticketdetail td on td.ticketid = t.id
            where t.customerid = _id;
        end &&
    delimiter &&;
    
    call getTicketByCustomerId(13);
    
    -- 2.	Thủ tục getBookPaginate lấy ra danh sách sản phẩm có phân trang gồm: Id, Name, Price, Sale_price, Khi gọi thủ tuc truyền vào limit và page -- 
    
    delimiter &&
    create procedure getBookPaginate
    (
		_limit int,
        _page int
    )
    begin
		declare _offsetpage int;
        set _offsetpage = (_page - 1) * _limit;
        select b.id, b.name, b.price from book b
        limit _limit offset _offsetpage;
    end &&
    delimiter &&;
    
    call getBookPaginate(5,1);
    
    -- REQUIREMENT 4 --
    -- 1.	Tạo trigger tr_Check_total_book_author sao cho khi thêm Book nếu Author đang tham chiếu có 
	-- tổng số sách > 5 thì không cho thêm mới và thông báo “Tác giả này có số lượng sách đạt tới giới hạn 5 cuốn, vui long chọn tác giả khác”  -- 
    
		delimiter &&
			create trigger tr_Check_total_book_author before insert on Book
			for each row
			begin
				declare authorFlag int;
				select a.id into authorFlag from author a where a.id = (select a.id from Book b join Author a on a.id = b.authorid where a.id = new.authorid group by a.id having count(b.id) > 5);
				if authorFlag is not null then signal sqlstate '45000' set message_text = 'Tác giả này có số lượng sách đạt tới giới hạn 5 cuốn, vui long chọn tác giả khác';
				end if;
			end &&;
        delimiter &&;
        
    -- 2.	Tạo trigger tr_Update_TotalBook khi thêm mới Book thì cập nhật cột TotalBook trong bảng Author = tổng của Book theo AuthorId -- 
    
		delimiter &&
			create trigger tr_Update_TotalBook after insert on Book
            for each row
            begin
				CREATE TEMPORARY TABLE temp_author_books AS
				SELECT authorid, COUNT(id) AS book_count
				FROM book
				GROUP BY authorid;
                
				UPDATE author a
				JOIN temp_author_books t ON a.id = t.authorid
				SET a.TotalBook = t.book_count;
                
                drop temporary table temp_author_books;
            end &&;
        delimiter &&;    
