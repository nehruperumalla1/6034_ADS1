import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Not using this Constructor.
    }
    /**
     * Main Method for Implementing operation for Queue using Linked List.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Operations op = new Operations();
        int num = scan.nextInt();
        while (scan.hasNext()) {
            String[] operation = scan.nextLine().split(" ");
            switch (operation[0]) {
                case "pushLeft":
                    op.insertAtHead(Integer.parseInt(operation[1]));
                break;
                case "pushRight":
                    op.insertAtTail(Integer.parseInt(operation[1]));
                break;
                case "popLeft":
                    op.popAtHead();
                break;
                case "popRight":
                    op.popAtTail();
                break;
                case "size":
                System.out.println(op.size());  
                break;
                default:
                break;
            }
        }
    }
}
