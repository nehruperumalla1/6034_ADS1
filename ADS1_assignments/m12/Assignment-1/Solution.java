import java.util.Comparator;
import java.util.Arrays;
import java.util.Scanner;

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
     * { var_description }.
     */
    private int sub1;
    /**
     * { var_description }.
     */
    private int sub2;
    /**
     * { var_description }.
     */
    private int sub3;
    /**
     * { var_description }.
     */
    private int tmarks;
    /**
     * { var_description }.
     */
    private String category;
    /**
     * { var_description }.
     */
    private static int DAYS = 30;

    /**
     * Constructs the object.
     *
     * @param      n         { parameter_description }
     * @param      b         { parameter_description }
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
     * { var_description }.
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

/**
 * Class for students.
 */
class Students {
    /**
     * { var_description }.
     */
    private StudentInfo[] info;
    /**
     * { var_description }.
     */
    private int num;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * { var_description }.
     */
    private StudentInfo[] vacancies;
    /**
     * { var_description }.
     */
    private int vacsize;
    /**
     * { var_description }.
     */
    private int urvac;
    /**
     * { var_description }.
     */
    private int bcvac;
    /**
     * { var_description }.
     */
    private int scvac;
    /**
     * { var_description }.
     */
    private int stvac;
    /**
     * Constructs the object.
     *
     * @param      data   The data
     * @param      vacan  The vacan
     * @param      urvc   The urvc
     * @param      bvc    The bvc
     * @param      svc    The svc
     * @param      stvc   The stvc
     */
    Students(final int data, final int vacan,
        final int urvc, final int bvc, final int svc,
        final int stvc) {
        num = data;
        info = new StudentInfo[num];
        size = 0;
        vacancies = new StudentInfo[vacan];
        urvac = urvc;
        bcvac = bvc;
        scvac = svc;
        stvac = stvc;
        vacsize = 0;
    }

    /**
     * { function_description }.
     *
     * @param      sortedinfo  The sortedinfo
     *
     * @return     { description_of_the_return_value }
     */
    public StudentInfo[] applications(final StudentInfo[] sortedinfo) {
        int count = 0;
        while (count < vacancies.length) {
            while (urvac > 0 && count < vacancies.length) {
                vacancies[vacsize++] = sortedinfo[count++];
                urvac--;
            }

            while (scvac > 0 && count < vacancies.length) {
                if (sortedinfo[count].getCategory().equals("SC")) {
                    vacancies[vacsize++] = sortedinfo[count++];
                    scvac--;
                } else {
                    break;
                }
            }

            while (stvac > 0 && count < vacancies.length) {
                if (sortedinfo[count].getCategory().equals("ST")) {
                    vacancies[vacsize++] = sortedinfo[count++];
                    stvac--;
                } else {
                    break;
                }
            }

            if (bcvac != 0) {
                while (bcvac > 0 && count < vacancies.length) {
                    vacancies[vacsize++] = sortedinfo[count++];
                    bcvac--;
                }
            }

            if (scvac != 0) {
                while (scvac > 0 && count < vacancies.length) {
                    vacancies[vacsize++] = sortedinfo[count++];
                    scvac--;
                }
            }

            if (stvac != 0) {
                while (stvac > 0 && count < vacancies.length) {
                    vacancies[vacsize++] = sortedinfo[count++];
                    stvac--;
                }
            }
            if (count >= vacancies.length) {
                break;
            }
        }
        return vacancies;
    }
    /**
     * { function_description }.
     *
     * @param      stud  The stud
     */
    public void add(final StudentInfo stud) {
        if (size == info.length) {
            resize();
        }
        info[size++] = stud;
    }

    /**
     * { function_description }.
     */
    public void resize() {
        info = Arrays.copyOf(info, info.length * 2);
    }

    /**
     * Gets the information.
     *
     * @return     The information.
     */
    public StudentInfo[] getInfo() {
        return info;
    }
    /**
     * { function_description }.
     *
     * @param      inf   The inf
     */
    public void print(final StudentInfo[] inf) {
        for (int i = 0; i < inf.length; i++) {
            System.out.println(inf[i].getName() + ","
                + inf[i].getMarks() + "," + inf[i].getCategory());
        }
    }
}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * { item_description }.
     */
    private Solution() {
    }
    /**
     * main Method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int studcount = Integer.parseInt(scan.nextLine());
        Merge sort = new Merge();
        int vacancies = Integer.parseInt(scan.nextLine());
        int unrevacancies = Integer.parseInt(scan.nextLine());
        int bcvacancies = Integer.parseInt(scan.nextLine());
        int scvacancies = Integer.parseInt(scan.nextLine());
        int stvacancies = Integer.parseInt(scan.nextLine());
        Students stobj = new Students(studcount, vacancies, unrevacancies,
            bcvacancies, scvacancies, stvacancies);
        String[] sinfo = null;
        for (int i = 0; i < studcount; i++) {
            sinfo = scan.nextLine().split(",");
            stobj.add(new StudentInfo(sinfo[0], sinfo[1],
                Integer.parseInt(sinfo[2]),
                Integer.parseInt(sinfo[2 + 1]),
                Integer.parseInt(sinfo[2 + 2]),
                Integer.parseInt(sinfo[2 + 2 + 1]), (sinfo[2 + 2 + 2])));
        }
        StudentInfo[] stinfo = stobj.getInfo();
        sort.insertionSort(stinfo, 0, stinfo.length - 1, StudentInfo.comp);
        sort.print(stinfo);
        System.out.println();
        StudentInfo[] srtedCatobj = stobj.applications(stinfo);
        stobj.print(srtedCatobj);
    }
}
