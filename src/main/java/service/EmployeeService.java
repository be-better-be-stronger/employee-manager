package main.java.service;

import java.util.List;

import main.java.dao.EmployeeDAO;
import main.java.model.Employee;

public class EmployeeService {
	private EmployeeDAO dao = new EmployeeDAO();
	
	public void add(Employee emp) {
		dao.addEmployee(emp);
	}
	
	public List<Employee> getAll(){
		return dao.getAllEmployees();
	}
	
	public void updateSalary(int id, double salary) {
		dao.updateEmployeeSalary(id, salary);
	}
	
	public void delete(int id) {
		dao.deleteEmployee(id);
	}

	public List<Employee> searchByName(String keyword) {
		return dao.findEmployeesByName(keyword);
	}

	public List<Employee> getAllSortedBySalaryDesc() {
		return dao.getEmployeesSortedBySalaryDesc();
	}

	public List<Employee> getEmployeesByPage(int page, int pageSize) {
		return dao.getEmployeesByPage(page, pageSize);
	}

	public int getTotalEmployeeCount() {
		return dao.getTotalEmployeecount();
	}

	public void updatePosition(int id, String newPosition) {
		dao.updatePosition(id, newPosition);
		
	}

	public void updateSalaryAndPosition(int id, double salary, String position) {
		dao.updateSalaryAndPosition(id, salary, position);
		
	}
}
