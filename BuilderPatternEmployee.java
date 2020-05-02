//Builder Pattern for employee
class Employee{
	private String name;
	private String companyName;
	private Integer age;
	private String gender;
	private String designation;
	private Integer salary;
	private String shift;
	
	public Employee(Builder obj){
		this.name = obj.name;
		this.companyName = obj.companyName;
		this.age = obj.age;
		this.gender = obj.gender;
		this.designation = obj.designation;
		this.salary = obj.salary;
		this.shift = obj.shift;
	}
	static class Builder{
		private String name;
		private String companyName;
		private Integer age;
		private String gender;
		private String designation;
		private Integer salary;
		private String shift;
		
		public Builder setName(String name){
			this.name = name;
			return this;
		}
		
		public Builder setCompanyName(String companyName){
			this.companyName = companyName;
			return this;
		}
		
		public Builder setAge(Integer age){
			this.age = age;
			return this;
		}
		
		public Builder setGender(String gender){
			this.gender = gender;
			return this;
		}
		
		public Builder setDesignation(String designation){
			this.designation = designation;
			return this;
		}
		
		public Builder setSalary(Integer salary){
			this.salary = salary;
			return this;
		}
		
		public Builder setShift(String shift ){
			this.shift = shift;
			return this;
		}
		
		public Employee build(){
			Employee e = new Employee(this);
			return e;
		}
	}
	
	public String getName()
	{
		return this.name;
	}
	
}

class MyMainClass{
	public static void main(String[] agrs){
		Employee e = new Employee.Builder().
									setName("Kaushal Agarwal").
									setAge(22).setCompanyName("BNY MELLON").
									setDesignation("Software Developer").
									setGender("MALE").
									setSalary(60000).
									setShift("Morning").
									build();
									
		System.out.println("Employee Name: "+ e.getName());	
	
	}
}