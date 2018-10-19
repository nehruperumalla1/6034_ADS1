import java.util.Scanner;
/**
 * Class for dynamic median finding.
 */
class DynamicMedianFinding {
    /**
     * Count Variable for PQ Size.
     */
    private int count;
    /**
     * Scanner Object to take input.
     */
    private Scanner scan;
    /**
     * Constructs the object.
     *
     * @param      countt  The countt
     * @param      sca     The sca
     */
    DynamicMedianFinding(final int countt, final Scanner sca) {
        count = countt;
        scan = sca;
    }
    /**
     * Finding the Dynamic Median.
     * Complexity for insertion is O(LogN).
     * Complexity for Deletion is O(LogN).
     */
    public void dynMedianFin() {
        MinPQ<Float> minpq = new MinPQ<Float>(count);
        MaxPQ<Float> maxpq = new MaxPQ<Float>(count);
        float median = 0.0f;
        for (int i = 0; i < count; i++) {
            float input = Float.parseFloat(scan.nextLine());
            if (input > median) {
                minpq.insert(input);
            } else {
                maxpq.insert(input);
            }
            if (maxpq.size() - minpq.size() > 1) {
                float input1 = maxpq.delMax();
                minpq.insert(input1);
            }
            if (minpq.size() - maxpq.size() > 1) {
                float input2 = minpq.delMin();
                maxpq.insert(input2);
            }
            if (minpq.size() == maxpq.size()) {
                median = (minpq.min() + maxpq.max()) / 2;
                System.out.println(median);
            }
            if (maxpq.size() > minpq.size()) {
                median = maxpq.max();
                System.out.println(median);
            }
            if (minpq.size() > maxpq.size()) {
                median = minpq.min();
                System.out.println(median);
            }
        }
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
     * {Main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        DynamicMedianFinding dmf = new DynamicMedianFinding(count, scan);
        dmf.dynMedianFin();
    }
}
