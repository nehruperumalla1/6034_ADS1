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

	public String getName() {
		return this.name;
	}
}


class SelectionSort {
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

	public TeamInfo[] exchange(TeamInfo[] teams, int min, int index) {
		TeamInfo temp = teams[min];
		teams[min] = teams[index];
		teams[index] = temp;
		return teams;
	}
}

class LeadBoard {
	SelectionSort sort = new SelectionSort();
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
		TeamInfo[] sortedteams = sort.selectsort(teams);
		for (int i = 0; i < size - 1; i++) {
			System.out.print(sortedteams[i].getName() + ",");
		}
		System.out.println(sortedteams[size - 1].getName());
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