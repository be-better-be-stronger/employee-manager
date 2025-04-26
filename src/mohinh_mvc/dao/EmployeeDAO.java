package mohinh_mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mohinh_mvc.DBConnection;
import mohinh_mvc.model.Employee;

public class EmployeeDAO {
	public void addEmployee(Employee emp) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getPosition());
            stmt.setDouble(3, emp.getSalary());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employees";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getDouble("salary")
                );
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateEmployeeSalary(int id, double salary) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE employees SET salary = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, salary);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM employees WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Employee> findEmployeesByName(String keyword) {
    	List<Employee> list = new ArrayList<>();
    	try(Connection conn = DBConnection.getConnection()){
    		String sql = "select * from employees where name like ?";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1, "%" + keyword + "%");
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()) {
    			Employee emp = new Employee(
    				rs.getInt("id"),
    				rs.getString("name"),
    				rs.getString("position"),
    				rs.getDouble("salary")
    			);
    			list.add(emp);
    		}
    	}catch (SQLException e) {
			e.printStackTrace();
		}
    	return list;
    	
    }

	public List<Employee> getEmployeesSortedBySalaryDesc() {
		List<Employee> list = new ArrayList<>();
		try (Connection connection = DBConnection.getConnection()){
			String sql = "select * from employees order by salary desc";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("position"),
						rs.getDouble("salary")
				);
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Employee> getEmployeesByPage(int page, int pageSize) {
		List<Employee> list = new ArrayList<>();
		int offset = (page - 1) * pageSize;
		try(Connection connection = DBConnection.getConnection()){
			String sql = "select * from employees limit ? offset ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, pageSize);
			ps.setInt(2, offset);
			
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				Employee employee = new Employee(
					resultSet.getInt("id"),
					resultSet.getString("name"),
					resultSet.getString("position"),
					resultSet.getDouble("salary")
				);
				list.add(employee);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getTotalEmployeecount() {
		int count = 0;
		try(Connection connection = DBConnection.getConnection()){
			String sql = "select count(*) from employees";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				count = resultSet.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public void updatePosition(int id, String newPosition) {
		try(Connection connection = DBConnection.getConnection()){
			String sql = "update employees set position = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newPosition);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public void updateSalaryAndPosition(int id, double salary, String position) {
		try(Connection connection = DBConnection.getConnection()){
			String sql = "update employees set salary = ?, position = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, salary);
			preparedStatement.setString(2, position);
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
