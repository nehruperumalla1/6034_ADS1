import java.util.Scanner;

/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * Main Method for sorting elements using Merge Sort.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Merge m = new Merge();
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String tokens = s.nextLine();
            String[] lines = tokens.split(",");
            m.sort(lines);
            System.out.println(m.show(lines));
            System.out.println();
        }
    }
}
