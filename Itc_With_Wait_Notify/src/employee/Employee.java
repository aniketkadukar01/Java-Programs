package employee;

public class Employee {
	private int id;
	private String name,depname;
	private double sal;
	
	public Employee(int id , String name ,String depname , double sal) {
		super();
		this.id=id;
		this.name=name;
		this.depname=depname;
		this.sal=sal;
	}



	public int getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public String getDepname() {
		return depname;
	}



	public double getSal() {
		return sal;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", depname=" + depname + ", sal=" + sal + "]";
	}
	
	
}
