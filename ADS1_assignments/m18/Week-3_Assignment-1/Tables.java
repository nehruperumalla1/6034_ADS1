import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for tables.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class Tables<Key extends Comparable<Key>> {
    /**
     * Key Array for Key Type.
     */
    private Key[] keys;
    /**
     * Values Array for Value Type.
     */
    private int[] values;
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
        values = new int[capacity];
        size = 0;
    }

    public void resize() {
        keys = Arrays.copyOf(keys, keys.length * 2);
        values = Arrays.copyOf(values, values.length * 2);
    }

    /**
     * Put Key and Value in Symbol Table.
     * Complexity of Put is O(logN).
     * It uses binary search to put the key, value.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final int val) {
        if (size == keys.length) {
            resize();
        }
        if (size == 0) {
            keys[size] = key;
            values[size] = val;
            size++;
        } else {
            int index = rank(val);
            // System.out.println(index + "--->  Index");
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
                values[index] = values[index] + val;
            }
        }
        // keys();
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
            System.out.println(keys[i] + "------------" + values[i]);
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
        // System.out.println(key + "  Key");
        int index = rank(key);
        if (index == size) {
            return false;
        }
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
    public int get(final Key key) {
        if (contains(key)) {
            int index = rank(key);
            return values[index];
        }
        return 0;
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
    public int rank(final int val) {
        int lo = 0;
        int hi = size - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (values[mid] - (val) < 0) {
                lo = mid + 1;
            } else if (values[mid] - (val) > 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

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

