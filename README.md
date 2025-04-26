# 🚀 Employee Manager - Java Console Application

Quản lý nhân viên bằng Java, JDBC, MySQL, giao diện console đơn giản – dễ sử dụng – chuyên nghiệp.

---

## 📚 Nội dung

- [Giới thiệu](#giới-thiệu)
- [Công nghệ sử dụng](#công-nghệ-sử-dụng)
- [Chức năng chính](#chức-năng-chính)
- [Thiết kế Database](#thiết-kế-database)

---

## 🎯 Giới thiệu

Employee Manager là ứng dụng Java console, mô phỏng các chức năng cơ bản của hệ thống quản lý nhân viên như thêm, cập nhật, tìm kiếm, phân trang và hiển thị dữ liệu từ MySQL database.

---

## 🔧 Công nghệ sử dụng

- Java 17 (hoặc Java 8+)
- JDBC API
- MySQL 8.x
- MySQL Connector/J
- IDE: IntelliJ IDEA / Eclipse / NetBeans
- Git + GitHub (quản lý version)

---

## ✨ Chức năng chính

- ➕ Thêm nhân viên mới
- 📋 Hiển thị danh sách nhân viên
- 🔍 Tìm kiếm nhân viên theo tên
- ⬇️ Sắp xếp nhân viên theo lương giảm dần
- ✏️ Cập nhật lương hoặc chức vụ
- 📑 Phân trang danh sách nhân viên
- 🛡️ Validation dữ liệu đầu vào
- 🎨 Format bảng console đẹp, dễ nhìn

---

## 🧱 Thiết kế Database

Bảng `employees`:

| Tên cột | Kiểu dữ liệu | Ý nghĩa |
|--------|--------------|---------|
| id | INT (Primary Key) | Mã nhân viên tự động tăng |
| name | VARCHAR(100) | Tên nhân viên |
| position | VARCHAR(100) | Chức vụ |
| salary | DOUBLE | Mức lương |

Câu lệnh tạo bảng:

```sql
CREATE DATABASE IF NOT EXISTS employee_management;

USE employee_management;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    position VARCHAR(100) NOT NULL,
    salary DOUBLE NOT NULL
);
