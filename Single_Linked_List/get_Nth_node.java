package Single_Linked_List;

public class get_Nth_node {
	
	static Node head;
	class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	void insert(int newdata) {
		Node newNode = new Node(newdata);
		newNode.next = head;
		head = newNode;
	}
	
	void get_node(int index) {
		Node current = head;
		int count = 0;
		while(current != null ) {
			if(count == index) {
				System.out.println("\nValue at index "+index+" is: "+current.data); ;
			}
			count++;
			current = current.next;
		}
		
		if(index > count) {
			System.out.println("Index not found");
		}
	}
	
	void display() {
		System.out.println("Displaying:");
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}
	
	public static void main(String[] args) {
		get_Nth_node gnn = new get_Nth_node();
		gnn.insert(0);
		gnn.insert(1);
		gnn.insert(2);
		gnn.insert(3);
		gnn.insert(4);
		gnn.display();
		gnn.get_node(3);
	}

}
