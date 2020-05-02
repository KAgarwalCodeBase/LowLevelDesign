//Builder pattern
class Leapord{
	private String name;
	private String color;
	private String gender;
	private String country;
	private String height;
	private int tailLength;
	
	public Leapord(Builder obj)
	{
		this.name = obj.name;
		this.color = obj.color;
		this.gender = obj.gender;
		this.country = obj.country;
		this.height = obj.height;
		this.tailLength = obj.tailLength;
	}
	
	static class Builder{
		private String name;
		private String color;
		private String gender;
		private String country;
		private String height;
		private int tailLength;
		
		public Builder setName(String name){
			this.name = name;
			return this;
		}
		
		public String getName(){
			return this.name;
		}
		
		public Builder setColor(String color){
			this.color = color;
			return this;
		}
		
		public Builder setGender(String gender){
			this.gender = gender;
			return this;
		}
		
		public Builder setCountry(String country){
			this.country = country;
			return this;
		}
		
		public Builder setHeight(String height){
			this.height = height;
			return this;
		}
		
		public Builder setTailLength(int tailLength){
			this.tailLength = tailLength;
			return this;
		}
		
		public Leapord build(){
			Leapord l = new Leapord(this);
			return l;
		}
		
	}
	
	public String getName()
	{
		return this.name;
	}
	
}

class MyMainClass{
	public static void main(String args[])
	{
		Leapord l = new Leapord.Builder().setName("Vartika").setColor("yellow").setGender("Female").setHeight("tall").setTailLength(5).build();
		
		System.out.println ("Leapord Name: "+ l.getName());
		
	}
}