package agc054;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] str = sc.next().toCharArray();

		if(str[0] != str[str.length - 1]){
			System.out.println(1);
			return;
		}
		else {
			for(int i = 1; i < str.length - 2; i++){
				if(str[0] != str[i] && str[i + 1] != str[str.length - 1]){
					System.out.println(2);
					return;
				}
			}
			System.out.println(-1);
		}
	}
}
