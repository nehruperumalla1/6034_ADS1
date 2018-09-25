// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * Grid Array for opening.
     */
    private boolean[][] grid;
    /**
     * ArraySize for Grid Array and Tree Array.
     */
    private int arraysize;
    /**
     * Object of Weight Quick Union.
     */
    private WQU union;
    /**
     * Size of the Grid.
     */
    private int gridsize;
    /**
     * Constructs the object.
     *
     * @param      size  The size
     */
    Percolation(int size) {
        arraysize = size;
        grid = new boolean[arraysize][arraysize];
        union = new WQU((arraysize * arraysize) + 2);
        gridsize = (arraysize * arraysize);

    }
    /**
     * Index of the Tree Array with Row & Col.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     { Returns Index of the Tree Array }
     */
    public int index(int row, int col) {
        return row * arraysize + col;
    }
    /**
     * Opening the Array at given position.
     *
     * @param      row   The row
     * @param      col   The col
     */
    public void open(int row, int col) {
            grid[row - 1][col - 1] = true;
        //Top
        if (row - 2 >= 0 && isOpen(row - 2, col - 1)) {
            union.union(index(row - 1, col - 1), index(row - 2, col - 1));
        }

        //Bottom
        if (row < arraysize && isOpen(row, col - 1)) {
            union.union(index(row - 1, col - 1), index(row, col - 1));
        }

        //Left
        if (col - 2 >= 0 && isOpen(row - 1, col - 2)) {
            union.union(index(row - 1, col - 1), index(row - 1, col - 2));
        }

        //Right
        if (col < arraysize && isOpen(row - 1, col)) {
            union.union(index(row - 1, col - 1), index(row - 1, col));
        }

        if (row - 1 == 0) {
            union.union(index(row-1,col-1), gridsize);
        }

        if (row - 1 == arraysize-1) {
            union.union(index(row-1,col-1), gridsize + 1);
        }
    }
    /**
     * Determines if open.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     True if open, False otherwise.
     */
    public boolean isOpen(int row, int col) {
        return grid[row][col];
    }

    /**
     * Check whether the Array Percolates on not.
     *
     * @return     { Returns Boolean True if Percolates False if Not }
     */
    public boolean percolates() {
        return union.isConnected(gridsize, gridsize + 1);
    }
}

/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    Solution() {
        //Not Using this.
    }

    /**
     * Main Method.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        Percolation obj = new Percolation(size);
        while(scan.hasNext()) {
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            obj.open(num1, num2);
        }
        System.out.println(obj.percolates());
    }
}