package arc001;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		char[] str = sc.next().toCharArray();

		int min = n;
		int max = 0;

		for(int i = '1'; i <= '4'; i++){
			int tmp = 0;

			for(int j = 0; j < n; j++){
				if(str[j] == i){
					tmp++;
				}
			}

			min = Math.min(min, tmp);
			max = Math.max(max, tmp);
		}

		System.out.println(max+" "+min);
	}

}
