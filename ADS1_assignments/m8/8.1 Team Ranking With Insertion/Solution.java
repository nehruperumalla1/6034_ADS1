import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for Team Information.
 */
class TeamInfo {
    /**
     * Name of the Team(String).
     */
    private String name;
    /**
     * No.of Wins of that Team(int).
     */
    private int wins;
    /**
     * No.of losses of that Team(int).
     */
    private int losses;
    /**
     * No.of draws of that Team(int).
     */
    private int draws;
    /**
     * Constructs the object.
     *
     * @param      team  The team
     * @param      won   The won
     * @param      lost  The lost
     * @param      draw  The draw
     */
    TeamInfo(final String team, final int won, final int lost, final int draw) {
        name = team;
        wins = won;
        losses = lost;
        draws = draw;
    }

	/**
	 * Method to check which value of Team is higher is lower.
	 *
	 * @param      that  The that
	 *
	 * @return     { Returns the boolean Value true if there is need to swap
	 *               else false}
	 */
	public boolean less(TeamInfo that) {
		if (this.wins < that.wins) {
			return true;
		}
		if (this.wins > that.wins) {
			return false;
		} else {
			if (this.losses < that.losses) {
				return false;
			}
			if (this.losses > that.losses) {
				return true;
			} else {
				if (this.draws < that.draws) {
					return true;
				}
				if (this.draws > that.draws) {
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * Gets the Team Name.
	 *
	 * @return     The name.
	 */
	public String getName() {
		return this.name;
	}
}


/**
 * Class for selection sort.
 */
class SelectionSort {

	/**
	 * Sorting of TeamInfo Objects based on Wins, losses, draws
	 * using selection sort.
	 *
	 * @param      teams  The teams
	 *
	 * @return     { Returns the sorted array of objects }
	 */
	public TeamInfo[] selectsort(TeamInfo[] teams) {
		int min = 0;
		for (int i = 0; i < teams.length; i++) {
			min = i;
			for (int j = i + 1; j < teams.length; j++) {
				if (teams[min].less(teams[j])) {
					min = j;
				}
			}
			teams = exchange(teams, min, i);
		}
		return teams;
	} 

	/**
	 * This method is used to swap the objects in an array.
	 *
	 * @param      teams  The teams
	 * @param      min    The minimum
	 * @param      index  The index
	 *
	 * @return     { Returns the array after swapping the objects }
	 */
	public TeamInfo[] exchange(TeamInfo[] teams, int min, int index) {
		TeamInfo temp = teams[min];
		teams[min] = teams[index];
		teams[index] = temp;
		return teams;
	}
}

/**
 * Class for lead board.
 */
class LeadBoard {
	/**
	 * Object of Selection Sort class.
	 */
	private SelectionSort sort = new SelectionSort();
	/**
	 * Creates the object array of Class TeamInfo.
	 */
	private TeamInfo[] teams;
	/**
	 * Size of the Object Array.
	 */
	private int size;

	/**
	 * Constructs the object.
	 */
	LeadBoard() {
		teams = new TeamInfo[1];
		size = 0;
	}

	/**
	 * Resize Method for Resizing object Array.
	 */
	public void resize() {
		teams = Arrays.copyOf(teams, teams.length + 1);
	}

	/**
	 * Adds a team to Object Array.
	 *
	 * @param      team  The team
	 */
	public void addTeam(TeamInfo team) {
		if (size == teams.length) {
			resize();
		}
		teams[size++] = team;
	}
	/**
	 * To Print the Team Names after sorting.
	 */
	public void print() {
		TeamInfo[] sortedteams = sort.selectsort(teams);
		for (int i = 0; i < size - 1; i++) {
			System.out.print(sortedteams[i].getName() + ",");
		}
		System.out.println(sortedteams[size - 1].getName());
	}
}



/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Main Method for Sorting the Teams using Selection Sort.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		LeadBoard cricketobj = new LeadBoard();
		Scanner scan = new Scanner(System.in);
		String[] info = null;
		while (scan.hasNext()) {
			info = scan.nextLine().split(",");
			cricketobj.addTeam(new TeamInfo(info[0], Integer.parseInt(info[1]),
				Integer.parseInt(info[2]), Integer.parseInt(info[3])));
		}
		cricketobj.print();
	}
}