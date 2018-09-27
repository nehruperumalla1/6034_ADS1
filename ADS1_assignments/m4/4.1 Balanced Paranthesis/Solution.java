import java.util.Scanner;

/**
 * Class for check balance in Parantheses.
 */
class CheckBalance {

    /**
     * This method will check the balance in Parantheses.
     *
     * @param      str   The string
     */
    public void check(final String str) {
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
            } else if (size > 0) {
                if (array[i] == '}' && stack[size - 1] == '{') {
                    size--;
                } else if (array[i] == ']' && stack[size - 1] == '[') {
                    size--;
                } else if (array[i] == ')' && stack[size - 1] == '(') {
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
public final class Solution {
    /**
     * Constructs the Object.
     */
    private Solution() {
        //Not Using this Constructor.
    }
    /**
     * Main Method for Checking Balance in Parantheses.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        CheckBalance cb = new CheckBalance();
        int n = scan.nextInt();
        while (scan.hasNext()) {
            String str = scan.next();
            cb.check(str);
        }
    }
}
