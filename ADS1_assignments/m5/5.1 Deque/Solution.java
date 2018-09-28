import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Operations op = new Operations();
		int num = scan.nextInt();
		while (scan.hasNext()) {
			String[] operation = scan.nextLine().split(" ");
			switch (operation[0]) {
				case "pushLeft":
					op.insertAtHead(Integer.parseInt(operation[1]));
				break;
				case "pushRight":
					op.insertAtTail(Integer.parseInt(operation[1]));
				break;
				case "popLeft":
					op.popAtHead();
				break;
				case "popRight":
					op.popAtTail();
				break;
				case "size":
				System.out.println(op.size());
					
				break;
			}
		}

	}
}