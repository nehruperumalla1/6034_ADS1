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
    private static final int DAYS = 30;

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
     * Constructs the object.
     *
     * @param      data   The data
     */
    Students(final int data) {
        num = data;
        info = new StudentInfo[num];
        size = 0;
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
}


class CategoryCriteria {
    Merge mergee = new Merge();
	private int applied;
	private int vacancies;
	private int urevacancies;
	private int bcvac;
	private int scvac;
	private int stvac;
	private int asize;
	private StudentInfo[] dupSorted;
	private int size;
    private StudentInfo[] catSorted;
	CategoryCriteria(int app, int vac, int urev, int bv, int sv, int stv, StudentInfo[] sorted) {
		applied = app;
		vacancies = vac;
		urevacancies = urev;
		bcvac = bv;
		scvac = sv;
		stvac = stv;
		dupSorted = sorted;
		asize = 0;
		size = sorted.length;
        catSorted = new StudentInfo[vacancies];

	}

    private boolean contains(StudentInfo student) {
        for (int i = 0; i < asize; i++) {
            if (catSorted[i].getName().equals(student.getName())) {
                // System.out.println(catSorted[i].getName());
                return true;
            }
        }
        return false;
    }
	public void catCriteria() {
		for (int i = 0; i < urevacancies; i++) {
			catSorted[asize++] = dupSorted[i];
		}

        for (int i = 0; i < dupSorted.length; i++) {
            if (!contains(dupSorted[i])) {
                if (dupSorted[i].getCategory().equals("BC") && bcvac > 0) {
                    catSorted[asize++] = dupSorted[i];
                    bcvac--;
                } else if (dupSorted[i].getCategory().equals("SC") && scvac > 0) {
                    catSorted[asize++] = dupSorted[i];
                    scvac--;
                } else if (dupSorted[i].getCategory().equals("ST") && stvac > 0) {
                    catSorted[asize++] = dupSorted[i];
                    stvac--;
                }
            }
        }

        for (int i = 0; i < dupSorted.length; i++) {
            if (!contains(dupSorted[i])) {
                if (bcvac-- > 0) {
                    catSorted[asize++] = dupSorted[i];
                } else if (scvac-- > 0) {
                    catSorted[asize++] = dupSorted[i];
                } else if (stvac-- > 0) {
                    catSorted[asize++] = dupSorted[i];
                }
            }
        }
        mergee.insertionSort(catSorted, 0, catSorted.length - 1, StudentInfo.comp);
        mergee.print(catSorted);
	}
}


/**
 * Class for solution.
 */
public final class SolutionModified {
    /**
     * { item_description }.
     */
    private SolutionModified() {
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
        Students stobj = new Students(studcount);
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
        CategoryCriteria ccobj = new CategoryCriteria(studcount, vacancies, unrevacancies, bcvacancies, scvacancies, stvacancies, stinfo);
        ccobj.catCriteria();
    }
}
