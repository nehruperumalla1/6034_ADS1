import java.util.Arrays;
import java.util.Scanner;

/**
 * Class for students.
 */
class Students {
    /**
     * { StudentInfo Object Array }.
     */
    private StudentInfo[] info;
    /**
     * { num Variable }.
     */
    private int num;
    /**
     * { size of StudentInfo Array }.
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
     * { Add Object to Object Array }.
     * Complexity of Add Method is O(1).
     * Because adding the Element at particular index.
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
     * { Resizing the Array }.
     * Complexity for Resizing Array is O(N).
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


/**
 * Class for category criteria.
 */
class CategoryCriteria {
    /**
     * Constructs the object.
     */
    private CategoryCriteria() {
        //Unused.
    }
    /**
     * { Object for Merge Class }.
     */
    private InsSort isort = new InsSort();
    /**
     * { No.of applied }.
     */
    private int applied;
    /**
     * { No.of Vacancies }.
     */
    private int vacancies;
    /**
     * { No.of Unrevacancies }.
     */
    private int urevacancies;
    /**
     * { No.of BC Vacancies }.
     */
    private int bcvac;
    /**
     * { No.of SC Vacancies }.
     */
    private int scvac;
    /**
     * { No.of ST Vacancies }.
     */
    private int stvac;
    /**
     * { Size of the Array }.
     */
    private int asize;
    /**
     * { Duplicate array for Sorted Objects }.
     */
    private StudentInfo[] dupSorted;
    /**
     * { size of the Object Array }.
     */
    private int size;
    /**
     * { Array to store objects according category }.
     */
    private StudentInfo[] catSorted;
    /**
     * Constructs the object.
     *
     * @param      app     The application
     * @param      vac     The vac
     * @param      urev    The urev
     * @param      bv      { BC Vacancies }
     * @param      sv      { SC Vacancies }
     * @param      stv     The stv
     * @param      sorted  The sorted
     */
    CategoryCriteria(final int app, final int vac, final int urev,
        final int bv, final int sv, final int stv, final StudentInfo[] sorted) {
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

    /**
     * { Checks whether the Object contained in Array }.
     * Complexity of Contains is O(N).
     * It Iterates through out the Array w.r.t its size.
     *
     * @param      student  The student
     *
     * @return     { Returns true id=f contains else false }
     */
    private boolean contains(final StudentInfo student) {
        for (int i = 0; i < asize; i++) {
            if (catSorted[i].getName().equals(student.getName())) {
                return true;
            }
        }
        return false;
    }
    /**
     * { Categorising According to Criteria }.
     * Complexity of catCriteria is O(N ^ 2).
     * Iterates through array if Category matches it places
     * the Student in the array.
     * After placing the students in array it sorts using insertion sort.
     * So, the worst case complexity of Insertion Sort is O(N ^ 2).
     */
    public void catCriteria() {
        for (int i = 0; i < urevacancies; i++) {
            catSorted[asize++] = dupSorted[i];
        }

        for (int i = 0; i < dupSorted.length; i++) {
            if (!contains(dupSorted[i])) {
                if (dupSorted[i].getCategory().equals("BC") && bcvac > 0) {
                    catSorted[asize++] = dupSorted[i];
                    bcvac--;
                } else if (dupSorted[i].getCategory().equals("SC")
                    && scvac > 0) {
                    catSorted[asize++] = dupSorted[i];
                    scvac--;
                } else if (dupSorted[i].getCategory().equals("ST")
                    && stvac > 0) {
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
        isort.insertionSort(
            catSorted, 0, catSorted.length - 1, StudentInfo.comp);
        isort.print(catSorted);
    }
}


/**
 * Class for solution.
 */
public final class Solution {
    /**
     * { Constructor }.
     */
    private Solution() {
    }
    /**
     * main Method.
     * Complexity of Solution is O(N).
     * It creates the object based upon the Student count mentioned initially.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int studcount = Integer.parseInt(scan.nextLine());
        InsSort sort = new InsSort();
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
                Integer.parseInt(sinfo[2 + 2 + 1]),
                (sinfo[2 + 2 + 2])));
        }
        StudentInfo[] stinfo = stobj.getInfo();
        sort.insertionSort(stinfo, 0, stinfo.length - 1, StudentInfo.comp);
        sort.print(stinfo);
        System.out.println();
        CategoryCriteria ccobj = new CategoryCriteria(
            studcount, vacancies, unrevacancies, bcvacancies,
            scvacancies, stvacancies, stinfo);
        ccobj.catCriteria();
    }
}
