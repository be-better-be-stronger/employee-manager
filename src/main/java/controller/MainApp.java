package main.java.controller;

import java.util.List;
import java.util.Scanner;

import main.java.model.Employee;
import main.java.service.EmployeeServiceImpl;

public class MainApp {
	
	private static EmployeeServiceImpl service = new EmployeeServiceImpl();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		 while (true) {
	            System.out.println("\n=== Quản Lý Nhân Viên (MVC) ===");
	            System.out.println("1. Thêm nhân viên");
	            System.out.println("2. Xem danh sách nhân viên");
	            System.out.println("3. Cập nhật nhân viên");
	            System.out.println("4. Xóa nhân viên");
	            System.out.println("5. Tìm kiếm nhân viên theo tên");
	            System.out.println("6. Hiển thị nhân viên theo lương giảm dần");
	            System.out.println("7. Xem danh sách nhân viên có phân trang");
	            System.out.println("0. Thoát");
	            
	            int choice = inputInt("Nhập lựa chọn: ");
	            switch (choice) {
	                case 1:
	                    addEmployee();
	                    break;
	                case 2:
	                    listEmployees();
	                    break;
	                case 3:
	                    updateEmployee();
	                    break;
	                case 4:
	                    deleteEmployee();
	                    break;
	                case 5:
	                    searchEmployeesByName();
	                    break;
	                case 6:
	                    listEmployeesSortedBySalaryDesc();
	                    break;
	                case 7:
	                    listEmployeesWithPaging();
	                    break;
	                case 0:
	                    System.out.println("👋 Tạm biệt cục vàng!");
	                    System.exit(0);
	                default:
	                    System.out.println("❌ Lựa chọn không hợp lệ!");
	            }
	        }
	}
	
	public static void addEmployee() {
		String name = inputString("Ten: ");
        String position = inputString("Chuc vu: ");        
        double salary = inputDouble("Luong: ");        
        Employee e = new Employee(0, name, position, salary);
        service.add(e);
        System.out.println("Da them nv moi");
	}
	
	public static void listEmployees() {
		List<Employee> list = service.getAll();
		System.out.println("Danh sach nv: ");
		System.out.printf("%-5s %-20s %-20s %-12s\n", "ID", "Tên", "Chức vụ", "Lương");
		for(Employee e : list) {
			System.out.printf("%-5d %-20s %-20s %-12.2f\n", 
					e.getId(),
					e.getName(),
					e.getPosition(),
					e.getSalary()
			);
		}
	}
	
	public static void updateEmployee() {		
		int id = inputInt("Nhap id nhan vien: ");
        
        System.out.println("\nBạn muốn cập nhật:");
        System.out.println("1. Lương");
        System.out.println("2. Chức vụ");
        System.out.println("3. Cả hai");
        
        int choice = inputInt("chon: ");
        
        switch(choice) {
        	case 1:
        		double newSalary = inputDouble("Nhập lương mới: ");
                service.updateSalary(id, newSalary);
                System.out.println("✅ Đã cập nhật lương!");
                break;
        	case 2:
        		String newPosition = inputString("Nhap chuc vu moi: ");
        		service.updatePosition(id, newPosition);
        		System.out.println("✅ Đã cập nhật chức vụ!");
                break;
        	case 3:
        		double salary = inputDouble("Nhap luong moi: ");
        		String position = inputString("Nhap chuc vu moi: ");
        		service.updateSalaryAndPosition(id, salary, position);
        		System.out.println("✅ Đã cập nhật cả lương và chức vụ!");
                break;
            default:
                System.out.println("❌ Lựa chọn không hợp lệ!");
        }
	}
	
	public static void deleteEmployee() {
		int id = inputInt("Nhập ID nhân viên can xoa: ");
        service.delete(id);
        System.out.println("✅ Đã xóa nhân viên!");
	}
	
	public static void searchEmployeesByName() {
		String keyword = inputString("Nhap tu khoa can tim kiem: ");
		List<Employee> list = service.searchByName(keyword);
		if(list.isEmpty()) {
			System.out.println("Khong tim thay nhan vien nao");
		}else {
			 System.out.println("Ket qua tim kiem");
			 System.out.printf("%-5s %-20s %-20s %-12s\n", "ID", "Tên", "Chức vụ", "Lương");
			 for(Employee employee : list) {
				 System.out.printf("%-5d %-20s %-20s %-12.2f\n",
					        employee.getId(),
					        employee.getName(),
					        employee.getPosition(),
					        employee.getSalary()
					    );
			 }
		}
	}
	
	private static void listEmployeesSortedBySalaryDesc() {
		List<Employee> list = service.getAllSortedBySalaryDesc();
		System.out.println("Danh sach nv (luong cao -> thap: )");
		System.out.printf("%-5s %-20s %-20s %-12s\n", "ID", "Tên", "Chức vụ", "Lương");
		for(Employee employee : list) {
			System.out.printf("%-5d %-20s %-20s %-12.2f\n",
					employee.getId(),
					employee.getName(),
					employee.getPosition(),
					employee.getSalary()
			);
		}		
	}
	
	private static void listEmployeesWithPaging() {
		int pageSize = 5;
		int totalEmployees = service.getTotalEmployeeCount();
		int totalPages = (totalEmployees + pageSize - 1)/pageSize;
		
		System.out.println("Co tong cong " + totalEmployees + " nhan vien");
		System.out.println("Chia thanh " + totalPages + " trang, moi trang " + pageSize + " nhan vien");
		
		int page = inputInt("Nhap so trang ban muon xem:");
		List<Employee> list = service.getEmployeesByPage(page, 5);
		
		if(list.isEmpty()) {
			System.out.println("Khong co du lieu cho trang nay!");
		}else {
			System.out.println("Danh sach sinh vien - trang " + page + ":");
			System.out.printf("%-5s %-20s %-20s %-12s\n", "ID", "Tên", "Chức vụ", "Lương");
			for (Employee emp : list) {
			    System.out.printf("%-5d %-20s %-20s %-12.2f\n",
			        emp.getId(),
			        emp.getName(),
			        emp.getPosition(),
			        emp.getSalary()
			    );
			}
		}		
	}
	
	private static int inputInt(String message) {
		while(true) {
			try {
				System.out.println(message);
				int value = Integer.parseInt(scanner.nextLine());
				return value;
			} catch (NumberFormatException e) {
				System.out.println("❌ Lỗi: Vui lòng nhập số nguyen hợp lệ.");
			}
		}
	}
	
	private static double inputDouble(String message) {
		while(true) {
			try {
				System.out.println(message);
				double value = Double.parseDouble(scanner.nextLine());
				if(value < 0) {
					System.out.println("❌ Lỗi: Số không được âm.");
				}else {
					return value;
				}
			} catch (NumberFormatException e) {
				System.out.println("❌ Lỗi: Vui lòng nhập số thực hợp lệ.");
			}
		}
	}
	
	private static String inputString(String message) {
		System.out.println(message);
		String value = scanner.nextLine();
		return value;
	}
}
