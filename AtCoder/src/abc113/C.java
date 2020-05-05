package abc113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int n = Integer.parseInt(tmpArray[0]);
		int m = Integer.parseInt(tmpArray[1]);

		City cities[] = new City[m];
		City cities2[] = new City[m];

		for(int i = 0; i < m; i++){
			tmpArray = br.readLine().split(" ");

			int p = Integer.parseInt(tmpArray[0]);
			int y = Integer.parseInt(tmpArray[1]);

			cities[i] = new City(p, y);
			cities2[i] = cities[i];
		}

		Arrays.sort(cities);

		for(int i = 0; i < m; i++){
			if(i == 0 || cities[i].pref != cities[i - 1].pref){
				cities[i].idInPref = 1;
			}
			else {
				cities[i].idInPref = cities[i - 1].idInPref + 1;
			}
		}

		for(int i = 0; i < m; i++){
			System.out.printf("%06d%06d\n", cities2[i].pref, cities2[i].idInPref);
		}
	}

}

class City implements Comparable<City>{

	int id;
	private static int idSeed = 0;
	int pref;
	int year;
	int idInPref = 0;

	City(int pref, int year){
		id = idSeed++;
		this.pref = pref;
		this.year = year;
	}
	public int compareTo(City c1) {
		// TODO Auto-generated method stub
		return this.pref == c1.pref ?
			(this.year - c1.year) : this.pref - c1.pref;
	}

}
