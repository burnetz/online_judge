package abc208;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long k = sc.nextLong();

		Person[] people = new Person[n];
		Person[] peopleCopy = new Person[n];

		for(int i = 0; i < n; i++){
			people[i] = new Person(sc.nextInt());
			peopleCopy[i] = people[i];
		}

		Arrays.sort(people);

		long basic = k/n;

		for(int i = 0; i < n; i++){
			people[i].treat = basic;
		}

		k %= n;

		for(int i = 0; i < k; i++){
			people[i].treat++;
		}

		for(int i = 0; i < n; i++){
			System.out.println(peopleCopy[i].treat);
		}
	}

}

class Person implements Comparable<Person>{
	int id;
	long treat = 0;

	Person(int id){
		this.id = id;
	}
	@Override
	public int compareTo(Person p) {
		// TODO 自動生成されたメソッド・スタブ
		return this.id - p.id;
	}
}