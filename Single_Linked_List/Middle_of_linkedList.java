package Single_Linked_List;

public class Middle_of_linkedList {
	Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}
		void printMiddle() {
			Node slow_ptr = head;
			Node fast_ptr = head;
			if (head != null) {
				while (fast_ptr != null && fast_ptr.next != null) {
					fast_ptr = fast_ptr.next.next;
					slow_ptr = slow_ptr.next;
				}
				System.out.println(slow_ptr.data);
			}
		}
		
		void insert(int newdata) {
			Node newNode = new Node(newdata);
			newNode.next = head;
			head = newNode;
		}

		public void printList() {
			Node tnode = head;
			while (tnode != null) {
				System.out.print(tnode.data + "->");
				tnode = tnode.next;
			}
			System.out.println("NULL");
		}

	public static void main(String[] args) {
		Middle_of_linkedList llist = new Middle_of_linkedList();
		llist.insert(0);
		llist.insert(1);
		llist.insert(2);
		llist.insert(3);
		llist.insert(4);
		llist.insert(5);
		llist.printList();
		llist.printMiddle();
	}

}
