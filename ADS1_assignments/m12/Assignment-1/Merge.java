import java.util.*;
class Merge {
	// private static final int CUTOFF = 7;
	Merge() {
	}

	public void insertionSort(StudentInfo[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], comparator); j--)
                exch(a, j, j-1);
    }

    private  void exch(StudentInfo[] a, int i, int j) {
        StudentInfo swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private boolean less(StudentInfo a, StudentInfo b, Comparator comp) {
        return comp.compare(a, b) < 0;
    }

	// public void mSort(StudentInfo[] a, Comparator comp) {
	// 	int i = 0;
	// 	int j = a.length - 1;
	// 	StudentInfo[] b = a.clone();
	// 	mSort(a, b, i, j, comp);
	// 	print(a);
	// }

	// public void mSort(StudentInfo[] a, StudentInfo[] b, int lo, int hi, Comparator comp) {
	// 	if (hi <= lo + CUTOFF) {
	// 		insertionSort(b, lo, hi, comp);
	// 		return;
	// 	}
	// 	int mid = lo + (hi - lo) / 2;
	// 	mSort(b, a, lo, mid, comp);
	// 	mSort(b, a, mid + 1, hi, comp);
	// 	if (!less(a[mid + 1], a[mid], comp)) {
	// 		for (int i = lo; i <= hi; i++) {
	// 			b[i] = a[i];
	// 		}
	// 	}
	// 	mergee(a, b, lo, mid, hi, comp);
	// }

	// public void mergee(StudentInfo[] a, StudentInfo[] b, int lo, int mid, int hi, Comparator comp) {
	// 	int i = lo;
	// 	int j = mid + 1;
	// 	for (int k = lo; k <= hi; k++) {
	// 		if (i > mid) {
	// 			b[k] = a[j++];
	// 		} else if (j > hi) {
	// 			b[k] = a[i++];
	// 		} else if (less(a[j], a[i], comp)) {
	// 			b[k] = a[j++];
	// 		} else {
	// 			b[k] = a[i++];
	// 		}
	// 	}
	// }


	public void print(StudentInfo[] items) {
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i].getName() + "," + items[i].getMarks() + "," + items[i].getCategory());
		}
	}
}
