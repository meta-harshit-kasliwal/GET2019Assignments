package assignment2;
interface stack{
	public void push(int x);

	public char pop();

	public char peek();

	public boolean isFull();

	public boolean isEmpty();
}
public class StackImplementation implements stack{
      int top,size;
      char [] array;
	StackImplementation(int size){
		this.size = size;
		array = new char[this.size];
		top = -1;
	}
	@Override
	public void push(int x) {
		if(isFull()){
			System.out.println("overflow");
		}
		else{
			this.top = this.top +1;
			array[this.top] = (char)x;
			System.out.println(x+"pushed in stack");
		}
		
	}

	@Override
	public char pop() {
		if(isEmpty()){
		 System.out.println("stack is empty");
			return '0';
		}
		else{
			char x = (char)(array[top]);
			this.top = this.top-1 ;
			System.out.println(x+"poped from stack");
			return x;
		}
	
	}

	@Override
	public char peek() {
		return (char)(this.top);
	}

	@Override
	public boolean isFull() {
		if(this.top == this.size-1){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean isEmpty() {
		if(this.top< 0){
			return true;
		}
		else{
		return false;
		}
	}
	public static void main(String[] args) {
		StackImplementation obj = new StackImplementation(5);
		obj.push(10);
		obj.push(20);
		obj.push(30);
		obj.push(40);
		obj.push(50);
		obj.pop();
		System.out.println(obj.peek());
		obj.pop();
		obj.pop();
		obj.pop();
		obj.pop();
		obj.pop();
		
	}

}
