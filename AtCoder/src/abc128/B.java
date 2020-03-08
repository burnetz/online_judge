package abc128;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Restaurant restaurants[] = new Restaurant[n];
		for(int i = 0; i < n; i++){
			String city = sc.next();
			int score = sc.nextInt();

			restaurants[i] = new Restaurant(i + 1, city, score);

		}

		Arrays.sort(restaurants);

		for(int i = 0; i < n; i++){
			System.out.println(restaurants[i].id);
		}
	}

}

class Restaurant implements Comparable<Restaurant>{
	int id;
	String city;
	int score;

	public Restaurant(int id, String city, int score) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.id = id;
		this.city = city;
		this.score = score;
	}

	@Override
	public int compareTo(Restaurant r1) {
		// TODO 自動生成されたメソッド・スタブ
		return this.city.equals(r1.city) ? r1.score - this.score : this.city.compareTo(r1.city);
	}

}