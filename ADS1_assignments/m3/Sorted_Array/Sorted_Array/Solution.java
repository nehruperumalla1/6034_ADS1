import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size1 = scan.nextInt();
		int size2 = scan.nextInt();
		int totalsize = size1 + size2;
		String firststring = scan.next();
		String secondstring = scan.next();
		String[] array1 = firststring.split(",");
		String[] array2 = secondstring.split(",");
		int[] numarray1 = new int[size1];
		int[] numarray2 = new int[size2];
		int[] array = new int[totalsize];
		for (int i = 0; i < size1; i++) {
			numarray1[i] = Integer.parseInt(array1[i]);
		}
		for (int i = 0; i < size2; i++) {
			numarray2[i] = Integer.parseInt(array2[i]);
		}
		int first = 0;
		int second = 0;
		for (int i = 0; first<size1&&second<size2; ) {
			if (first < size1 && second < size2) {
				if (numarray1[first] < numarray2[second]) {
					array[i] = numarray1[first];
					first++;
				} else if (numarray1[first] > numarray2[second]) {
					array[i] = numarray2[second];
					second++;
				}
				i++;
			}
			if (second < size2) {
				while(second < size2) {
					array[i] = numarray2[second];
					second++;
				}
			} 
			if (first < size1) {
				while(first < size1) {
					array[i++] = numarray1[first];
					first++;
				}
			
		}
	}
		System.out.println(Arrays.toString(array));
	}
}