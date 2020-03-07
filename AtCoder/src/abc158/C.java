package abc158;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		//乱暴な気はするが十分間に合う
		for(int i = 1; i <= 1100 ; i++){
			if((int)(0.08*i) == a && (int)(0.1*i) == b ){
				System.out.println(i);
				return;
			}
		}

		System.out.println("-1");
	}
}
