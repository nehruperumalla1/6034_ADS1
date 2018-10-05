import java.util.Scanner;
import java.util.Arrays;

class InsertionSort {
	InsertionSort() {
		// System.out.println("In Insertion Sort");
	}

	public Comparable[] insertionSort(Comparable[] a, int lo, int hi) {
		return sort(a, lo, hi);
	}

	private Comparable[] sort(Comparable[] a, int lo, int hi) {
		int j = 0;
		// System.out.println(hi + " Hi");
		for (int i = lo + 1; i <= hi; i++) {
			j = i - 1;
			Comparable temp = a[i];
			while (j >= 0 && temp.compareTo(a[j]) < 0) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = temp;
		}
		return a;
	}
}

class QuickSort {

	int cutoff;
	InsertionSort insertion;
	QuickSort(int cut) {
		cutoff = cut;
		insertion = new InsertionSort();
	}

	public void qSort(Comparable[] a, int cutoff) {
		int lo = 0;
		int hi = a.length - 1;
		int cut = cutoff;
		qSort(a, lo, hi); 
	}

	private void qSort(Comparable[] a, int lo, int hi) {
		// System.out.println("In Quick Sort   " + cutoff);
		if (hi - lo + 1 <= cutoff) {
			insertion.insertionSort(a, lo, hi);
			System.out.println("insertionSort called");
			return;
		}
		int j = partition(a, lo, hi);
		qSort(a, lo, j - 1);
		qSort(a, j + 1, hi);
	}

	private int partition(Comparable[] a, int lo, int hi) {
		int i = lo + 1;
		int k = lo;
		int j = hi;
		while (true) {
			while (less(a[i], a[k])) {
				i++;
				if (i == hi) {
					break;
				}
			}
			while (less(a[k], a[j])) {
				j--;
				if (j == lo) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			exchange(a, i, j);
			i++;
		}
		exchange(a, j, k);
		System.out.println(Arrays.toString(a));
		return j;
	}

	private boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	private void exchange(Comparable[] a, int i, int k) {
		Comparable temp = a[k];
		a[k] = a[i];
		a[i] = temp;
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		while (num > 0) {
			int cutoff = scan.nextInt();
			scan.nextLine();
			String[] tokens = scan.nextLine().split(" ");
			if (tokens[0].length() == 0) {
				System.out.println("[]");
			} else {
				QuickSort quick = new QuickSort(cutoff);
				quick.qSort(tokens, cutoff);
				System.out.println(Arrays.toString(tokens));
			}
			num--;
		}
	}
}