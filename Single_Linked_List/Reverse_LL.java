package Single_Linked_List;

public class Reverse_LL {

	static Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node reverse(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

	void insert(int newdata) {
		Node newNode = new Node(newdata);
		newNode.next = head;
		head = newNode;
	}

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		Reverse_LL rll = new Reverse_LL();
		rll.insert(0);
		rll.insert(1);
		rll.insert(2);
		rll.insert(3);
		rll.insert(4);
		rll.insert(5);
		rll.printList(head);
		head = rll.reverse(head);
		System.out.println("\n");
		rll.printList(head);

	}

}
