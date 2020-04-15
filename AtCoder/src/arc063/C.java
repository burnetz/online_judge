package arc063;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();
		
		//最終的にどちらの色にするかは関係ない
		//重要なのは色が変わるタイミングがもともと何回あるかだけ
		int changed = 0;
		for(int i = 1; i < str.length; i++) {
			if(str[i] != str[i - 1]) {
				changed++;
			}
		}
		
		System.out.println(changed);
	}

}
