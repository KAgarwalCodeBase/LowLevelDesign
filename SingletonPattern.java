//Singleton Pattern & FactoryClass
// Lecture 3 of LLD
// Address Validation
import java.util.HashMap;
class MyException extends Exception{
   String str1;
   MyException(String str2) {
	this.str1=str2;
   }
   public String toString(){ 
	return ("Wrong Information entered : "+ str1) ;
   }
}

class Address{
		String addressLine = "XYZ";
		Integer pincode = 211011;
		String city = "Chennai";
		String state = "Tamil Nadu";
	    String country = "India";
		String houseNo = "Flat No. 9";
		
	
}

//Factory class for AddressValidation country-wise
class AddValidationFactory {
	static AddValidationFactory obj;
	static HashMap<String,Validation> countryToValidation = new HashMap<String,Validation>();
	
	//constructor
	private AddValidationFactory(){
		countryToValidation.put("US",new USValidation());
		countryToValidation.put("UK",new UKValidation());
		countryToValidation.put("Singopore",new SingaporeValidation());
		countryToValidation.put("India",new INDIAValidation());
	}
	
	//making class as singleton
	public static AddValidationFactory getInstance(){
		if (obj==null)
			obj = new AddValidationFactory();
		return obj;
	}
	public Validation getValidate(String country) throws MyException{
		if (this.countryToValidation.containsKey(country))
		{	
			System.out.println("Factory Class executed");
			return countryToValidation.get(country);
		}
		else  throw new MyException("Country not found");
			
	}
}

//Validation interface implemented in every country validation class for providing polymorphism 
interface Validation{
	public boolean validate(Address a);
}

class SingaporeValidation implements Validation{
	public boolean validate(Address a){
		return true;
	}
}
class UKValidation implements Validation{
	public boolean validate(Address a){
		return true;
	}
}
class USValidation implements Validation{
	public boolean validate(Address a){
		return true;
	}
}
class INDIAValidation implements Validation
{
	public boolean validate(Address a)
	{
		return  (AddressLineValidation.Validate(a.addressLine)
					&& PinCodeValidation.Validate(a.pincode)
					&& CountryValidation.Validate(a.country)
					&& CityValidation.Validate(a.city)
					&& StateValidation.Validate(a.state)
					&& HouseNoValidation.Validate(a.houseNo) );
		
	}
}


/*----------------- Details of INDIA Validation class---------------------------------------*/
class PinCodeValidation{
	public static boolean Validate(Integer pincode){
		HashMap<Integer,Boolean> ZipCode = ResourceInitializer.getInstance().ZipCode;
		//System.out.println(ZipCode);
		//System.out.println(ZipCode.containsValue(pincode));
		if (ZipCode.containsKey(pincode))
		{	System.out.println("Pincode : " + pincode +"  present in database");
			return true;
		}
		return false;	
	}
}

//It is Singleton class bz only one time requirement for initialization of zipcodes.
//ResourceInitializer class for database operation of PinCodeValidation class
class ResourceInitializer{
	static HashMap<Integer,Boolean> ZipCode = new HashMap<Integer,Boolean>();
	static ResourceInitializer r;
	private ResourceInitializer(){
		//create database connection
		//database query
		//close connection
		//Initialize
		ZipCode.put(211011,true);
		ZipCode.put(211001,false);
		ZipCode.put(211012,false);
		ZipCode.put(211013,false);
		ZipCode.put(211014,false);
		ZipCode.put(211015,false);
				
	}
	public static ResourceInitializer getInstance(){
		if (r == null)
			r = new ResourceInitializer();
		return r;	
		
	}
}

class AddressLineValidation{
	public static boolean Validate(String AddressLine){
		return true;
	}
}
class CountryValidation{
	public static boolean Validate(String country){
		return true;	
	}
}

class CityValidation{
	public static boolean Validate(String city){
		return true;
	}
}

class StateValidation{
	public static boolean Validate(String state){
		return true;
	}
}

class HouseNoValidation{
	public static boolean Validate(String houseNo){
		return true;
	}
	
}

class MyMainClass{
	public static void main(String args[]) throws MyException {
		Address adj = new Address();
		System.out.println(adj.addressLine);
		AddValidationFactory.getInstance().getValidate(adj.country).validate(adj);
	}
}