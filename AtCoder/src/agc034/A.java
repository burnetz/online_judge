package agc034;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt() - 1;
		int b = sc.nextInt() - 1;
		int c = sc.nextInt() - 1;
		int d = sc.nextInt() - 1;

		char[] str = sc.next().toCharArray();

		//スタート地点よりゴールが左側は論外
		if(a > c || b > d){
			System.out.println("No");
			return;
		}
		else {
			//基本的に1歩ずつ進んでみる。2歩でも超えられないところがあれば不可
			for(int i = a; i < c;){
				if(str[i + 1] == '.'){
					i++;
				}
				else if(str[i + 2] == '.'){
					i += 2;
				}
				else {
					System.out.println("No");
					return;
				}
			}


			for(int i = b; i < d;){
				if(str[i + 1] == '.'){
					i++;
				}
				else if(str[i + 2] == '.'){
					i += 2;
				}
				else {
					System.out.println("No");
					return;
				}
			}

			//c > dのとき追い越しが発生する。そのためにはどこかに3連続空白が必要
			boolean enoughSpace = false;
			for(int i = b; i <= d; i++){
				if(i >= 1 && i < n - 1 && str[i - 1] == '.' && str[i] == '.' && str[i + 1] == '.'){
					enoughSpace = true;
				}

			}
			if(c > d && !enoughSpace){
				System.out.println("No");
				return;
			}
			else {
				System.out.println("Yes");
				return;
			}
		}
	}
}