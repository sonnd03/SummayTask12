# SummayTask12 – Quản lý Nhân sự & Hóa đơn

## Mục tiêu
Chương trình mô phỏng hệ thống quản lý nhân sự và hóa đơn, bao gồm:  
- Quản lý thông tin nhân viên (`Staff`) và giáo viên (`Teacher`).  
- Tạo, xem, sửa, xóa và lọc thông tin nhân sự.  
- Tạo và quản lý hóa đơn (`Order`) với món ăn (`Food`) và đồ uống (`Drink`).  
- Kiểm tra dữ liệu nhập hợp lệ.  
- Sinh dữ liệu ngẫu nhiên (Random Data) để thử nghiệm.

---

## Cấu trúc lớp

### 1. Lớp cơ bản
- `Official`: lớp cha, chứa các thuộc tính chung của nhân sự.  
  **Thuộc tính:**  
  - `idOFC`: ID nhân sự  
  - `nameOFC`: Tên nhân sự  
  - `yearOfBirthOFC`: Năm sinh  
  - `salaryOFC`: Lương cơ bản  

### 2. Lớp kế thừa
- `Staff`: quản lý nhân viên  
  **Thuộc tính riêng:** `title`, `allowance`  
- `Teacher`: quản lý giáo viên  
  **Thuộc tính riêng:** `major`, `bonus`  

### 3. Quản lý hóa đơn
- `Order`: hóa đơn của một nhân sự  
  **Thuộc tính:** `id`, `person`, `food`, `drink`, `date`, `price`  
- `Food` và `Drink`: các món ăn và đồ uống trong hóa đơn  
  **Thuộc tính:** `nameFood`/`nameDrink`, `priceFood`/`priceDrink`

---

## Chức năng chính

### 1. Quản lý nhân sự
- **Thêm mới:** nhập thông tin nhân viên hoặc giáo viên, kiểm tra hợp lệ.  
- **Sửa thông tin:** cập nhật theo `idOFC`.  
- **Xóa thông tin:** xóa nhân sự theo `idOFC`.  
- **Xem danh sách:** in ra đầy đủ thông tin nhân sự.  
- **Lọc & tìm kiếm:** theo tuổi, lương hoặc các tiêu chí khác.

### 2. Quản lý hóa đơn
- **Tạo hóa đơn:** nhập thủ công hoặc sinh ngẫu nhiên.  
- **Xem hóa đơn:** in ra đầy đủ thông tin hóa đơn, bao gồm thông tin người tạo, món ăn, đồ uống, ngày và tổng tiền.  
- **Ngăn trùng ID:** hệ thống tự động kiểm tra tránh ID trùng lặp.

### 3. Kiểm tra dữ liệu
- Sử dụng lớp `CheckValid` để kiểm tra:  
  - Số nguyên, số thực  
  - Chuỗi hợp lệ  
  - Ngày tháng hợp lệ  

---

## Công cụ & kỹ thuật
- Ngôn ngữ: **Kotlin**  
- Sử dụng các hàm mở rộng `apply`, `let` để thao tác trực tiếp trên đối tượng.  
- Xử lý danh sách với các hàm: `filter`, `find`, `map`, `sortedBy`, `forEach`.  
- Quản lý dữ liệu bằng `Repository` và `ViewModel` pattern.  

---

## Hướng dẫn sử dụng
1. Chạy chương trình chính (`Main.kt`).  
2. Menu chính:  
- Lựa chọn các tùy chỉnh
- Tùy chỉnh số 4 sẽ có nhiều tuy chỉnh bên trong nữa
3. Hệ thống sẽ kiểm tra dữ liệu nhập hợp lệ và cảnh báo khi nhập sai.
