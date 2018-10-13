import java.util.Scanner;
import java.util.Comparator;
class Stock {
	private String company;
	private double percentchange;
	Stock(String name, double change) {
		company = name;
		percentchange = change;
	}

	public String getCompany() {
		return company;
	}

	public double getChange() {
		return percentchange;
	}

	public void setChange(double change) {
		percentchange = change;
	}

	static Comparator<Stock> comp = new Comparator<Stock>() {
		public int compare(final Stock s1, final Stock s2) {
			if (s1.getChange() != s2.getChange()) {
				int cmp =(int) (100 * (s1.getChange() - s2.getChange()));
				return cmp;
			}
			return s1.getCompany().compareTo(s2.getCompany());
		}
	};
}

public class Solution {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int count = Integer.parseInt(sca.nextLine());
		int i = 1;
		int find = 0;
		int counter = count;
		int flag = 0;
		String[] data = null;
		Tables<String> maxSt = new Tables<String>(count);
		Tables<String> minSt = new Tables<String>(count);
		while (flag < 6) {
			MinPQ<Stock> minpq = new MinPQ<Stock>(count, Stock.comp);
			MaxPQ<Stock> maxpq = new MaxPQ<Stock>(count, Stock.comp);
			i = 1;
			while (i <= count) {
				data = sca.nextLine().split(",");
				if (data.length == 1) {
					break;
				}
				// System.out.println("Hai");
				Stock stock = new Stock(data[0], Double.parseDouble(data[1]));
				minpq.insert(stock);
				maxpq.insert(stock);
				// System.out.println(maxpq.size() + "  MaxPq Size");
				if (i == count) {
					while (find < 5) {
						if (!maxpq.isEmpty()) {
							Stock max = maxpq.delMax();
							maxSt.put(max.getCompany(), 1);
							System.out.println(max.getCompany() + " " + max.getChange());
						}
						find++;
					}
					find = 0;
					System.out.println();
					while (find < 5) {
						if (!minpq.isEmpty()) {
							Stock min = minpq.delMin();
							minSt.put(min.getCompany(), 1);
							System.out.println(min.getCompany() + " " + min.getChange());
						}
						find++;
					}
					System.out.println();
					find = 0;
				}
				i++;
			}
			if (data.length == 1) {
				break;
			}
		}
		while (sca.hasNext()) {
			String[] dat = sca.nextLine().split(",");
			switch(dat[0]) {
				case "get":
					if (dat[1].equals("maxST")) {
						System.out.println(maxSt.get(dat[2]));
					} else {
						System.out.println(minSt.get(dat[2]));
					}
				break;
			}
		}
	}
}
