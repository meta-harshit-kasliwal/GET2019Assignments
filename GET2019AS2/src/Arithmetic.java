
public class Arithmetic {

	
	public static String hexaDecimals="0123456789ABCDEF";
	
	
	public static  String addition(String number1,String number2){
		Integer num1=hexaToDecimal(number1);
		System.out.println(num1);
		Integer num2=hexaToDecimal(number2);
		System.out.println(num2);
		return decimalToHexa(num1+num2);
		
	}
	
	public static String subtraction(String number1,String number2){
		Integer num1=hexaToDecimal(number1);
		Integer num2=hexaToDecimal(number2);
		return decimalToHexa(num1-num2);
		
	}
	

	public static  String division(String number1, String number2) {
		// TODO Auto-generated method stub
		Integer num1=hexaToDecimal(number1);
		Integer num2=hexaToDecimal(number2);
		try{
		return decimalToHexa(num1/num2);
		}
		catch(Exception e){
			return "hello";
		}
	}



	public static String multiply(String number1, String number2) {
		// TODO Auto-generated method stub
		Integer num1=hexaToDecimal(number1);
		Integer num2=hexaToDecimal(number2);
		return decimalToHexa(num1*num2);
	}
	
	
	
	public static Integer hexaToDecimal(String hexaNumber){
		
		Integer decimalNumber=0;
		Integer length=hexaNumber.length();
		for(int i=0;i<length;i++){
			  char c=hexaNumber.charAt(i);
			  int d=hexaDecimals.indexOf(c);
			  decimalNumber=16*decimalNumber+d;
		}
		return decimalNumber;
		
	}
	
	
	public static String decimalToHexa(Integer decimalNumber){
		String hexaNumber="";
		while(decimalNumber>0){
			Integer mode = decimalNumber%16;
			char hexa=hexaDecimals.charAt(mode);
			hexaNumber=(Character.toString(hexa))+hexaNumber;
			decimalNumber=decimalNumber/16;
		}
		return hexaNumber;
		
	}

	
	
	
}

