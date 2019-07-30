import java.util.Scanner;

public class HexCalc {
	
	
	public static Integer base=16;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
	
		System.out.println("Enter HexaDacimal Number1:");
		String number1=input.next();
		
		System.out.println("Enter HexaDacimal Number2:");
		String number2=input.next();
		
		number1=number1.toUpperCase();
		number2=number2.toUpperCase();
		
		
				
					String hexAddtion=Arithmetic.addition(number1,number2);
					System.out.println("Addition is "+hexAddtion);
				
			
					String hexSubraction=Arithmetic.subtraction(number1,number2);
					System.out.println("Subtraction is "+hexSubraction);
				
				
					String hexMultiply=Arithmetic.multiply(number1,number2);
					System.out.println("Multiply is "+hexMultiply);
				
				
					String hexDivision=Arithmetic.division(number1,number2);
					System.out.println("Division is "+hexDivision);
				

					if(Comperision.equalTo(number1,number2))
						System.out.println("Hexadecimal Number are equal");
					else
						System.out.println("Not Equal");
					
			
					if(Comperision.greaterThan(number1,number2))
						System.out.println("Number 1 is Greater");
					else
						System.out.println("Number 1 is not Greater");
					
				
					if(Comperision.lessThan(number1,number2))
						System.out.println("Number 1 is Smaller");
					else
						System.out.println("Number 1 is not Smaller");
				
						
				
	}
}
