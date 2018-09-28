import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for (int i = 0; i < num; i++) {
			Operations op = new Operations();
			String[] jos = scan.next().split(",");
			int k = Integer.parseInt(jos[0]);
			int m = Integer.parseInt(jos[1]);
			for (int j = 0; j < k; j++) {
				op.insertAtTail(j);
			}
			int[] josephus = op.josephus(m, k);
			for (int p = 0; p < josephus.length - 1; p++) {
				System.out.print(josephus[p] + " ");
			}
			System.out.println(josephus[josephus.length - 1]);
		}
	}
}