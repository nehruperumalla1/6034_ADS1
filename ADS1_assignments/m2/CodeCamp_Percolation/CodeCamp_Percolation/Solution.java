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
class Percolation {
	boolean[][] grid;
	//int[] array;
	int c;
	int n;
	WQU union;
	int gridsize;
	Percolation(int n1) {
		n = n1;
		grid = new boolean[n][n];
		c = 0;
		union = new WQU((n * n) + 2);
		gridsize = (n * n);

	}
	public int index(int row, int col) {
		return row * n + col;
	}
	public void open(int row, int col) {
			grid[row - 1][col - 1] = true;
			c += 1;
		//Top
		if (row - 2 >= 0 && isOpen(row - 2, col - 1)) {
			union.union(index(row - 1, col - 1), index(row - 2, col - 1));
		}

		//Bottom
		if (row < n && isOpen(row, col - 1)) {
			union.union(index(row - 1, col - 1), index(row, col - 1));
		}

		//Left
		if (col - 2 >= 0 && isOpen(row - 1, col - 2)) {
			union.union(index(row - 1, col - 1), index(row - 1, col - 2));
		}

		//Right
		if (col < n && isOpen(row - 1, col)) {
			union.union(index(row - 1, col - 1), index(row - 1, col));
		}

		if (row - 1 == 0) {
			union.union(row - 1, gridsize);
		}

		if (row - 1 == n) {
			union.union(row - 1, gridsize + 1);
		}
	}

	// public boolean isFull(int row, int col) {

	// }

	public int numberOfOpenSites() {
		return c;
	}
	public boolean isOpen(int row, int col) {
		return grid[row][col];
	}

	public boolean percolates() {
		return union.isConnected(gridsize, gridsize + 1);
	}
}

public class Solution {
	Solution() {
		//Not Using this.
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Percolation obj = new Percolation(n);
		while(scan.hasNext()) {
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();
			obj.open(num1, num2);
		}
		System.out.println(obj.percolates());
		
	}
}