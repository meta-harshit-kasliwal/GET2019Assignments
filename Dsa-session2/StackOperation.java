
public class StackOperation implements Stack {

	/*
	 * Java program to implement basic stack operations
	 */
	static final int MAX = 1000;
	int top;
	String a[] = new String[MAX]; // Maximum size of Stack

	public boolean isEmpty() {
		if (top < 0)
			return true;
		return false;
	}

	StackOperation() {
		top = -1;
	}

	public boolean push(String string) {
		if (top >= (MAX - 1)) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			a[++top] = string;
			System.out.println(string + " pushed into stack");
			return true;
		}
	}

	public String pop() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return "";
		} else {
			String x = a[top--];
			System.out.println(x + "poped from stack");
			return x;
		}
	}

	public String peek() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return "";
		} else {
			String x = (a[top]);
			return x;
		}
	}

	public int Prec(String ch) 
    { 
        switch (ch) 
        { 
        case "+": 
        case " - ": 
            return 1; 
       
        case "*": 
        case "/": 
            return 2; 
       
        case "^": 
            return 3; 
        } 
        return -1; 
    } 
}
