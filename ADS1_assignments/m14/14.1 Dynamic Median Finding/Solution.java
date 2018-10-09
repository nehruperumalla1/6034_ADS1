import java.util.Scanner;
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
        MinPQ<Float> minpq = new MinPQ<Float>(count);
        MaxPQ<Float> maxpq = new MaxPQ<Float>(count);
        float median = 0.0f;
        for (int i = 0; i < count + 1; i++) {
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
