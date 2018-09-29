import java.util.Scanner;

class AddLargeNumbers {
    public static LinkedList numberToDigits(String number) {
        LinkedList op = new LinkedList();
        String[] numbers = number.split("",number.length());
        for (int i = 0; i < numbers.length; i++) {
            int num = Integer.parseInt(numbers[i]);
            op.insertAtTail(num);
        }
        return op;
    }

    public static String digitsToNumber(LinkedList list) {
        Node temp = list.head;
        String str = "";
        while (temp.getNext() != null) {
            str += temp.getData();
            temp = temp.getNext();
        }
        str += temp.getData();
        return str;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        LinkedList sum = new LinkedList();
        Node temp1 = list1.tail;
        Node temp2 = list2.tail;
        Node temphead = list1.head;
        String str = "";
        int num1 = 0;
        int carry = 0;
        int replace = 0;
        String[] nums = null;
        while (temphead != null) {
            int add = temp1.getData() + temp2.getData();
            if (add > 9) {
                str = Integer.toString(add);
                nums = str.split("", str.length());
                num1 = Integer.parseInt(nums[1]);
                carry = Integer.parseInt(nums[0]);
                sum.insertAtHead(num1);
                list1.popAtTail();
                list2.popAtTail();
                replace = list1.eleAtTail() + carry;
                list1.popAtTail();
                list1.insertAtTail(replace);
                System.out.println(num1);
            } else {
                sum.insertAtHead(add);
                list1.popAtTail();
                list2.popAtTail();
            }

        }
        return sum;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
