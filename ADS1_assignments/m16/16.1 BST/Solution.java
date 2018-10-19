import java.util.Scanner;

/**
 * Class for book.
 */
class Book {
    /**
     * Book Name.
     */
    private String bname;
    /**
     * Author name.
     */
    private String aname;
    /**
     * Price of the Book.
     */
    private double price;
    /**
     * Constructs the object.
     *
     * @param      name  The name
     * @param      naam  The naam
     * @param      cost  The cost
     */
    Book(final String name, final String naam, final double cost) {
        bname = name;
        aname = naam;
        price = cost;
    }

    /**
     * Gets the book name.
     *
     * @return     The b name.
     */
    public String getBName() {
        return bname;
    }
}

/**
 * Class for node.
 *
 * @param      <Value>  The value
 */
class Node<Value> {
    /**
     * Book Object.
     */
    private Book boo;
    /**
     * Value Type -- Quantity.
     */
    private Value val;
    /**
     * Left Node.
     */
    private Node left;
    /**
     * Right Node.
     */
    private Node right;
    /**
     * Constructs the object.
     *
     * @param      bobj  The bobj
     * @param      vals  The vals
     */
    Node(final Book bobj, final Value vals) {
        boo = bobj;
        val = vals;
        left = null;
        right = null;
    }

    /**
     * Gets the book.
     *
     * @return     The book.
     */
    public Book getBook() {
        return boo;
    }

    /**
     * Sets the value.
     *
     * @param      values  The values
     */
    public void setValue(final Value values) {
        val = values;
    }

    /**
     * Gets the value.
     *
     * @return     The value.
     */
    public Value getValue() {
        return val;
    }

    /**
     * Sets the left Node Address.
     *
     * @param      lef   The lef
     */
    public void setLeft(final Node lef) {
        this.left = lef;
    }

    /**
     * Sets the right Node Address.
     *
     * @param      rig   The rig
     */
    public void setRight(final Node rig) {
        this.right = rig;
    }

    /**
     * Gets the left Node Address.
     *
     * @return     The left.
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Gets the Right Node Address.
     *
     * @return     The right.
     */
    public Node getRight() {
        return right;
    }
}

/**
 * Class for BST.
 *
 * @param      <Value>  The value
 */
class Bst<Value> {
    /**
     * Node Object Head points to Parent Node.
     */
    private Node head;

    /**
     * Constructs the object.
     */
    Bst() {
    }

    /**
     * Implementation of Put method.
     * Keeping the Book Object and Value in Node according BST.
     * The complexity of Put is O(N).
     * During the worst case it iterates through out the nodes.
     *
     * @param      bookobj  The bookobj
     * @param      val      The value
     */
    public void put(final Book bookobj, final Value val) {
        Node nod = new Node(bookobj, val);
        if (head == null) {
            head = nod;
        } else {
            Node temp = head;
            while (temp != null) {
                Book boo = temp.getBook();
                Book bol = nod.getBook();
                int cmp = boo.getBName().compareTo(bol.getBName());
                if (cmp > 0) {
                    if (temp.getLeft() == null) {
                        temp.setLeft(nod);
                        break;
                    }
                    temp = temp.getLeft();
                } else if (cmp < 0) {
                    if (temp.getRight() == null) {
                        temp.setRight(nod);
                        break;
                    }
                    temp = temp.getRight();
                } else {
                    temp.setValue(nod.getValue());
                    temp = head;
                    break;
                }
            }
        }
    }

    /**
     * Implementing Get Method.
     * Complexity of Get Method is O(logN).
     * It iterates through the Nodes according to search Node.
     * If the Search Node is Greater than mid it iterates through right
     * side Eleements.
     *
     * @param      bobj  The bobj
     *
     * @return     { Returns value of the required object }
     */
    public Value get(final Book bobj) {
        Node tempnode = binarySearch(bobj);
        if (tempnode == null) {
            return null;
        }
        Value val = (Value) tempnode.getValue();
        return val;
    }

    /**
     * Binary Search Implementation.
     * Complexity of Binary Search is O(N).
     * In worst case the LinkedList iterates through all Nodes.
     * So, the worst case complexity is O(N).
     *
     * @param      bobj  The bobj
     *
     * @return     { Returns Node contains Book Object, Value }
     */
    public Node binarySearch(final Book bobj) {
        Node temp = head;
        while (temp != null) {
            Book bookobj = temp.getBook();
            int cmp = bobj.getBName().compareTo(bookobj.getBName());
            if (cmp > 0) {
                temp = temp.getRight();
            } else if (cmp < 0) {
                temp = temp.getLeft();
            } else {
                return temp;
            }
        }
        return null;
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
    }
    /**
     * Main method to Implement Binary Search Tree API.
     * Implementing put, get methods.
     * Complexity of Put is O(N).
     * Complexity of Get is O(N).
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sca = new Scanner(System.in);
        String[] input = null;
        Bst<Integer> binary = new Bst<Integer>();
        while (sca.hasNext()) {
            input = sca.nextLine().split(",");
            switch (input[0]) {
                case "get":
                    System.out.println(binary.get(new Book(input[1], input[2],
                        Double.parseDouble(input[2 + 1]))));
                break;
                case "put":
                    binary.put(new Book(input[1], input[2],
                        Double.parseDouble(input[2 + 1])),
                        Integer.parseInt(input[2 + 2]));
                break;
                default:
                break;
            }
        }
    }
}
