public class AddValidationFactory{
	static AddValidationFactory obj;
	static HashMap<string, Validation> countryToValidation;
	private AddValidationFactory(){
		countryToValidation('US',new USValidation());
		countryToValidation('IN',new INDIAValidation());
		countryToValidation('UK',new UKValidation());
	}
	public static getInstance(){
		if (obj == null)
			obj = new AddValidationFactory();
		return obj;	
	}
	public Validate getValidate(String country){
		if (countryToValidation.contains(country))
			return countryToValidation.get(country);
		else 
			throw Error("country not found");
	}
}