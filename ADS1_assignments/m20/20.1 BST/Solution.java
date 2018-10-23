import java.util.Scanner;
/**
 * Class for book.
 */
class Book {
    /**
     * Name of the Book.
     */
    private String name;
    /**
     * Name of the Author.
     */
    private String author;
    /**
     * Price of the Book.
     */
    private double price;
    /**
     * Constructs the object.
     *
     * @param      bname    The bname
     * @param      bauthor  The bauthor
     * @param      bprice   The bprice
     */
    Book(final String bname, final String bauthor, final double bprice) {
        name = bname;
        author = bauthor;
        price = bprice;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * To string method to print.
     */
    public void tostring() {
        System.out.println(name + ", " + author + ", " + price);
    }
}

/**
 * Class for bst operations.
 *
 * @param      <Value>  The value
 */
class BstOperations<Value> {
    /**
     * Head Node in Binary Search Tree.
     */
    private Node head;
    /**
     * Constructs the object.
     */
    BstOperations() { }

    // private int checkHeight(Node x) {
    //  int diff = size(x.left) - size(x.right);
    //  return diff;
    // }

    // public void checkBalance() {
    //  checkBalance(head);
    // }

    // private Node checkBalance(Node root) {
    //  if (root == null) {
    //      return null;
    //  } else {
    //      if (checkHeight(root) > 1) {
    //          rightRotate(root);
    //      } else {
    //          checkBalance
    //      }

    //  }
    // }
    /**
     * Puts the Book of Node Type and Value in Node.
     * Puts in Bainry Search Tree using binary search.
     * Complexity of Put is h.
     * Where h is height of the tree.
     *
     * @param      bookobj  The bookobj
     * @param      val      The value
     */
    public void put(final Node bookobj, final Value val) {
        head = put(head, bookobj, val);
    }
    /**
     * Puts the Book of Node Type and Value in Node.
     * Puts in Bainry Search Tree using binary search.
     * Complexity of Put is h.
     * Where h is height of the tree.
     *
     * @param      root     The root
     * @param      bookobj  The bookobj
     * @param      val      The value
     *
     * @return     { Returns Node }.
     */
    private Node put(final Node root, final Node bookobj, final Value val) {
        Node temp;
        if (root == null) {
            bookobj.setValue(val);
            return bookobj;
        } else {
            int cmp = compare(root, bookobj);
            if (cmp < 0) {
                root.left = put(root.left, bookobj, val);
            } else if (cmp > 0) {
                root.right = put(root.right, bookobj, val);
            } else {
                root.setValue(val);
            }
            root.size = 1 + size(root.left) + size(root.right);
        }
        return root;
    }
    /**
     * Size of the Node.
     * Gives the size of that particular Node
     * which includes its children nodes.
     * Complexity of Size is O(1).
     *
     * @return     { Returns size of Integer Type }.
     */
    public int size() {
        if (head == null) {
            return 0;
        }
        return size(head);
    }
    /**
     * Size of the Node.
     * Gives the size of that particular Node.
     * which includes its children nodes.
     * Complexity of Size is O(1).
     *
     * @param      x     { Node }
     *
     * @return     { Returns size of the Node of Integer Type }.
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }
    /**
     * Gets the Value of given Object.
     * Complexity of get is is h.
     * Where h is height of the tree.
     *
     * @param      bookobj  The bookobj
     *
     * @return     { Returns the value of given object }.
     */
    public Value get(final Node bookobj) {
        Node x = get(head, bookobj);
        if (x == null) {
            return null;
        }
        return (Value) x.getValue();
    }

    /**
     * Compares the Names of two Objects.
     *
     * @param      root     The root
     * @param      bookobj  The bookobj
     *
     * @return     { Returns the difference i=of integer type }.
     */
    public int compare(final Node root, final Node bookobj) {
        Book book = bookobj.getBook();
        Book rbook = root.getBook();
        return book.getName().compareTo(rbook.getName());
    }
    /**
     * Gets the Value of given Object.
     * Complexity of get is is h.
     * Where h is height of the tree.
     *
     * @param      root     The root
     * @param      bookobj  The bookobj
     *
     * @return     { Returns the Required Node }
     */
    private Node get(final Node root, final Node bookobj) {
        if (bookobj == null) {
            return null;
        } else if (root == null) {
            return null;
        } else {
            int cmp = compare(root, bookobj);
            if (cmp > 0) {
                return get(root.right, bookobj);
            } else if (cmp < 0) {
                return get(root.left, bookobj);
            } else {
                return root;
            }
        }
    }
    /**
     * Floor Method.
     * It is used to find the item which is less than or equal to given item.
     * Complexity of Floor is h.
     * Where h is height of the tree.
     *
     * @param      bookobj  The bookobj
     */
    public void floor(final Node bookobj) {
        Node x = floor(bookobj, head);
        if (x == null) {
            System.out.println("null");
            return;
        }
        x.getBook().tostring();
    }
    /**
     * Floor Method.
     * It is used to find the item which is less than or equal to given item.
     * Complexity of Floor is h.
     * Where h is height of the tree.
     *
     * @param      bookobj  The bookobj
     * @param      x        { Node }
     *
     * @return     { Returns object less or equal to given obj }
     */
    private Node floor(final Node bookobj, final Node x) {
        if (bookobj == null) {
            return null;
        } else if (x == null) {
            return null;
        } else {
            int cmp = compare(x, bookobj);
            if (cmp < 0) {
                return floor(bookobj, x.left);
            } else if (cmp == 0) {
                return x;
            }
            Node temp = floor(bookobj, x.right);
            if (temp != null) {
                return temp;
            } else {
                return x;
            }
        }
    }
    /**
     * Maximum Method.
     * It is used to findout the Max node in tree.
     * Complexity is is h.
     * Where h is height of the tree.
     */
    public void max() {
        Node x = max(head);
        if (x == null) {
            return;
        }
    }
    /**
     * Maximum Method.
     * It is used to findout the Max node in tree.
     * Complexity is h.
     * Where h is height of the tree.
     *
     * @param      root  The root
     *
     * @return     { returns Max Node }.
     */
    private Node max(final Node root) {
        if (root == null) {
            return null;
        } else {
            if (max(root.right) == null) {
                root.getBook().tostring();
            }
        }
        return root;
    }
    /**
     * Minimum Method.
     * It is used to findout the min node in tree.
     * Complexity is h.
     * Where h is height of the tree.
     */
    public void min() {
        Node x = min(head);
        if (x == null) {
            return;
        }
    }
    /**
     * Minimum Method.
     * It is used to findout the min node in tree.
     * Complexity is h.
     * Where h is height of the tree.
     *
     * @param      root  The root
     *
     * @return     { Returns Min Node }.
     */
    private Node min(final Node root) {
        if (root == null) {
            return null;
        }
        if (max(root.left) == null) {
            root.getBook().tostring();
        }
        return root;
    }

    /**
     * Deleting the Min Node.
     * Min node is the leftMost Node in the tree.
     * Complexity of deletion is h.
     * Where h is height of the tree.
     */
    public void deleteMin() {
        head = deleteMin(head);
    }

    /**
     * Deleting the Min Node.
     * Min node is the leftMost Node in the tree.
     * Complexity of deletion is h.
     * Where h is height of the tree.
     *
     * @param      root  The root
     *
     * @return     { Returns the Root Node after deletion }.
     */
    private Node deleteMin(final Node root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        return root;
    }
    /**
     * Deleting the Max node.
     * Max node is the Rightmost tree in the node.
     * Complexity of Deleting Max is h.
     * where h is height of the tree.
     */
    public void deleteMax() {
       head = deleteMax(head);
    }
    /**
     * Deleting the Max node.
     * Max node is the Rightmost tree in the node.
     * Complexity of Deleting Max is h.
     * where h is height of the tree.
     *
     * @param      root  The root
     *
     * @return     { Returns the root Node after deletion }.
     */
    private Node deleteMax(final Node root) {
        if (root.right == null) {
            return root.left;
        }
        root.right = deleteMax(root.right);
        return root;
    }
    /**
     * Deleting spefic Node from tree.
     * Complexity of Deletion is h.
     * Where h is height of th tree.
     *
     * @param      bookobj  The bookobj
     */
    public void delete(final Node bookobj) {
        head = delete(head, bookobj);
    }
    /**
     * Deleting spefic Node from tree.
     * Complexity of Deletion is h.
     * Where h is height of th tree.
     *
     * @param      temproot     The root
     * @param      bookobj  The bookobj
     *
     * @return     { Returns the root node after deletion }.
     */
    private Node delete(final Node temproot, final Node bookobj) {
        Node root = temproot;
        if (root == null) {
            return null;
        }
        int cmp = compare(root, bookobj);
        if (cmp < 0) {
            root.left = delete(root.left, bookobj);
        } else if (cmp > 0) {
            root.right = delete(root.right, bookobj);
        } else {
            if (root.left == null && root.right == null) {
                root = deleteMin(root);
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                root = min(root.right);
                deleteMin(root.right);
            }
        }
        return root;
    }
    /**
     * Ceiling Method.
     * It finds out node which is larger than the given node.
     * The complexity of Ceiling is h.
     * Where h is height of the tree.
     *
     * @param      bookobj  The bookobj
     */
    public void ceiling(final Node bookobj) {
        Node x = ceiling(bookobj, head);
        if (x == null) {
            System.out.println("null");
            return;
        }
        x.getBook().tostring();
    }
    /**
     * Ceiling Method.
     * It finds out node which is larger than the given node.
     * The complexity of Ceilingis h.
     * Where h is height of the tree.
     *
     * @param      bookobj  The bookobj
     * @param      root     The root
     *
     * @return     { Returns Node }.
     */
    private Node ceiling(final Node bookobj, final Node root) {
        if (bookobj == null) {
            return null;
        } else if (root == null) {
            return null;
        } else {
            int cmp = compare(root, bookobj);
            if (cmp > 0) {
                return ceiling(bookobj, root.right);
            } else if (cmp == 0) {
                return root;
            }
            Node temp = ceiling(bookobj, root.left);
            if (temp != null) {
                return temp;
            } else {
                return root;
            }
        }
    }
    /**
     * Select the particular Node at given index.
     * Complexity of select is h.
     * Where h is height of the tree.
     *
     * @param      value  The value
     */
    public void select(final int value) {
        Node x = select(value, head);
        x.getBook().tostring();
    }
    /**
     * Select the particular Node at given index.
     * Complexity of select is h.
     * Where h is height of the tree.
     *
     * @param      val   The value
     * @param      root  The root
     *
     * @return     { Returns the Node at Given index }.
     */
    private Node select(final int val, final Node root) {
        if (root == null) {
            return null;
        }
        int length = size(root.left);
        if (length > val) {
            return select(val, root.left);
        } else if (length < val) {
            return select(val - length - 1, root.right);
        } else {
            return root;
        }
    }
}
/**
 * Class for Solution.
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
     * Complexity of Put is h.
     * Where h is height of the tree.
     * Complexity of Get is h.
     * Where h is height of the tree.
     * Complexity of floor is h.
     * Where h is height of the tree.
     * Complexity of ceiling is h.
     * Where h is height of the tree.
     * Complexity of select is h.
     * Where h is height of the tree.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sca = new Scanner(System.in);
        String[] input = null;
        BstOperations<Integer> binary = new BstOperations<Integer>();
        while (sca.hasNext()) {
            input = sca.nextLine().split(",");
            switch (input[0]) {
                case "get":
                    Node booknode = new Node(new Book(input[1], input[2],
                        Double.parseDouble(input[2 + 1])), 1);
                    System.out.println(binary.get(booknode));
                break;
                case "put":
                    booknode = new Node(new Book(input[1], input[2],
                        Double.parseDouble(input[2 + 1])), 1);
                    binary.put(booknode,
                        Integer.parseInt(input[2 + 2]));
                break;
                case "floor":
                    booknode = new Node(new Book(input[1], input[2],
                        Double.parseDouble(input[2 + 1])), 1);
                    binary.floor(booknode);
                break;
                case "ceiling":
                    booknode = new Node(new Book(input[1], input[2],
                        Double.parseDouble(input[2 + 1])), 1);
                    binary.ceiling(booknode);
                break;
                case "max":
                    binary.max();
                break;
                case "min":
                    binary.min();
                break;
                case "select":
                    binary.select(Integer.parseInt(input[1]));
                break;
                case "deleteMin":
                    binary.deleteMin();
                break;
                case "deleteMax":
                    binary.deleteMax();
                break;
                case "delete":
                    booknode = new Node(new Book(input[1], input[2],
                        Double.parseDouble(input[2 + 1])), 1);
                    binary.delete(booknode);
                break;
                default:
                break;
            }
        }
    }
}
