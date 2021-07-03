package nikkei2019_qual;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		char[] c = sc.next().toCharArray();

		int result = 0;
		for(int i = 0; i < n; i++){
			int tmp = 0;

			if(a[i] == b[i]){
				tmp++;
			}
			if(b[i] == c[i]){
				tmp++;
			}
			if(c[i] == a[i]){
				tmp++;
			}

			switch (tmp) {
			case 0:
				result += 2;
				break;
			case 1:
				result++;
				break;
			default:
				break;
			}

		}

		System.out.println(result);
	}
}
