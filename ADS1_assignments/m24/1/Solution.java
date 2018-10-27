import java.util.Scanner;

/**
 * Class for student.
 */
class Student {
    /**
     * Roll Num for Student.
     */
    private int roll;
    /**
     * Name of the Student.
     */
    private String name;
    /**
     * Marks of the Student.
     */
    private double marks;
    /**
     * Constructs the object.
     *
     * @param      rollno  The rollno
     * @param      sname   The sname
     * @param      tmarks  The tmarks
     */
    Student(final int rollno, final String sname, final double tmarks) {
        roll = rollno;
        name = sname;
        marks = tmarks;
    }

    /**
     * Gets the roll no.
     *
     * @return     The roll.
     */
    public int getRoll() {
        return roll;
    }

    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the marks.
     *
     * @return     The marks.
     */
    public double getMarks() {
        return marks;
    }
}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * Main Method for Solution Class.
     * Complexity of Solution in Avergage case will be Constant / 1 *.
     * In worst case it will have logN *
     * -- * represents elements are inserted randomly.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sca = new Scanner(System.in);
        int count = Integer.parseInt(sca.nextLine());
        LinearProbingHashST<Integer, Student> probing =
         new LinearProbingHashST<Integer, Student>();
        while (count-- > 0) {
            String[] input = sca.nextLine().split(",");
            Student obj = new Student(Integer.parseInt(input[0]), input[1],
                                        Double.parseDouble(input[2]));
            probing.put(Integer.parseInt(input[0]), obj);
        }
        int opcount = Integer.parseInt(sca.nextLine());
        while (opcount-- > 0) {
            String[] input = sca.nextLine().split(" ");
            Student student = probing.get(Integer.parseInt(input[1]));
            if (student == null) {
                System.out.println("Student doesn't exists...");
                continue;
            }
            switch (input[2]) {
                case "1":
                    System.out.println(student.getName());
                break;
                case "2":
                    System.out.println(student.getMarks());
                break;
                default:
                break;
            }
        }
    }
}
