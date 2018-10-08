import java.util.Scanner;

/**
 * Class for minimum heap.
 *
 * @param      <T>   { Generic Type }
 */
class MinHeap<T extends Comparable<T>> {
    /**
     * Generic Array.
     */
    private T[] array;
    /**
     * Position of Element in Array.
     */
    private int position;
    /**
     * Constructs the object.
     *
     * @param      arr   The arr
     */
    MinHeap(final T[] arr) {
        array = arr;
        position = 1;
    }

    /**
     * Checking Min Heap by calling private Checking Function.
     */
    public void check() {
        System.out.println(checking());
    }

    /**
     * Checking Min Heap of Array.
     * Complexity is O(logN).
     * This start checking from parent node.
     * It will checks upto the half of the length of the Array.
     * There is no need to check the Children Nodes.
     *
     * @return     { Returns true if min else false }
     */
    private boolean checking() {
        int pos = position;
        while (pos < array.length / 2) {
            int j = pos * 2;
            if (array[pos].compareTo(array[j]) > 0
                || array[pos].compareTo(array[j + 1]) > 0) {
                return false;
            }
            pos++;
        }
        return true;
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
     * Main Method for Checking array Min heap or Not.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sca = new Scanner(System.in);
        String type = sca.nextLine();
        int count = Integer.parseInt(sca.nextLine());
        switch (type) {
            case "Integer":
                while (count-- > 0) {
                    String[] strnums = sca.nextLine().split(",");
                    Integer[] nums = new Integer[strnums.length + 1];
                    int j = 1;
                    for (int i = 0; i < strnums.length; i++) {
                        nums[j++] = Integer.parseInt(strnums[i]);
                    }
                    MinHeap<Integer> heapobj = new MinHeap<Integer>(nums);
                    heapobj.check();
                }
            break;

            case "String":
                while (count-- > 0) {
                    String[] strnums = sca.nextLine().split(",");
                    MinHeap<String> heapobj = new MinHeap<String>(strnums);
                    heapobj.check();
                }
            break;

            case "Double":
                while (count-- > 0) {
                    String[] strnums = sca.nextLine().split(",");
                    Double[] nums = new Double[strnums.length + 1];
                    int j = 1;
                    for (int i = 0; i < strnums.length; i++) {
                        nums[j++] = Double.parseDouble(strnums[i]);
                    }
                    MinHeap<Double> heapobj = new MinHeap<Double>(nums);
                    heapobj.check();
                }
            break;

            case "Float":
                while (count-- > 0) {
                    try {
                        String[] strnums = sca.nextLine().split(",");
                        Float[] nums = new Float[strnums.length + 1];
                        int j = 1;
                        for (int i = 0; i < strnums.length; i++) {
                            nums[j++] = Float.parseFloat(strnums[i]);
                        }
                        MinHeap<Float> heapobj = new MinHeap<Float>(nums);
                        heapobj.check();
                    } catch (Exception e) {
                        System.out.println("false");
                        break;
                    }
                }
            break;
            default:
            break;
        }
    }
}
