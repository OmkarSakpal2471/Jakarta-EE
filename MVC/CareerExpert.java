package mypack;

public class CareerExpert {
	public String getAdvice(String qualification) {

		if(qualification.equalsIgnoreCase("BE"))
			return "Dac Course";
		if(qualification.equalsIgnoreCase("HSC"))
			return "MSCIT";
		return "Enter Valid Course";
	}
}
