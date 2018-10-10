import java.util.Scanner;

/**
 * Class for tables.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class Tables<Key extends Comparable<Key>, Value> {
    /**
     * Key Array for Key Type.
     */
    private Key[] keys;
    /**
     * Values Array for Value Type.
     */
    private Value[] values;
    /**
     * Size of the Arrays.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    Tables(final int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
        size = 0;
    }

    /**
     * Put Key and Value in Symbol Table.
     * Complexity of Put is O(logN).
     * It uses binary search to put the key, value.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        if (size == 0) {
            keys[size] = key;
            values[size] = val;
            size++;
        } else {
            int index = rank(key);
            if (index == size) {
                keys[index] = key;
                values[index] = val;
                size++;
            } else if (!contains(key)) {
                for (int i = size; i > index; i--) {
                    keys[i] = keys[i - 1];
                    values[i] = values[i - 1];
                }
                keys[index] = key;
                values[index] = val;
                size++;
            } else {
                values[index] = val;
            }
        }
    }

    /**
     * Size of the Symbol Table.
     *
     * @return     { Returns Integer value }
     */
    public int size() {
        return size;
    }

    /**
     * Prints all keys and its values.
     * Complexity of Print is O(N).
     * It iterates through out the size.
     */
    public void keys() {
        for (int i = 0; i < size; i++) {
            System.out.println(keys[i] + " " + values[i]);
        }
    }

    /**
     * Contains Method to check whether its in table or not.
     * Here it uses Binary Search to find the Rank.
     * Complexity of Binary Search is O(logN).
     *
     * @param      key   The key
     *
     * @return     { Returns true if contains else false }
     */
    public boolean contains(final Key key) {
        int index = rank(key);
        return keys[index].compareTo(key) == 0;
    }

    /**
     * Gets the Value of that Key.
     * Here it uses Binary Search to get the Key.
     * Complexity of Binary Search is O(logN).
     *
     * @param      key   The key
     *
     * @return     { returns the value of given key }
     */
    public Value get(final Key key) {
        if (contains(key)) {
            int index = rank(key);
            return values[index];
        }
        return null;
    }

    /**
     * Max keys in Table.
     *
     * @return     { Returns max key }
     */
    public Key max() {
        return keys[size - 1];
    }

    /**
     * Floor key or the given key.
     * Here it uses binary search to get Floor.
     * Complexity of Binary Search is O(logN).
     *
     * @param      key   The key
     *
     * @return     { Returns key smaller or equal to the given. }
     */
    public Key floor(final Key key) {
        int index = rank(key);
        if (contains(key)) {
            return key;
        } else if (index == 0) {
            return null;
        }
        return keys[index - 1];
    }

    /**
     * Find the rank or Binary Search.
     * Comlexity is O(logN).
     * Binary Search halfs the array according to Size of the Element.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public int rank(final Key key) {
        int lo = 0;
        int hi = size - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (keys[mid].compareTo(key) < 0) {
                lo = mid + 1;
            } else if (keys[mid].compareTo(key) > 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    /**
     * Delete the Min Key.
     * Complexity is O(N)
     * It iterates through out the Size.
     */
    public void deleteMin() {
        for (int i = 0; i < size - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        size--;
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
        //Not USing this Constructor.
    }
    /**
     * Main Method for Symbol Table.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sca = new Scanner(System.in);
        String[] symbol = sca.nextLine().split(" ");
         Tables<String, Integer> tab = new Tables<String, Integer>(
            symbol.length);
        for (int i = 0; i < symbol.length; i++) {
            tab.put(symbol[i], i);
        }
        while (sca.hasNext()) {
            String[] input = sca.nextLine().split(" ");
            switch (input[0]) {
                case "max":
                    System.out.println(tab.max());
                break;
                case "floor":
                    System.out.println(tab.floor(input[1]));
                break;
                case "get":
                    System.out.println(tab.get(input[1]));
                break;
                case "contains":
                    System.out.println(tab.contains(input[1]));
                break;
                case "rank":
                    System.out.println(tab.rank(input[1]));
                break;
                case "deleteMin":
                    tab.deleteMin();
                break;
                case "keys":
                    tab.keys();
                break;
                case "size":
                System.out.println(tab.size());
                break;
                default:
                break;
            }
        }
    }
}
