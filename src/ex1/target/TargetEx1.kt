package ex1.target
/* BÀI TOÁN
* Xây dựng lớp VIENCHUC
- Mỗi viên chức có các thuộc tính: Mã viên chức, Họ tên, Năm sinh,-HSL (Hệ số lương)-
- Hàm ảo tính lương viên chức.
* Xây dựng lớp CBHANHCHINH kế thừa từ lớp VIENCHUC
- Mỗi cán bộ hành chính quản lý các thuộc tính: chức danh (như kế toán, thủ quỹ, giáo vụ, bảo vệ,...), phụ cấp ăn trưa,
- Xây dựng hàm tính lương của cán bộ hành chính theo công thức: HSL * 1000000 + phụ cấp ăn trưa.
* Xây dựng lớp GIAOVIEN kể thừa từ lớp VIENCHUC
- Mỗi giáo viên quản lý các thông tin: môn dạy (như toán, văn, vật lý, hóa học,...), trình độ chuyên môn (như đại học, thạc sĩ,...), thâm niên (số năm đã làm giáo viên).
- Xây dựng hảm tính lương của giáo viên theo công thức: HSL * 2000000* (130+ thâm niên) /100 Tùy vào chuyên môn university + 1000000 , master + 3000000, còn lại + 5000000
* Xây dựng chương trình chính để thực hiện các công việc sau:
- Nhập thông tin mới cho N viên chức (Hỏi người dùng muốn nhập cho cán bộ hành hính hay giáo viên và nhập đúng thông tin cho đối tượng đó).
- Hiển thị thông tin về danh sách các viên chức.
- Tìm viên chức có lương cao nhất trường.
 */