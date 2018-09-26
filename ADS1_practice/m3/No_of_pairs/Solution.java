import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Main Method for No .of Pairs.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		int count = 0;
		int temp = 1;
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = scan.nextInt();
		}
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		int flag = array[0];
		for (int i = 1; i < length; i++) {
			if (array[i] == flag) {
				temp++;
			} else {
				count += (temp * (temp - 1)) / 2;
				flag = array[i];
				temp = 1;
			}
		}
		count += (temp * (temp - 1)) / 2;
		System.out.println(count);
	}
}
