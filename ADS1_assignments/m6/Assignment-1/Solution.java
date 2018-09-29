import java.util.*;

/**
 * Class for add large numbers.
 */
final class AddLargeNumbers {
    /**
     * Constructs the object.
     */
    private AddLargeNumbers() {
        //not Using This.
    }
    /**
     * Numbers To Digits.
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList op = new LinkedList();
        String[] numbers = number.split("", number.length());
        for (int i = 0; i < numbers.length; i++) {
            int num = Integer.parseInt(numbers[i]);
            op.insertAtTail(num);
        }
        return op;
    }

    /**
     * Digits To Numbers.
     *
     * @param      list  The list
     *
     * @return     { String Returns }
     */
    public static String digitsToNumber(final LinkedList list) {
        Node temp = list.head;
        String str = "";
        while (temp.getNext() != null) {
            str += temp.getData();
            temp = temp.getNext();
        }
        str += temp.getData();
        return str;
    }

    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { Linked List Returns }
     */
    public static LinkedList addLargeNumbers(
        final LinkedList list1, final LinkedList list2) {
        LinkedList sum = new LinkedList();
        Node temp1 = list1.tail;
        Node temp2 = list2.tail;
        Node temphead = list1.head;
        String str = "";
        int num1 = 0;
        int carry = 0;
        int replace = 0;
        String[] nums = null;
        while (temphead.getNext() != null) {
            int add = temp1.getData() + temp2.getData();
            if (add > 2 + 2 + 2 + 2 + 1) {
                str = Integer.toString(add);
                nums = str.split("");
                num1 = Integer.parseInt(nums[1]);
                carry = Integer.parseInt(nums[0]);
                sum.insertAtHead(num1);
                list1.popAtTail();
                list2.popAtTail();
                replace = list1.eleAtTail() + carry;
                list1.popAtTail();
                list1.insertAtTail(replace);
            } else {
                sum.insertAtHead(add);
                list1.popAtTail();
                list2.popAtTail();
            }
            temp1 = list1.tail;
            temp2 = list2.tail;
            temphead = list1.head;
        }
        int k = temp1.getData() + temp2.getData();
        sum.insertAtHead(k);
        return sum;
    }
}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    //Solution
    }
    /**
     * Main Method For Adding Number.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(
                    pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(
                    qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                // pDigits.display();
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(
                    pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(
                    result));
                break;
            default:
            break;
        }
    }
}
