import java.util.Scanner;
import java.util.Arrays;
class Node {
    int data;
    Node next;
    Node(int value) {
        data = value;
        next = null;
    }
    // Node head;
    public Node getAddress() {
        return next;
    }
    public void setAddress(Node address) {
        next = address;
    }

    public void setdata(int data1) {
        data = data1;
    }
}

class Operations {
    Node head;
    Node tail;
    int size;
    public void insertAtTail(int data) {
        Node end = new Node(data);
        size++;
        if (head == null) {
            head = end;
            tail = end;
            return;
        }
        tail.next = end;
        tail = end;
        return;
    }

    public void popAtHead() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        Node temp = head;
        head = head.getAddress();
        temp = null;
        size--;
    }
    public String printList() {
        Node temp = head;
        String str = "[";
        if (size > 0) {
            while (temp.next != null) {
                str += temp.data + ", ";
                temp = temp.getAddress();
            }
            str += temp.data;
        }
        str += "]";
        return str;
    }
    public int size() {
        return size;
    }

 	public int[] josephus(int m, int size) {
        int[] arr = new int[size];
        Node temp = head;
        int counter = 1;
        int i = 0;
        while (temp.next != null) {
            while (counter != m) {
                insertAtTail(temp.data);
                temp = temp.next;
                popAtHead();
                counter++;
            }
        arr[i++] = temp.data;
        temp = temp.next;
        counter = 1;
        popAtHead();
        }
        arr[i++] = temp.data;
        return arr;
   }
}
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < num; i++) {
			Operations op = new Operations();
			String jose = scan.nextLine();
			String[] jos = jose.split(" ");
			int k = Integer.parseInt(jos[0]);
			int m = Integer.parseInt(jos[1]);
			for (int j = 0; j < k; j++) {
				op.insertAtTail(j);
			}
			int[] josephus = op.josephus(m, k);
			for (int p = 0; p < josephus.length - 1; p++) {
				System.out.print(josephus[p] + " ");
			}
			System.out.println(josephus[josephus.length - 1]);
		}
	}
}