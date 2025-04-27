package main.java.service;

import java.util.List;

import main.java.model.Employee;

public interface EmployeeService {
	void add(Employee emp);
	List<Employee> getAll();
	void updateSalary(int id, double salary);
	void delete(int id);
	List<Employee> searchByName(String keyword);
	List<Employee> getAllSortedBySalaryDesc();
	List<Employee> getEmployeesByPage(int page, int pageSize);
	int getTotalEmployeeCount();
	void updatePosition(int id, String newPosition);
	void updateSalaryAndPosition(int id, double salary, String position);
}
