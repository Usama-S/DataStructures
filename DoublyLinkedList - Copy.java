
public class Node<T> {
	
	public Node<T> prev;
	public T data;
	public Node<T> next;

}


public class DoublyLinkedList<T> {
	Node<T> head;
	
	//--------------Add method----------//
	void add(T data){
		Node<T> nNode = new Node<T>();
		nNode.data = data;
		nNode.prev = null;
		nNode.next = null;
		
		if (head == null){
			head = nNode;
		}
		else {
			Node<T> tNode = head;
			while(tNode.next != null){
				tNode = tNode.next;
			}
			tNode.next = nNode;
			nNode.prev = tNode;
		}
	}

	//--------------Insert After method----------//
	void insertAfter(T reference, T data){
		Node<T> newNode = new Node<T>();
		newNode.data = data;
		newNode.prev = null;
		newNode.next = null;
		
		Node<T> tNode = head;
		while (tNode != null){
			if (tNode.data == reference){
				Node<T> temp = tNode.next;
				tNode.next = newNode;
				newNode.prev = tNode;
				newNode.next = temp;
				temp.prev = newNode;
				break;
			}
			tNode = tNode.next;
		}
	}

	//--------------Find method----------//
	boolean find(T target){
		Node<T> tNode = head;
		while (tNode != null){
			if (tNode.data == target)
				return true;
			tNode = tNode.next;
		}
		return false;
	}

	//--------------Remove method----------//
	void remove(T data){
		Node<T> tNode = head;
		Node<T> pNode = head;
		Node<T> nNode = head.next;
		if (tNode.data == data){
			head = head.next;
			head.prev = null;
		}
		else {
			while (tNode != null){
				if (tNode.data == data){
					pNode.next = nNode;
					nNode.prev = pNode;
					break;
				}
				pNode = tNode;
				tNode = tNode.next;
				nNode = tNode.next;
			}
		}
	}

	//--------------Remove All method----------//
	void removeAll(){
		head = null;
		System.out.println(head);
	}

	//--------------Display method----------//
	void display(){
		Node<T> tNode = head;
		while(tNode != null){
			System.out.print(tNode.data + "   ");
			tNode = tNode.next;
		}
		System.out.println();
	}

	public static void main(String[] args){
		
		DoublyLinkedList<Integer> l = new DoublyLinkedList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(5);
		l.add(6);
		l.add(7);
		l.add(8);
		l.add(8);
		l.add(9);
		
		l.display();
		
		l.insertAfter(3, 4);
		l.display();
		
		System.out.println(l.find(45));
		
		l.remove(8);
		l.display();
		
		l.removeAll();
		l.display();
		
	}
	
}













