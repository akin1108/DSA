package Single_Linked_List;

import java.util.*;

public class Deletion {

	static Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public Node insert(int newdata) {
		Node newNode = new Node(newdata);
		newNode.next = head;
		head = newNode;
		return head;
	}

	public void del_given_pos(int pos) {
		if (head == null) {
			// if linked list is empty
			return;
		}
		Node prev = head;

		// head needs to be removed
		if (pos == 0) {
			head = prev.next; // change head
			return;
		}

		// find previous node of the node at given position
		for (int i = 0; prev != null && i < pos - 1; i++) {
			prev = prev.next;
		}

		// if position is greater than size of list
		if (prev == null || prev.next == null) {
			return;
		}

		// make next of previous node as next of it's next node
		prev.next = prev.next.next;
	}

	// Given a ‘key’, delete the first occurrence of this key in linked list
	public void del_key(int key) {
		Node temp = head;
		Node prev = null;

		// if element/key to be deleted is at head
		if (temp != null && temp.data == key) {
			temp = temp.next; // make next node as head node
			return;
		}

		// Search for the key to be deleted, keep track of the previous node as we need
		// to change temp.next
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

		// if key is not present
		if (temp == null) {
			return;
		}

		// Unlink the node from linked list
		prev.next = temp.next;

	}

	void del_complete() {
		head = null;
	}

	public void print() {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}

	public static void main(String args[]) {
		Deletion del = new Deletion();
		Scanner sc = new Scanner(System.in);
		int choose = 0;
		while (choose != -1) {
			System.out.println(
					"\n\n1.Insert \n2. Delete at given position\n3. Delete given element\n4. Delete complete list \n5. Display");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				System.out.println("Enter value:");
				int val = sc.nextInt();
				head = del.insert(val);
				break;

			case 2:
				System.out.println("Enter value:");
				int val1 = sc.nextInt();
				del.del_given_pos(val1);
				break;
				
			case 3:
				System.out.println("Enter value:");
				int val2 = sc.nextInt();
				del.del_key(val2);
				break;
				
			case 4:
				del.del_complete();
				break;
				
			case 5:
				del.print();
				break;
			}
		}
	}
}
