import java.util.Scanner;

/**
 * Class for separate chaining.
 */
class SeparateChaining {
    /**
     * Word Count in Magazine.
     */
    private int magCount;
    /**
     * Word Count in ransom Note.
     */
    private int ransomCount;
    /**
     * LinkedList Array for Hash.
     */
    private LinkedList[] hashing;
    /**
     * Constructs the object.
     *
     * @param      count        The count
     * @param      countRansom  The count ransom
     */
    SeparateChaining(final int count, final int countRansom) {
        magCount = count;
        ransomCount = countRansom;
        hashing = new LinkedList[magCount];
    }

    /**
     * Hash Code for String.
     *
     * @param      data  The data
     *
     * @return     { description_of_the_return_value }
     */
    public int hash(final String data) {
        return Math.abs(data.hashCode() % magCount);
    }
    /**
     * Put Method to put Key, Value pair.
     * Complexity of put is O(N).
     * Because it iterates through out the Linked List.
     *
     * @param      data1  The data 1
     */
    public void put(final String data1) {
        int i = hash(data1);
        if (hashing[i] == null) {
            LinkedList list = new LinkedList();
            hashing[i] = list;
            hashing[i].insertAtHead(data1, 1);
            return;
        }
        for (Node x = hashing[i].head; x != null; x = x.next) {
            if (x.data.equals(data1)) {
                x.value = x.value + 1;
                return;
            }
        }
        hashing[i].insertAtHead(data1, 1);
    }
    /**
     * Get Method to search given key.
     * Complexity of get is O(N).
     * Because it iterates through out the Linked List.
     *
     * @param      data1  The data 1
     *
     * @return     { Returns required Node }
     */
    public String get(final String data1) {
        int i = hash(data1);
        for (Node x = hashing[i].head; x != null; x = x.next) {
            if (x.data.equals(data1)) {
                return x.data;
            }
        }
        return null;
    }

    /**
     * Check Ransom checks each word.
     * Complexity of Check Ransom is O(N).
     * It iterates through out the Linked List to check with given string.
     *
     * @param      data1  The data 1
     *
     * @return     { Returns True is word is in List and value greater
     *              than 0 else returns false }
     */
    public boolean checkRansom(final String data1) {
        int i = hash(data1);
        for (Node x = hashing[i].head; x != null; x = x.next) {
            if (x.data.equals(data1) && x.value > 0) {
                x.value -= 1;
                return true;
            }
        }
        return false;
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
        //Not using this Constructor.
    }
    /**
     * Main Method for Solution.
     * Complexity of Solution is O(N).
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sca = new Scanner(System.in);
        String[] arr = sca.nextLine().split(" ");
        int magazinecount = Integer.parseInt(arr[0]);
        int ransomcount = Integer.parseInt(arr[1]);
        String[] magazineWords = sca.nextLine().split(" ");
        SeparateChaining chain = new SeparateChaining(magazinecount,
                                                        ransomcount);
        for (int i = 0; i < magazinecount; i++) {
            chain.put(magazineWords[i]);
        }
        String[] ransomWords = sca.nextLine().split(" ");
        for (int i = 0; i < ransomcount; i++) {
            if (chain.checkRansom(ransomWords[i])) {
                continue;
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
