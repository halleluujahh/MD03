use quanlydiemsv;
/* 1 */
select s.MaSV, HoSV, TenSV, HocBong from quanlydiemsv.dmsv s
ORDER BY s.MaSV asc;
/* 2 */
select s.MaSV, concat(HoSV ," ", TenSV) as 'họ tên sinh viên', s.Phai, s.NgaySinh from dmsv s
order by s.Phai asc;
/* 3 */
select concat(HoSV ," ", TenSV) as 'họ tên sinh viên', s.NgaySinh, s.HocBong from dmsv s
order by s.NgaySinh asc, s.HocBong desc;
/* 4 */
select m.MaMH ,m.TenMH, m.SoTiet from dmmh m
WHERE m.TenMH LIKE 'T%';
/* 5 */
select concat(HoSV ," ", TenSV) as 'họ tên sinh viên', s.NgaySinh, s.Phai  from dmsv s;