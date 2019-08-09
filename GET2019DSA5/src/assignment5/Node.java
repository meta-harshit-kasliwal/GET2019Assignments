package assignment5;

public class Node  {
 
	Employee obj;
	public Node next; // replace with Node left and Node right for tree 
	Node(int id,int salary,int age){
		obj = new Employee(id,salary,age);
		
	}
	
}
