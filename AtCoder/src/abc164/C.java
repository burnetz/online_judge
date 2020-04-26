package abc164;

import java.util.HashSet;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);


		int n = sc.nextInt();

		HashSet<String> set = new HashSet<String>();

		for(int i = 0; i < n; i++){
			set.add(sc.next());
		}

		System.out.println(set.size());
	}

}
