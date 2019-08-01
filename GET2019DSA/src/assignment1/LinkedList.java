 package assignment1; 
 

   public class LinkedList{
	 public Node head;
	 
	   /**
		* Name: insert
		* Disc: used to insert an element in linked list. 
		* @param:  (1) data- integer - data provided by user to add i the list
		* @return: Node -  return Node that has been created
		**/
	  public Node insert(int data){
		  Node node = new Node();
		  node.data = data;
		  node.next = null;
		 if(head == null){
			 head=node;
			 return head;
		 }
		 else{
			 Node n=head;
			 while(n.next != null){
				  n=n.next;
			 	}
			  n.next=node;
			  return n;
		 	}
	 }
	 
	  /**
		* Name: display
		* Disc: used to display the  elements of linked list. 
		* @return: void 
		**/
	 public void display(){
		 
		 Node n = head;
		 while(n.next != null){
			 System.out.println(n.data);
			 n=n.next;
		 } 
		 System.out.println(n.data);
	 }
	 
	  /**
		* Name: containsLoop
		* Disc: to check if linked List contains a loop or not. 
		* @return: boolean -  if contains a loop  ? true: false
		* using floyd's cycle detection 
		**/
	 public boolean containsLoop(){
		 Node fast = head;
		 Node slow = head;
		 while(fast != null && fast.next != null){
			    
			    fast = fast.next.next;
			    slow = slow.next;
			    if(fast == slow){
			    	System.out.println("loop exist");
			    	return true;
			    	
			    }
		 }
		 return false;
	 }
	 
	    /**
		* Name: rotate
		* Disc: used to rotate a sub list element in linked list. 
		* @param:  (1) A- Node - node pointer to start the link list
		*          (2) m- integer - starting index of sublist
		*          (3) n- integer - ending index of sublist
		*          (4) k- integer - no of times user wants to rotate the sub list 
		* @return: String - return linked list element in a string 
		**/
	 public static String rotate(Node A, int m, int n, int k)  
	 {  
		 String s = " ";
	     int size = n - m + 1;  
	     
	     // If k is greater than size of sublist then   
	     // we will take its modulo with size of sublist  
	     if (k > size) {  
	         k = k % size;  
	     }  
	     
	     // If k is zero or k is equal to size or k is  
	     // a multiple of size of sublist then list   
	     // remains intact  
	     if (k == 0 || k == size) {  
	         Node head = A;  
	         while (head != null) { 
	        	 s = s+head.data;
	             //System.out.print( head.data);  
	             head = head.next;  
	         }  
	         return s;  
	     }  
	     
	     Node link = null;  // m-th node  
	     if (m == 1) {  
	         link = A;  
	     }  
	     
	     // This loop will traverse all node till  
	     // end node of sublist.      
	     Node c = A;  // Current traversed node  
	     int count = 0;  // Count of traversed nodes  
	     Node end = null;    
	     Node pre = null; // Previous of m-th node  
	     while (c != null) {  
	         count++;  
	     
	         // We will save (m-1)th node and later  
	         // make it point to (n-k+1)th node  
	         if (count == m - 1) {  
	             pre = c;  
	             link = c.next;  
	         }  
	         if (count == n - k) {  
	             if (m == 1) {  
	                 end = c;  
	                 A = c.next;  
	             }  
	             else {  
	                 end = c;  
	     
	                 // That is how we bring (n-k+1)th  
	                 // node to front of sublist.  
	                 pre.next = c.next;  
	             }  
	         }  
	     
	         // This keeps rest part of list intact.  
	         if (count == n) {  
	             Node d = c.next;  
	             c.next = link;  
	             end.next = d;  
	             Node head = A;  
	             while (head != null) { 
	            	 s= s+head.data;
	                // System.out.print( head.data+" ");  
	                 head = head.next;  
	             }  
	             return s;  
	         }  
	         c = c.next;  
	     }
		return s;  
	 }  
		
	}
	 
	 
 