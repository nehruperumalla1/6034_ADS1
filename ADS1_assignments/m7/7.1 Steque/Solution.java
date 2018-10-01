import java.util.Scanner;
import java.util.Arrays;
class Node {
	private int data;
	private Node next;
	Node(int value) {
		data = value;
		next = null;
	}

	public int getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void setData(int value) {
		this.data = value;
	}

	public void setNext(Node address) {
		this.next = address;
	}
}


class LinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	LinkedList() {
		//Not using this Constructor.
	}

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

	public int size() {
		return size;
	}

	public void clear() {
		head = null;
		tail = null;
	}
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
	public static void main(String[] args) {
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
					listobj.push(Integer.parseInt(operation[1]));
				break;
				case "pop":
					listobj.pop();
				break;
				case "enqueue":
					listobj.enqueue(Integer.parseInt(operation[1]));
				break;
			}
		}
	}
}