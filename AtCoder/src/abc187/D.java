package abc187;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		City cities[] = new City[n];
		long taka = 0;
		long aoki = 0;
		
		for(int i = 0; i < n; i++) {
			cities[i] = new City(sc.nextLong(), sc.nextLong());
			aoki += cities[i].aoki;
		}
		
		Arrays.parallelSort(cities);
		
		for(int i = 0; i < n; i++) {
			taka += cities[i].takahashi + cities[i].aoki;
			aoki -= cities[i].aoki;
			
			if(taka > aoki) {
				System.out.println(i + 1);
				return;
			}
		}
	}

}

class City implements Comparable<City>{
	long takahashi;
	long aoki;
	
	City(long aoki, long takahashi){
		this.takahashi = takahashi;
		this.aoki = aoki;
	}

	//演説をしなかった場合は高橋さんから見て青木さんがaoki分上回る
	//演説をすれば高橋さんがtakahashi+aokiの票を得る
	//(takahashi + aoki) + aoki でソートして貪欲法で解く
	@Override
	public int compareTo(City c) {
		// TODO Auto-generated method stub
		long a = this.takahashi + 2*this.aoki;
		long b = c.takahashi + 2*c.aoki;
		return a == b ? 0 : 
			a < b ? 1 : -1;
	}
	
	
}