package assignment3;

interface priorityQueue {
	public void insert(int x);

	public int remove();

	public int getPeek();

	public boolean isFull();

	public boolean isEmpty();

}

public class PriorityQueueImplementation implements priorityQueue {
	public int arr[];
	int size, currentItem;

	PriorityQueueImplementation(int size) {
		this.size = size;
		this.arr = new int[this.size];
		this.currentItem = 0;
	}

	@Override
	public void insert(int value) {
		int i;
		if (this.currentItem == 0) {
			this.arr[0] = value;
			this.currentItem++;
			return;
		} else {
			for (i = this.currentItem - 1; i >= 0; i--) {
				if (value > this.arr[i]) {
					this.arr[i + 1] = this.arr[i];
				} else {
					break;
				}
			}

		}
		this.arr[i + 1] = value;
		this.currentItem++;
	}

	@Override
	public int remove() {
	
		if(isEmpty()){
			System.out.println("queue is empty");
			return -1;
		}
		else{
		//System.out.println("current item in the queue is"+ currentItem);
		return this.arr[--this.currentItem];
		}
	}

	@Override
	public int getPeek() {
		return this.arr[this.currentItem - 1];
	}

	@Override
	public boolean isFull() {
		return this.currentItem == size;
	}

	@Override
	
	public boolean isEmpty() {
		return this.currentItem == 0;
	}
	public void print(){
		for(int i=0; i< this.currentItem;i++){
			System.out.println(this.arr[i]);
		}
	}
 
	public static void main(String[] args) {
		PriorityQueueImplementation  obj = new PriorityQueueImplementation(5);
		obj.insert(10);
		obj.insert(20);
		obj.insert(15);
		obj.insert(25);
		obj.insert(35);
		obj.print();
		System.out.println(obj.getPeek());
		System.out.println(obj.getPeek());
		System.out.println(obj.remove());
		System.out.println(obj.remove());
		System.out.println(obj.remove());
		System.out.println(obj.remove());
		System.out.println(obj.remove());
		//System.out.println(obj.remove());
		
		
		
	}
}
