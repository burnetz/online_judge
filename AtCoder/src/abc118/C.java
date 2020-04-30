package abc118;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		//ユークリッドの互除法みたいなパターンで攻撃されると体力が最小になる
		int gcd = a[0];
		for(int i = 1 ; i < n; i++){
			gcd = gcd(a[i], gcd);
		}

		System.out.println(gcd);
	}

	static int gcd(int a, int b){
    	int tmp;

    	while (a % b != 0)
    	{
    		tmp = b;
    		b = a % b;
    		a = tmp;
    	}
    	return b;
    }
}