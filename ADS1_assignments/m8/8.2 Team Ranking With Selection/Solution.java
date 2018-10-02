import java.util.Scanner;
import java.util.Arrays;
class TeamInfo {
	private String name;
	private int wins;
	private int losses;
	private int draws;
	TeamInfo(String team, int won, int lost, int draw) {
		name = team;
		wins = won;
		losses = lost;
		draws = draw;
	}

	public int compareTo(TeamInfo that) {
		if (this.wins < that.wins) {
			return 1;
		}
		if (this.wins > that.wins) {
			return -1;
		}
		else {
			if (this.losses < that.losses) {
				return -1;
			}
			if (this.losses > that.losses) {
				return 1;
			}
			else {
				if (this.draws < that.draws) {
					return 1;
				}
				if (this.draws > that.draws) {
					return -1;
				}
			}
		}
		return 0;
	}

	public String getName() {
		return this.name;
	}
}


class LeadBoard {
	InsertionSort sorted = new InsertionSort();
	TeamInfo[] teams;
	int size;

	LeadBoard() {
		teams = new TeamInfo[1];
		size = 0;
	}

	public void resize() {
		teams = Arrays.copyOf(teams, teams.length + 1);
	}

	public void addTeam(TeamInfo team) {
		if (size == teams.length) {
			resize();
		}
		teams[size++] = team;
	}

	public void print() {
		TeamInfo[] sortedteams = sorted.sorting(teams);
		for (int i = 0; i < size - 1; i++) {
			System.out.print(sortedteams[i].getName() + ",");
		}
		System.out.println(sortedteams[size - 1].getName());
	}
}

class InsertionSort {

	InsertionSort() {
		//Not Using This Constructor.
	}

	public TeamInfo[] sorting(TeamInfo[] teams) {
		int j = 0;
		for (int i = 1; i < teams.length; i++) {
			TeamInfo team = teams[i];
			j = i - 1;
			int value = teams[i].compareTo(teams[j]);
			while (j >= 0 && value == -1) {
				teams[j + 1] = teams[j];
				j -= 1;
				if (j > 0) {
					value = teams[i].compareTo(teams[j]);
				}
			}
			teams[j + 1] = team;
		}	
		return teams;
	}
}


public class Solution {
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