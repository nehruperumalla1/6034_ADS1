import java.util.Arrays;
import java.util.Scanner;

class CheckBalance {
	public void check(String str) {
		//String str = checkstr.getParentheses();
		char[] array = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			array[i] = str.charAt(i);
		}
		char[] stack = new char[array.length];
		int size = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '{' || array[i] == '(' || array[i] == '[') {
				stack[size] = array[i];
				size++;
			} else if(size > 0) {
				if (array[i] == '}' && stack[size - 1] == '{') {
					size--;
				}else if (array[i] == ']' && stack[size - 1] == '[') {
					size--;
				}else if (array[i] == ')' && stack[size - 1] == '(') {
					size--;
				}
			}
		}
		if (size == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}


/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Main Method for Checking Balance in Parantheses.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CheckBalance cb = new CheckBalance();
		int n = scan.nextInt();
		while (scan.hasNext()) {
			String str = scan.next();
			cb.check(str);
		}
	}
}
