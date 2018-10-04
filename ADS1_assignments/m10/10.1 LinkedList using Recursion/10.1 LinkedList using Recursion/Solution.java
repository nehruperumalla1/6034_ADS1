import java.util.Scanner;
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

/**
 * Class for linked list record.
 */
class LinkedListRec {
    /**
     * Head Node of the Linked List points to First Element in the List.
     */
    private Node head;
    /**
     * Curr Node of the Linked List points to elements in List.
     */
    private Node curr;
    /**
     * Before Node points to left Node to Curr Node in the List.
     */
    private Node before;
    /**
     * After Node points to right Node to Curr Node in the List.
     */
    private Node after;
    /**
     * Size of the List.
     */
    private int size;
    /**
     * Counter to used insert element at Particular Location.
     */
    private int counter;
    /**
     * Constructs the object.
     */
    LinkedListRec() {
        head = null;
        before = null;
        counter = 1;
        size = 0;
    }

    /**
     * Inserting value at Particaular Location Using Recursion.
     * Complexity of insertAt is O(N).
     * The recursion traverses based on the Position.
     * The worst case of position would be N.
     * Then it will traverse through N elements
     * Then worst case complexity would be O(N).
     *
     * @param      pos        The position
     * @param      value      The value
     *
     * @throws     Exception  { If pos is invalid }
     */
    public void insertAt(final int pos, final int value) throws Exception {
        Node position = new Node(value);
        if (size < pos || pos < 0) {
            throw new Exception("Can't insert at this position.");
        }
        if (head == null) {
            head = position;
            curr = head;
            size++;
            return;
        } else if (pos == 0) {
            position.setNext(head);
            head = position;
            curr = head;
            size++;
            return;
        } else if (pos == counter) {
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

    /**
     * Reverse the Linked List using recursion.
     * The complexity of reverse Method is O(N).
     * Because it reverses all elements from first to last.
     * Then complexity would be O(N).
     *
     * @throws     Exception  { Reversing if Size is 0 }
     */
    public void reverse() throws Exception {
        if (size == 0) {
            throw new Exception("No elements to reverse.");
        }
        after = curr.getNext();
        curr.setNext(before);
        before = curr;
        if (after == null) {
            head = curr;
            before = null;
            return;
        }
        curr = after;
        reverse();
    }

    /**
     * It is used to print the Linked List.
     * For printing complexity would be O(N).
     * It iterates through out the List and prints all elements
     * Then its complexity would be O(N).
     */
    public void printList() {
        while (curr.getNext() != null) {
            System.out.print(curr.getData() + ", ");
            curr = curr.getNext();
        }
        System.out.println(curr.getData());
        curr = head;
    }
}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Not Using this Constructor.
    }
    /**
     * Main Method for implementing LinkedList Using Recursion.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        LinkedListRec list = new LinkedListRec();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
                case "insertAt":
                try {
                    list.insertAt(Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]));
                    list.printList();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "reverse":
                try {
                    list.reverse();
                    list.printList();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                default:
                break;
            }
        }
    }
}
