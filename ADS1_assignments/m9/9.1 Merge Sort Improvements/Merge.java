/**
 * Class for merge.
 */
class Merge {
    /**
     * CUTOFF value for Insertion Sort.
     */
    private static final int CUTOFF = 7;
    /**
     * Constructs the object.
     */
    Merge() { }
    /**
     * Method to Merge the divided Arrays.
     *
     * @param      array     The array
     * @param      aux      The newarray
     * @param      low
     *         The lower
     * @param      mid       The middle
     * @param      hi        The higher
     */
    private static void merge(final Comparable[] array,
        final Comparable[] aux, final int low,
        final int mid, final int hi) {
        assert isSorted(array, low, mid);
        assert isSorted(array, mid + 1, hi);

        int i = low, j = mid + 1;
        for (int k = low; k <= hi; k++) {
            if (i > mid) {
                aux[k] = array[j++];
            } else if (j > hi) {
                aux[k] = array[i++];
            } else if (less(array[j], array[i])) {
                aux[k] = array[j++];
            } else {
                aux[k] = array[i++];
            }
        }
        /**
         * Assert to check array is sorted or not..
         */
        assert isSorted(aux, low, hi);
    }
    /**
     * Sort method is to sort the array of elements using Merge..
     * The Complexity is O(NlogN).
     * It divides the array into two array each time.
     * This makes the logN.
     * It iterates through the for loop for N times.
     * This total makes NlogN.
     *
     * @param      a       The array
     * @param      aux     The newarray
     * @param      lo        The lower
     * @param      hi        The higher
     */
    private static void sort(final Comparable[] a,
        final Comparable[] aux, final int lo, final int hi) {
        if (hi <= lo + CUTOFF) {
            insertionSort(aux, lo, hi);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(aux, a, lo, mid);
        sort(aux, a, mid + 1, hi);

        if (!less(a[mid + 1], a[mid])) {
           for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
            }
            System.out.println("Array is already sorted. "
                + "So, skipped the call to merge...");
           return;
        }
        merge(a, aux, lo, mid, hi);
    }
    /**
     * Sort method to Call Private Sort Method.
     *
     * @param      a     { Comparable Type Array of Elements }
     */
    public static void sort(final Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
        assert isSorted(a);
    }
    /**
     * This Method sorts the elements using Insertion Sort.
     * The Complexity of Insertion Sort is O(N^2).
     * It has Nested for loops.
     * It iterates through the array N^2 times.
     * The worst case complexity is O(N^2).
     *
     * @param      a     { Comparable Type Array of Elements }
     * @param      low    The lower
     * @param      hi    The higher
     */
    public static void insertionSort(final Comparable[] a, final  int low,
        final int hi) {
        for (int i = low; i <= hi; i++) {
            for (int j = i; j > low && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    /**
     * Swapping the elements in Array.
     *
     * @param      a     { Comparable Type Array of Elements }
     * @param      i     { Integer index i }
     * @param      j     { Integer index j }
     */
    public static void exch(final Comparable[] a, final int i, final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
     * Less method determines whether first is less than other or Not.
     *
     * @param      first     { Comparable Type first }
     * @param      second     { Comparable Type Second }
     *
     * @return     { Returrns True if first is smaller else false }
     */
    public static boolean less(final Comparable first,
        final Comparable second) {
        return first.compareTo(second) < 0;
    }
    /**
     * Determines if sorted.
     *
     * @param      a     { Comparable Array of Elements }
     *
     * @return     True if sorted, False otherwise.
     */
    public static boolean isSorted(final Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    /**
     * Determines if sorted.
     *
     * @param      a     { Comparable Array of Elements }
     * @param      low    The lower
     * @param      hi    The higher
     *
     * @return     True if sorted, False otherwise.
     */
    public static boolean isSorted(final Comparable[] a,
        final int low, final int hi) {
        for (int i = low + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * This method returns a String Object of Sorted elements.
     *
     * @param      a     {  Array Of elements }
     *
     * @return     { Returns the String Object. }
     */
    public static Object show(final Object[] a) {
        String s = "[";
        int i;
        for (i = 0; i < a.length - 1; i++) {
            s += a[i] + ", ";
        }
        s = s + a[a.length - 1] + "]";
        return s;
    }
}
