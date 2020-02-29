package abc143;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] str = sc.next().toCharArray();

		int result = 1;
		for(int i = 1; i < n; i++){
			if(str[i] != str[i - 1]){
				result++;
			}
		}

		System.out.println(result);
	}

}
