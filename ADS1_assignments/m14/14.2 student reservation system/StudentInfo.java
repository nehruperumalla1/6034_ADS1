import java.util.Comparator;

/**
 * Class for student information.
 */
class StudentInfo {
    /**
     * Name.
     */
    private String name;
    /**
     * DOB.
     */
    private int[] dob;
    /**
     * { Subject 1 Marks }.
     */
    private int sub1;
    /**
     * { Sub2 Marks}.
     */
    private int sub2;
    /**
     * { Sub3 Marks }.
     */
    private int sub3;
    /**
     * { Total Marks }.
     */
    private int tmarks;
    /**
     * { Category }.
     */
    private String category;
    /**
     * { No.of Days }.
     */
    private static final int DAYS = 30;

    /**
     * Constructs the object.
     *
     * @param      n         { Name }
     * @param      b         { Date of Birth }
     * @param      s1        The s 1
     * @param      s2        The s 2
     * @param      s3        The s 3
     * @param      totmarks  The totmarks
     * @param      cat       The cat
     */
    StudentInfo(final String n, final String b, final int s1,
        final int s2, final int s3, final int totmarks, final String cat) {
        name = n;
        String[] dupdob = b.split("-");
        dob = new int[dupdob.length];
        for (int i = 0; i < dupdob.length; i++) {
            dob[i] = Integer.parseInt(dupdob[i]);
        }
        sub1 = s1;
        sub2 = s2;
        sub3 = s3;
        tmarks = totmarks;
        category = cat;
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
    public int getMarks() {
        return tmarks;
    }

    /**
     * Gets the category.
     *
     * @return     The category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * { Comparator. }.
     */
    static Comparator<StudentInfo> comp = new Comparator<StudentInfo>() {
        public int compare(final StudentInfo s1, final StudentInfo s2) {
            if (s2.tmarks - s1.tmarks != 0) {
                return s2.tmarks - s1.tmarks;
            } else if (s2.sub3 - s1.sub3 != 0) {
                return s2.sub3 - s1.sub3;
            } else if (s2.sub2 - s1.sub2 != 0) {
                return s2.sub2 - s1.sub2;
            } else {
                if (s2.dob[2] - s1.dob[2] != 0) {
                    return s2.dob[2] - s1.dob[2];
                } else {
                    int count = 2 * 2 * (2 + 1);
                    return (((count - s1.dob[1]) * DAYS)
                        - ((count - s2.dob[1]) * DAYS));
                }
            }
        }
    };

}
