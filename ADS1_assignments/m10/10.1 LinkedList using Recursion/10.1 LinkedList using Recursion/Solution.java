import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for node.
 */
class Node {
    /**
     * Data Variable for Node.
     */
    private int data;
    /**
     * Next Node Address.
     */
    private Node next;
    /**
     * Constructs the object.
     *
     * @param      value  The value
     */
    Node(final int value) {
        data = value;
        next = null;
    }

    /**
     * Gets the data.
     *
     * @return     The data.
     */
    public int getData() {
        return data;
    }

    /**
     * Gets the next.
     *
     * @return     The next.
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets the data.
     *
     * @param      value  The value
     */
    public void setData(final int value) {
        this.data = value;
    }

    /**
     * Sets the next.
     *
     * @param      address  The address
     */
    public void setNext(final Node address) {
        this.next = address;
    }
}

class LinkedListRec {
	Node head;
	Node curr;
	Node before;
	Node after;
	int size;
	int counter;
	LinkedListRec() {
		head = null;
		counter = 1;
		size = 0;
	}

	public void insertAt(int pos, int value) throws Exception {
		Node position = new Node(value);
		if (size < pos || pos < 0) {
			throw new Exception("Can't insert at this position.");
		}
		if (head == null) {
			head = position;
			curr = head;
			size++;
			return;
		}else if (pos == 0) {
			position.setNext(head);
			head = position;
			curr = head;
			size++;
			return;
		}else if (pos == counter) {
			position.setNext(curr.getNext());
			curr.setNext(position);
			curr = head;
			counter = 1;
			size++;
			return;
		}
		curr = curr.getNext();
		counter++;
		insertAt(pos, value);
	}

	public void reverse() throws Exception {
		if (size == 0) {
			throw new Exception("No elements to reverse.");
		}
		after = curr.getNext();
		curr.setNext(before);
		before = curr;
		if (after == null) {
			return ;
		}
		curr = after;
		reverse();
	}

	public void printList() {
		while (curr.getNext() != null) {
			System.out.print(curr.getData() + ", ");
			curr = curr.getNext();
		}
		System.out.println(curr.getData());
		curr = head;
	}
}

public class Solution {
	public static void main(String[] args) {
		LinkedListRec list = new LinkedListRec();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
				case "insertAt":
				try {
					list.insertAt(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
					list.printList();
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				case "reverse":
				try {
					list.reverse();
					list.printList();
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				default:
				break;
			}
		}

	}
}