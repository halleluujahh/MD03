use quanlydiemsv;
/* 6 */
select k.MaKhoa, k.TenKhoa
from dmkhoa k
where k.TenKhoa like '_N%';
/* 7 */
select concat(s.HoSV, ' ', s.TenSV) as 'Ho va ten sinh vien'
from dmsv s
where s.HoSV like '%Thi%';
/* 8 */
select s.masv, concat(s.HoSV, ' ', s.TenSV) as 'Ho va ten sinh vien', phai, ngaysinh, noisinh, makhoa, hocbong
from dmsv s
order by s.MaKhoa desc;
/* 9 */
select concat(s.HoSV, ' ', s.TenSV) as 'Ho ten sinh vien', s.MaKhoa, s.NoiSinh, s.HocBong
from dmsv s
where s.HocBong >= 150000;
/* 10 */
select s.MaSV, k.MaKhoa, s.Phai
from dmsv s
         join dmkhoa k on k.MaKhoa = s.MaKhoa
where k.MaKhoa IN ('AV', 'VL');
/* 11 */
select s.MaSV, s.NgaySinh, s.NoiSinh, s.HocBong
from dmsv s
where s.NgaySinh between '1991/01/01' AND '1992/06/05';
/* 12 */
select s.MaSV, s.NgaySinh, s.Phai, s.MaKhoa
from dmsv s
where s.HocBong between 80000 and 150000;
/* 13 */
select h.MaMH, h.TenMH, h.SoTiet
from dmmh h
where h.SoTiet between 31 and 44;
/* 14 */
select s.MaSV, concat(s.HoSV, ' ', s.TenSV) as 'ho ten sinh vien', k.TenKhoa, s.Phai
from dmsv s
         join dmkhoa k on k.MaKhoa = s.MaKhoa
where k.TenKhoa IN ('Anh Van', 'Tin hoc')
  AND s.Phai = 'Nam';
/* 15 */
select s.TenSV
from dmsv s
WHERE s.TenSV LIKE '%N%';
/* 16 */
select s.HoSV, s.TenSV, s.NoiSinh, s.NgaySinh
from dmsv s
where s.NoiSinh = 'Ha Noi'
  AND MONTH(s.NgaySinh) = 2;
/* 17 */
select concat(s.HoSV, ' ', s.TenSV) as 'ho ten sinh vien', Year(NOW()) - YEAR(s.NgaySinh) as Tuoi, s.HocBong
from dmsv s
having Tuoi > 20;
/* 18 */
select concat(s.HoSV, ' ', s.TenSV) as 'ho ten sinh vien', Year(NOW()) - YEAR(s.NgaySinh) as Tuoi, k.TenKhoa
from dmsv s
         join dmkhoa k on k.MaKhoa = s.MaKhoa
having Tuoi BETWEEN 20 AND 25;
/* 19 */
select concat(s.HoSV, ' ', s.TenSV) as 'ho ten sinh vien', s.Phai, s.NgaySinh
from dmsv s
where MONTH(s.NgaySinh) BETWEEN 1 AND 3
/* 20 */
select s.MaSV,
       s.Phai,
       s.MaKhoa,
       CASE s.HocBong
           WHEN s.HocBong > 500000 THEN 'Hoc bong cao'
           ELSE 'Muc trung binh'
           END AS 'Muc hoc bong'
from dmsv s;
/* 21 */
select count(*) as 'Tong so sinh vien toan truong'
from dmsv;
/* 22 */
select count(*)              as 'Tong so sinh vien toan truong',
       (select count(*) as 'Tong so sinh vien nu'
        from dmsv s
        where s.Phai = 'Nu') as 'Tong so sinh vien nu'
from dmsv;
/* 23 */
select k.MaKhoa, count(*) as 'so luong sinh vien'
from dmsv s
         join dmkhoa k on k.MaKhoa = s.MaKhoa
group by k.MaKhoa;
/* 24 */
select h.TenMH, count(*) as 'so luong sinh vien'
from dmsv s
         join ketqua k on k.MaSV = s.MaSV
         join dmmh h on h.MaMH = k.MaMH
group by h.TenMH;
/* 25 */
select count(*) as 'tong so mon hoc'
from (select h.MaMH
      from ketqua k
               join dmmh h on h.MaMH = k.MaMH
      group by h.MaMH) as temp;
/* 26 */
select k.TenKhoa, COUNT(*)
from dmsv s
         join dmkhoa k on k.MaKhoa = s.MaKhoa
where HocBong > 0
group by k.TenKhoa;
/* 27 */
select k.TenKhoa, max(s.HocBong)
from dmsv s
         join dmkhoa k on k.MaKhoa = s.MaKhoa
group by k.TenKhoa;
/* 28 */
select k.TenKhoa,
       COALESCE(temp.allMale, 0)    AS 'Tong so sinh vien nam',
       COALESCE(temp1.allFemale, 0) AS 'Tong so sinh vien nu'
from dmsv s
         join dmkhoa k on k.MaKhoa = s.MaKhoa
         left join
     (select k.MaKhoa as 'khoa', count(*) as 'allMale'
      from dmsv s
               join dmkhoa k on k.MaKhoa = s.MaKhoa
      where s.Phai = 'Nam'
      group by k.MaKhoa) temp on temp.khoa = k.MaKhoa
         left join
     (select k.MaKhoa as 'khoa', count(*) as 'allFemale'
      from dmsv s
               join dmkhoa k on k.MaKhoa = s.MaKhoa
      where s.Phai = 'Nu'
      group by k.MaKhoa) temp1 on temp1.khoa = k.MaKhoa
group by k.MaKhoa;
/* 29 */
select YEAR(CURRENT_DATE) - YEAR(s.NgaySinh) as 'Tuoi', count(*) as 'So luong sinh vien'
from dmsv s
group by Tuoi;
/* 30 */
select YEAR(s.NgaySinh), Count(YEAR(s.NgaySinh)) as 'so luong sinh vien'
from dmsv s
group by YEAR(s.NgaySinh)
having Count(YEAR(s.NgaySinh)) = 2;
/* 31 */
select s.NoiSinh, Count(*) as 'so luong sinh vien'
from dmsv s
group by s.NoiSinh
having s.NoiSinh > 2;
/* 32 */
select h.TenMH, count(k.MaSV) as 'so luong sinh vien'
from ketqua k
         join dmmh h on h.MaMH = k.MaMH
group by h.TenMH
having count(k.MaSV) > 3;
/* 33 */
select k.MaSV
from ketqua k
where k.LanThi > 2;
/* 34 */
select k.MaSV, k.LanThi, k.Diem, s.Phai
from ketqua k
         join dmsv s on s.MaSV = k.MaSV
where k.LanThi = 1
  and k.Diem > 7
  and s.Phai = 'Nam';
/* 35 */
select k.MaSV, count(k.MaMH) as 'so luong mon', k.LanThi
from ketqua k
where k.LanThi = 1
group by k.MaSV, k.LanThi
having count(k.MaMH) > 2;
/* 36 */
select k.MaKhoa, count(s.MaSV) as 'sinh vien nam'
from dmkhoa k
         join dmsv s on s.MaKhoa = k.MaKhoa
where s.Phai = 'Nam'
group by k.MaKhoa
having `sinh vien nam` > 2;
/* 37 */
select k.MaKhoa, count(s.MaSV) as 'sinh vien'
from dmkhoa k
         join dmsv s on s.MaKhoa = k.MaKhoa
where s.HocBong between 200000 and 300000
group by k.MaKhoa
having `sinh vien` = 2;
/* 38 */
SELECT k.MaMH,
       COALESCE(temp.failed_students, 0)  AS 'so luong sinh vien rot',
       COALESCE(temp1.passed_students, 0) AS 'so luong sinh vien dat'
FROM ketqua k
         LEFT JOIN
     (SELECT k.MaMH, COUNT(k.MaSV) AS 'failed_students'
      FROM ketqua k
      WHERE k.Diem < 5
        and k.LanThi = 2
      GROUP BY k.MaMH) AS temp ON temp.MaMH = k.MaMH
         LEFT JOIN
     (SELECT k.MaMH, COUNT(k.MaSV) AS 'passed_students'
      FROM ketqua k
      WHERE k.Diem >= 5 AND k.LanThi = 1
         OR k.LanThi = 2
      GROUP BY k.MaMH) AS temp1 ON temp1.MaMH = k.MaMH
GROUP BY k.MaMH;
/* 39 */
select s.MaSV, s.HocBong
from dmsv s
WHERE s.HocBong = (SELECT Max(s.HocBong) from dmsv s);
/* 40 */
select k.MaSV, k.Diem
from ketqua k
where k.Diem = (select MAX(k.Diem)
                from ketqua k
                where k.LanThi = 1);
/* 41 */
select s.MaSV, k.TenKhoa, year(current_date) - year(s.NgaySinh) as tuoi
from dmsv s
         join dmkhoa k on k.MaKhoa = s.MaKhoa
where k.TenKhoa = 'ANH VAN'
HAVING tuoi = (select MAX(year(current_date) - year(s.NgaySinh)) from dmsv s);
/* 42 */
select k.TenKhoa,
       count(s.MaSV) as 'so luong sinh vien'
from dmsv s
         join dmkhoa k on k.MaKhoa = s.MaKhoa
group by k.TenKhoa
HAVING count(s.MaSV) =
       (select MAX(countSV) from (select sv.MaKhoa, count(sv.MaSV) countSV from dmsv sv group by sv.MaKhoa) subquery);
/* 43 */
select k.TenKhoa, count(sv.MaSV)
from dmsv sv
         join dmkhoa k on k.MaKhoa = sv.MaKhoa
where sv.Phai = 'Nu'
group by k.TenKhoa
having count(sv.MaSV) =
       (select max(count)
        from (select s.MaKhoa, count(s.MaSV) as count from dmsv s where s.Phai = 'Nu' group by s.MaKhoa) subquery);
/* 44 */
select k.MaMH, count(k.MaMH)
from ketqua k
where k.LanThi = 1
  AND k.Diem < 5
group by k.MaMH
having count(k.MaMH) =
       (select MAX(count)
        from (select k.MaMH, count(k.MaMH) count
              from ketqua k
              where k.LanThi = 1
                AND k.Diem < 5
              group by k.MaMH) subquery);
/* 45 */
select k.MaSV, kh.TenKhoa, k.Diem, h.TenMH
from ketqua k
         join dmsv sv on sv.MaSV = k.MaSV
         join dmkhoa kh on kh.MaKhoa = sv.MaKhoa
         join dmmh h on h.MaMH = k.MaMH
where (select k.Diem
       from ketqua k
                join dmsv sv on sv.MaSV = k.MaSV
                join dmkhoa kh on kh.MaKhoa = sv.MaKhoa
                join dmmh h on h.MaMH = k.MaMH
       where kh.TenKhoa NOT IN ('Anh Van')
         and h.TenMH = 'Van Pham')
    >
      (select k.Diem
       from ketqua k
                join dmsv sv on sv.MaSV = k.MaSV
                join dmkhoa kh on kh.MaKhoa = sv.MaKhoa
                join dmmh h on h.MaMH = k.MaMH
       where kh.TenKhoa IN ('Anh Van')
         and h.TenMH = 'Van Pham')
  AND kh.TenKhoa NOT IN ('Anh Van')
  and h.TenMH = 'Van Pham';
/* 46 */
select sv.MaSV, sv.NoiSinh
from dmsv sv
where sv.NoiSinh =
      (select sv.NoiSinh
       from dmsv sv
       where sv.TenSV = 'Hai')
  AND sv.TenSV != 'Hai';
/* 47 */
select k.MaSV, sv.HocBong
from ketqua k
         join dmsv sv on sv.MaSV = k.MaSV
         join dmkhoa kh on kh.MaKhoa = sv.MaKhoa
where sv.HocBong
    >
      (select MAX(sv.HocBong)
       from ketqua k
                join dmsv sv on sv.MaSV = k.MaSV
                join dmkhoa kh on kh.MaKhoa = sv.MaKhoa
       where kh.TenKhoa IN ('Anh Van'))
  AND kh.TenKhoa NOT IN ('Anh Van')
group by k.MaSV, sv.HocBong;
/* 49 */
select k.Diem as diem
from ketqua k
         join dmmh h on h.MaMH = k.MaMH
where k.LanThi = 2
  and k.MaMH = 1
  and k.Diem
    > (select MAX(k.Diem)
       from ketqua k
                join dmmh h on h.MaMH = k.MaMH
       where k.LanThi = 1
         and k.MaMH = 1)
/* 50 */
select k.MaSV
from ketqua k
         join (select k.MaMH, MAX(k.Diem) diem from ketqua k group by k.MaMH) sub on sub.diem = k.Diem
group by k.MaSV;
/* 51 */
select k.MaKhoa, count(k.MaKhoa) 'so luong sinh vien' from dmkhoa k join dmsv sv on sv.MaKhoa = k.MaKhoa
group by k.MaKhoa
having count(k.MaKhoa) = 0;
/* 52 */
select k.MaSV from ketqua k
join dmmh h on h.MaMH = k.MaMH
where h.TenMH = 'Co So Du Lieu'
group by k.MaSV;
/* 53 */
SELECT k2.MaSV
FROM ketqua k2
LEFT JOIN ketqua k1 ON k2.MaSV = k1.MaSV AND k1.LanThi = 1
WHERE k2.LanThi = 2 AND k1.MaSV IS NULL;



