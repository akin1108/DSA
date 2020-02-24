package Single_Linked_List;

import java.util.*;

public class Insertion {

	static Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}
	

	public Node insert_first(int newData) {
		
		/*1. Allocate node and put data
		 *2. Make next of new node as head
		 *3. Move head to point new node
		 */
		
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;
		return head;
	}

	public Node insert_after(int pos, int new_Data) {
		
		/* 1. Allocate new node and put data
		 * 2. If the Linked List is empty, then make the new node as head
		 * 3. Initialize counter and initialize a temporary node "prev"
		 * 4. When previous node is not last node traverse and increase counter
		 * 5. When counter = position, Make next of new Node as next of prev_node & make next of prev_node as new_node
		 * 6. if given position is greater than length of list give error
		 * */
		Node new_Node = new Node(new_Data);
		if (head == null) {
			head = new Node(new_Data);
		}
		int count = 0;
		Node prev = head;
		while (prev.next != null) {
			if (count == pos) {
				new_Node.next = prev.next;
				prev.next = new_Node;
				break;
			}
			prev = prev.next;
			count++;
		}
		if (pos > count) {
			System.out.println("Index out of bound");
		}
		return head;
	}
	
	public void insert_last(int newdata) {
		/* 1. Allocate the Node & 
		 * 2. Put in the data
		 * 3. Set next as null 
		 * 4. If the Linked List is empty, then make the new node as head. This new node is going to be the last node, so make next of it as null
		 * 5. Else traverse till the last node
		 * 6. Change the next of last node
		 */
		Node newnode = new Node(newdata);
		if(head == null) {
			head = new Node(newdata);
		}
		newnode.next = null;
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		last.next = newnode;
		return;
	}

	public void printList() {
		System.out.println("Displaying:");
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}

	public static void main(String[] args) {
		Insertion ll_insert = new Insertion();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while (choice != -1) {
			System.out.println("\n\n1.Insert Start\n2. Insert middle\n3. Insert Last\n4. Display");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter value:");
				int val = sc.nextInt();
				head = ll_insert.insert_first(val);
				break;
			case 2:
				System.out.println("Enter position and value :");
				int pos = sc.nextInt();
				int val1 = sc.nextInt();
				head = ll_insert.insert_after(pos, val1);
				break;
			case 3:
				System.out.println("Enter Value :");
				int val2 = sc.nextInt();
				ll_insert.insert_last(val2);
				break;
			case 4:
				ll_insert.printList();
				break;
			}
		}

	}

}
