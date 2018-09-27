import java.util.Arrays;
import java.util.Scanner;

class CheckBalance {
	public void check(String str) {
		//String str = checkstr.getParentheses();
		String[] array = str.split("",str.length());
		String[] stack = new String[array.length];
		int size = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals("{") || array[i].equals("(") || array[i].equals("[")) {
				stack[size] = array[i];
				size++;
			} else if(size > 0) {
				if (array[i].equals("}") && stack[size - 1].equals("{")) {
					size--;
				}else if (array[i].equals("]") && stack[size - 1].equals("[")) {
					size--;
				}else if (array[i].equals(")") && stack[size - 1].equals("(")) {
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


public class Solution {
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