package mohinh_mvc.model;

public class Employee {
	private int id;
	private String name;
	private String position;
	private double salary;
	public Employee() {
		super();
	}
	public Employee(int id, String name, String position, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + getId() + ", name=" + getName() + ", position=" + getPosition() + ", salary=" + getSalary() + "]";
	}
	
}
