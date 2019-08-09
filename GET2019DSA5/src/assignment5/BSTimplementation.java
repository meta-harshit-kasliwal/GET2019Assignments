package assignment5;
public class BSTimplementation {

	Node root;
	public BSTimplementation() {
		// TODO Auto-generated constructor stub
		this.root = null;
	}
	
	void insert(int id,String name,String address){
		root = insertRec(root,id,name,address);
	}

     Node insertRec(Node root, int id,String name,String address) {
    	if(root == null){
    		root = new Node(id,name,address);
    		System.out.println("inserted");
    		return root;
    	}
    	else{
    		
    		if(id < root.id){
    			root.left = insertRec(root.left, id,name,address);
    		}
    		else if(id > root.id){
    			root.right = insertRec(root.right, id,name,address);
    		}
    		
    		return root;
    	}
	}
     void inorder(){
    	 inorderRec(root);
     }

	 void inorderRec(Node root) {
		 if(root != null){
			 inorderRec(root.left);
			 System.out.println(root.id+" "+root.name+" "+root.address);
			 inorderRec(root.right);
		 }
		
	}
	 
	 
	 public static void main(String[] args) {
		 BSTimplementation obj = new BSTimplementation();
		  obj.insert(1," A","BCD");
		  obj.insert(2," B","CDE"); 
		  obj.insert(3," C","DEF");
		  obj.insert(4," D","EFG");
		  obj.inorder();
	}
}
