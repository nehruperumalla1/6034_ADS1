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

    private int sub1;
    private int sub2;
    private int sub3;
    private int tmarks;
    private String category;
    private static int DAYS = 30;

    StudentInfo(String n, String b, int s1, int s2, int s3, int totmarks, String cat) {
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

    public String getName() {
        return name;
    }

    public int getMarks() {
        return tmarks;
    }

    public String getCategory() {
        return category;
    }

    static Comparator<StudentInfo> comp = new Comparator<StudentInfo>() {
        public int compare(StudentInfo s1, StudentInfo s2) {
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
                    return (((count - s1.dob[1]) * DAYS) - ((count - s2.dob[1]) * DAYS));
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
     * { var_description }
     */
    private StudentInfo[] info;
    /**
     * { var_description }
     */
    private int num;
    /**
     * { var_description }
     */
    private int size;
    /**
     * { var_description }
     */
    private StudentInfo[] vacancies;
    /**
     * { var_description }
     */
    private int vacsize;
    private int urvac;
    private int bcvac;
    private int scvac;
    private int stvac;
    public Students(int data, int vacan, int urvc, int bvc, int svc, int stvc) {
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
     * { function_description }
     *
     * @param      sortedinfo  The sortedinfo
     *
     * @return     { description_of_the_return_value }
     */
    public StudentInfo[] applications(StudentInfo[] sortedinfo) {
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
     * { function_description }
     *
     * @param      stud  The stud
     */
    public void add(StudentInfo stud) {
        if (size == info.length) {
            resize();
        }
        info[size++] = stud;
    }

    /**
     * { function_description }
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
     * { function_description }
     *
     * @param      inf   The inf
     */
    public void print(StudentInfo[] inf) {
        for (int i = 0; i < inf.length; i++) {
            System.out.println(inf[i].getName() + "," +
                inf[i].getMarks() + "," + inf[i].getCategory());
        }
    }
}

/**
 * Class for solution.
 */
public class Solution {
    /**
     * main Method.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
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