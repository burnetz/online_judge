package hitachi2020;

import java.util.Scanner;
import java.util.Vector;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int na = sc.nextInt();
		int nb = sc.nextInt();
		int m = sc.nextInt();

		int a[] = new int[na];
		int b[] = new int[nb];
		@SuppressWarnings("unchecked")
		Vector<Ticket>[] tickets = new Vector[na];

		for(int i = 0; i < na; i++){
			a[i] = sc.nextInt();
			tickets[i] = new Vector<>();
		}

		int cheep = Integer.MAX_VALUE;
		for(int i = 0; i < nb; i++){
			b[i] = sc.nextInt();

			cheep = Math.min(cheep, b[i]);
		}

		for(int i = 0; i < m; i++){
			int x = sc.nextInt() - 1;
			Ticket tmp = new Ticket(sc.nextInt() - 1, sc.nextInt());

			tickets[x].add(tmp);
		}

		int result = Integer.MAX_VALUE;
		for(int i = 0; i < na; i++){
			result = Math.min(result, a[i] + cheep);

			for(int j = 0; j < tickets[i].size(); j++){
				result = Math.min(result, a[i] + b[tickets[i].elementAt(j).microwave] - tickets[i].elementAt(j).pricedown);
			}
		}

		System.out.println(result);
	}

}

class Ticket {
	int microwave;
	int pricedown;

	Ticket(int mic, int pd){
		microwave = mic;
		pricedown = pd;
	}
}