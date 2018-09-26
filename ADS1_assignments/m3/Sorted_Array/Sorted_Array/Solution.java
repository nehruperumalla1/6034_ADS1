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
		int i = 0;
		for (i = 0; i < totalsize; i++) {
			if (first < size1 && second < size2) {
				if (numarray1[first] < numarray2[second]) {
					array[i] = numarray1[first];
					first++;
				} else if (numarray1[first] > numarray2[second]) {
					array[i] = numarray2[second];
					second++;
				}
			} else {
				if (size1 > size2) {
					array[i] = numarray1[first];
					first++;
				} else {
					array[i] = numarray2[second];
					second++;
				}
			}
		}		
		for (int j = 0; j < totalsize - 1; j++) {
			System.out.print(array[j] + ", ");
		}
		System.out.println(array[totalsize - 1]);

	}
}