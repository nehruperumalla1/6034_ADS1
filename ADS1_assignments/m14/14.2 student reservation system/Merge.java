import java.util.*;
/**
 * Class for merge.
 */
class Merge {
	/**
	 * Constructs the object.
	 */
	Merge() {
	}

	/**
	 * { Insertion Sort }.
	 * Worst Case Complexity is O(N^2).
	 * It Iterates through out the array two times due to nested for loop.
	 *
	 * @param      a           { Object Array }
	 * @param      lo          The lower
	 * @param      hi          The higher
	 * @param      comparator  The comparator
	 */
	public void insertionSort(StudentInfo[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], comparator); j--)
                exch(a, j, j-1);
    }

    /**
     * { Swapping Elements in the Array }.
     *
     * @param      a     { Student Item }
     * @param      i     { index i }
     * @param      j     { index j }
     */
    private  void exch(StudentInfo[] a, int i, int j) {
        StudentInfo swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * { Less method }.
     *
     * @param      a     { Student Item 1 }
     * @param      b     { Student Item 2 }
     * @param      comp  The component
     *
     * @return     { Returns boolean }
     */
    private boolean less(StudentInfo a, StudentInfo b, Comparator comp) {
        return comp.compare(a, b) < 0;
    }
	/**
	 * { Print to print the Output }
	 *
	 * @param      items  The items
	 */
	public void print(StudentInfo[] items) {
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i].getName() + "," + items[i].getMarks() + "," + items[i].getCategory());
		}
	}
}
