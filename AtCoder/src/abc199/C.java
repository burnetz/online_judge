package abc199;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		char[] s = sc.next().toCharArray();
		int q = sc.nextInt();

		boolean reverse = false;

		for(int i = 0; i < q; i++){
			int t = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			if(t == 2){
				//真面目にすべての文字を入れ替える必要はない
				//前半と後半のどちらを操作するかを反転させればよい
				reverse = !reverse;
			}

			else {
				if(!reverse){
					swapChar(s, a - 1, b - 1);
				}
				else {
					swapChar(s, (a - 1 + n) % (2*n), (b - 1 + n) % (2*n));
				}
			}
		}

		if(!reverse){
			System.out.println(s);
		}
		else {
			System.out.println(new String(s).substring(n) + new String(s).substring(0, n));
		}
	}
	static void swapChar(char[] s, int a, int b){
		char tmp = s[a];

		s[a] = s[b];
		s[b] = tmp;

	}
}