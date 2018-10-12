import java.util.Scanner;
/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
    /**
     * i value.
     */
    private int i;
    /**
     * j value.
     */
    private int j;
    /**
     * sum.
     */
    private int sum;
    /**
     * Constructs the object.
     *
     * @param      vali  The vali
     * @param      valj  The valj
     */
    CubeSum(final int vali, final int valj) {
        this.i = vali;
        this.j = valj;
        sum = i * i * i + j * j * j;
    }
    /**
     * { Compares Two Objects Sum. }.
     *
     * @param      that  The that
     *
     * @return     { Returns 0 if equal -1 if less else 1 }
     */
    public int compareTo(final CubeSum that) {
        return this.sum - that.sum;
    }

    /**
     * Gets the vali.
     *
     * @return     The vali.
     */
    public int getVali() {
        return i;
    }

    /**
     * Gets the valj.
     *
     * @return     The valj.
     */
    public int getValj() {
        return j;
    }
    /**
     * Gets the sum.
     *
     * @return     The sum.
     */
    public int getSum() {
        return sum;
    }
}
/**
 * Class Solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor
    }
    /**
     * Main method for Taxi Cab Numbers.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int value1 = Integer.parseInt(input[0]);
        int value2 = Integer.parseInt(input[1]);
        taxiCabNumbers(value1, value2);
    }
    /**
     * { taxinumbers }.
     * {time complexity is O(n)}
     * @param      number        nth number
     * @param      combinations  The combinations
     */
    public static void taxiCabNumbers(final int number,
        final int combinations) {
        final int n = 600;
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i < n; i++) {
            pq.insert(new CubeSum(i, i));
        }
        int t = -1;
        int count = 0;
        int nthramanujan = number;
        while (!pq.isEmpty()) {
            CubeSum temp = pq.delMin();
            if (t == temp.getSum()) {
                count++;
            } else {
                count = 0;
            }
            if (count == combinations - 1) {
                nthramanujan--;
                if (nthramanujan == 0) {
                    System.out.println(temp.getSum());
                    break;
                }
            }
            t = temp.getSum();
            if (temp.getValj() < n) {
                pq.insert(new CubeSum(temp.getVali(),
                    temp.getValj() + 1));
            }
        }
    }
}
