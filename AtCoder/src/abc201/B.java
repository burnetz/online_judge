package abc201;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Mt mts[] = new Mt[n];

		for(int i = 0; i < n; i++){
			mts[i] = new Mt(sc.next(), sc.nextInt());
		}

		Arrays.sort(mts);

		System.out.println(mts[1].name);
	}

}

class Mt implements Comparable<Mt>{
	String name;
	int height;

	Mt(String name, int height){
		this.name = name;
		this.height = height;
	}

	@Override
	public int compareTo(Mt mt) {
		// TODO 自動生成されたメソッド・スタブ
		return - this.height + mt.height;
	}
}