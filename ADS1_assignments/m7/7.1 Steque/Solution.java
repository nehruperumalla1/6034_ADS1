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
	Node(int value) {
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
	public void setData(int value) {
		this.data = value;
	}

	/**
	 * Sets the next.
	 *
	 * @param      address  The address
	 */
	public void setNext(Node address) {
		this.next = address;
	}
}


/**
 * Class for LinkedList.
 */
class LinkedList {
	/**
	 * Head of Type Node.
	 */
	private Node head;
	/**
	 * Tail of Type Node.
	 */
	private Node tail;
	/**
	 * Size of a LinkedList.
	 */
	private int size = 0;
	/**
	 * Constructs the object.
	 */
	LinkedList() {
		//Not using this Constructor.
	}

	/**
	 * Push Method to Push the elements to LinkedList.
	 *
	 * @param      data  The data
	 */
	public void push(int data) {
		Node start = new Node(data);
		size++;
		while (head == null) {
			head = start;
			tail = start;
			printList();
			return;
		}
		start.setNext(head);
		head = start;
		printList();
	}

	/**
	 * Pop Method is used to Pop the Elements from the LinkedList.
	 */
	public void pop() {
		if (size() == 0) {
			System.out.println("Steque is empty.");
			return;
		}
		Node temp = head;
		head = head.getNext();
		temp.setNext(null);
		size--;
		printList();
	}

	/**
	 * Enqueue method to Enqueue elements to LinkedList.
	 *
	 * @param      data  The data
	 */
	public void enqueue(int data) {
		Node end = new Node(data);
		size++;
		if (head == null) {
			head = end;
			tail = end;
			printList();
			return;
		}
		tail.setNext(end);
		tail = end;
		printList();
	}

	/**
	 * Size of a LinkedList.
	 *
	 * @return     { Returns Integer Value }
	 */
	public int size() {
		return size;
	}

	/**
	 * { Clear Method is used to Clear all Nodes }.
	 */
	public void clear() {
		head = null;
		tail = null;
	}
	/**
	 * { Prints the LinkedList Values }.
	 */
	public void printList() {
		Node temp = head;
		if (size > 0) {
			while (temp.getNext() != null) {
				System.out.print(temp.getData() + ", ");
				temp = temp.getNext();
			}
			System.out.println(temp.getData());
		} else {
			System.out.println("Steque is empty.");
		}
	}

}
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//Not Using this Constructor.
	}
	/**
	 * Main Method for Steque for Push, Pop, Enqueue.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int times = scan.nextInt();
		scan.nextLine();
		LinkedList listobj;
		listobj = new LinkedList();
		while (scan.hasNext()) {
			String line = scan.nextLine();
			if (line.length() == 0) {
				listobj.clear();
				System.out.println();
			}
			String[] operation = line.split(" ");
			switch (operation[0]) {
				case "push":
					listobj.push(Integer.parseInt(
						operation[1]));
				break;
				case "pop":
					listobj.pop();
				break;
				case "enqueue":
					listobj.enqueue(Integer.parseInt(
						operation[1]));
				break;
				default:
				break;
			}
		}
	}
}