import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraysize = scan.nextInt();
		int[] array = new int[arraysize];
		int count = 0;
		for (int i = 0; i < arraysize; i++) {
			array[i] = scan.nextInt();
		}
		for (int i = 0; i < arraysize; i++) {
			for (int j = i + 1; j < arraysize; j++) {
				for (int k = j + 1; k < arraysize; k++) {
					if (array[i] + array[j] + array[k] == 0) {
						count += 1;
					}
				}
			}
		}
		System.out.println(count);
	}
}