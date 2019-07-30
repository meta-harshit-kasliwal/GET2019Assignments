
public class Comperision {

	public static boolean equalTo(String number1, String number2) {
	
		if(number1.length()!=number2.length())
			return false;
		else{
			Integer index=number1.length()-1;
			while(index>=0){
				if(number1.charAt(index)!=number2.charAt(index))
					return false;
				index--;
			}
		}
		return true;
	}
	
	public static boolean greaterThan(String number1, String number2) {
		
		Integer index=0;
		Integer lengthNum1=number1.length()-1,lengthNum2=number2.length()-1;
		if(lengthNum1>lengthNum2)
			return true;
		else if(lengthNum2>lengthNum1)
			return false;
		else{
			while(index<=lengthNum1){
				if(number1.charAt(index)>number2.charAt(index))
					return true;
				 if(number1.charAt(index)<number2.charAt(index))
					return false;
				index++;
			}
					
		}
		return false;
			
	}
	
	
	public static  boolean lessThan(String number1, String number2) {
		Integer index=0;
		Integer lengthNum1=number1.length()-1,lengthNum2=number2.length()-1;
		if(lengthNum1>lengthNum2)
			return false;
		else if(lengthNum2>lengthNum1)
			return true;
		else{
			while(index<=lengthNum1){
				if(number1.charAt(index)<number2.charAt(index))
					return true;
				 if(number1.charAt(index)>number2.charAt(index))
					return false;
				index++;
			}
		}
		
		return false;
		
	}

	
	
	
}

