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
 * Class for query.
 */
class Query {
    /**
     * BST Class Object.
     */
    private BST<Double, Student> binary;
    /**
     * Constructs the object.
     *
     * @param      bin   The bin
     */
    Query(final BST<Double, Student> bin) {
        binary = bin;
    }

    /**
     * Checking Between Elements.
     * Here iterable keys performs.
     * In Worst case complexity will be O(N).
     * In Average case logN.
     *
     * @param      m1    The m 1
     * @param      m2    The m 2
     */
    public void checkBE(final Double m1, final Double m2) {
        for (double i : binary.keys(m1, m2)) {
            double f = i;
            Student stud = binary.get(f);
            System.out.println(stud.getName());
        }
    }
    /**
     * Checking Greater Elements.
     * Here rank and select performs.
     * In Worst case complexity will be O(N).
     * In Average case logN.
     *
     * @param      m1    The m 1
     */
    public void checkGE(final Double m1) {
        int pos = binary.rank(m1);
        Student stuobj;
        for (int i = pos; i < binary.size(); i++) {
            stuobj = binary.selectMe(i);
            System.out.println(stuobj.getName());
        }
    }

    /**
     * Checking Lesser Elements.
     * Here rank and select performs.
     * In Worst case complexity will be O(N).
     * In Average case logN.
     *
     * @param      m1    The m 1
     */
    public void checkLE(final Double m1) {
        int pos = binary.rank(m1);
        Student stuobj;
        for (int i = 0; i < pos; i++) {
            stuobj = binary.selectMe(i);
            System.out.println(stuobj.getName());
        }
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
     * Main Method.
     * Here it inserts and check elements.
     * For checking between elements worst case is N, avg case is logN.
     * For checking lesser than element worst case is N, avg case is logN.
     * For checking greater than element worst case is N, avg case is logN.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sca = new Scanner(System.in);
        BST<Double, Student> binary = new BST<Double, Student>();
        int count = Integer.parseInt(sca.nextLine());
        Student obj;
        while (count-- > 0) {
            String[] input = sca.nextLine().split(",");
            obj = new Student(Integer.parseInt(input[0]), input[1],
                Double.parseDouble(input[2]));
            binary.put(Double.parseDouble(input[2]), obj);
        }
        int count1 = Integer.parseInt(sca.nextLine());
        Query query = new Query(binary);
        while (count1-- > 0) {
            String[] input = sca.nextLine().split(" ");
            switch (input[0]) {
                case "BE":
                    query.checkBE(Double.parseDouble(input[1]),
                        Double.parseDouble(input[2]));
                break;
                case "GE":
                    query.checkGE(Double.parseDouble(input[1]));
                break;
                case "LE":
                    query.checkLE(Double.parseDouble(input[1]));
                break;
                default:
                break;
            }
        }
    }
}
