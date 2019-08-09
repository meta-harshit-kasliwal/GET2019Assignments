package assignment5;

import assignment5.Node;

public class LinkedList {
	Node head;

	public Node insert(int id, int salary, int age) {
		Node node = new Node(id, salary, age);
		node.obj.age = age;
		node.obj.id = id;
		node.obj.salary = salary;
		node.next = null;

		if (head == null) {
			head = node;
			return head;
		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
			return n;
		}

	}

	public Node sort() {
		Node ptr1 = head;
		while (ptr1 != null) {
			Node ptr2 = ptr1.next;
			while (ptr2 != null) {
				if (ptr1.obj.salary < ptr2.obj.salary) {
					swapSalary(ptr1, ptr2);
					swapId(ptr1, ptr2);
					swapAge(ptr1, ptr2);
				} else if (ptr1.obj.salary == ptr2.obj.salary) {
					if (ptr1.obj.age > ptr2.obj.age) {
						swapSalary(ptr1, ptr2);
						swapId(ptr1, ptr2);
						swapAge(ptr1, ptr2);
					}
				}
				ptr2 = ptr2.next;
			}
			ptr1 = ptr1.next;
		}
		return head;
	}

	public void swapSalary(Node a, Node b) {
		int t = b.obj.salary;
		b.obj.salary = a.obj.salary;
		a.obj.salary = t;
	}

	public void swapId(Node a, Node b) {
		int id = b.obj.id;
		b.obj.id = a.obj.id;
		a.obj.id = id;
	}

	public void swapAge(Node a, Node b) {
		int t = b.obj.age;
		b.obj.age = a.obj.age;
		a.obj.age = t;
	}

	public void display() {

		Node n = head;
		while (n.next != null) {
			System.out.println(n.obj.id + " " + n.obj.salary + " " + n.obj.age);
			n = n.next;
		}
		System.out.println(n.obj.id + " " + n.obj.salary + " " + n.obj.age);
		;
	}

	public static void main(String[] args) {

		LinkedList obj = new LinkedList();
		obj.insert(1, 10000, 10);
		obj.insert(2, 10000, 20);
		obj.insert(3, 2000, 30);
		obj.insert(4, 8000, 40);
		System.out.println("before sorting");
		obj.display();
		System.out.println("after sorting");
		obj.sort();
		obj.display();

	}
}
