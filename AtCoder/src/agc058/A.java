package agc058;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n * 2];
		
		for(int i = 0; i < n * 2; i++) {
			a[i] = sc.nextInt();
		}
		
		int count = 0;
		StringBuffer sb = new StringBuffer();
		//基本的には期待通りじゃない箇所を見つけてその都度スワップすればOK
		for(int i = 0; i < 2*n - 1; i++) {
			if(i % 2 == 0 && a[i] > a[i + 1]) {
				//i番目とi+1番目ではなくi+1番目とi+2番目のスワップで済むならできるだけそうする。
				if(i < 2*n - 2 && a[i] < a[i + 2]) {
					sb.append((i + 2) + " ");
					int tmp = a[i + 2];
					a[i + 2] = a[i + 1];
					a[i + 1] = tmp;
				}
				//i番目とi+1番目のスワップ。こちらだけでも条件を満たす数列は必ず作れるが
				//手数がNで収まる保証が無いためできるだけ上の分岐を使う。
				else {
					sb.append((i + 1) + " ");
					a[i + 1] = a[i];
				}
				count++;
			}
			else if(i % 2 == 1 && a[i] < a[i + 1]) {
				if(i < 2*n - 2 && a[i] > a[i + 2]) {
					sb.append((i + 2) + " ");
					int tmp = a[i + 2];
					a[i + 2] = a[i + 1];
					a[i + 1] = tmp;
				}
				else {
					sb.append((i + 1) + " ");
					a[i + 1] = a[i];
				}
				count++;
			}
		}
		System.out.println(count);
		System.out.println(sb);
	}
}
