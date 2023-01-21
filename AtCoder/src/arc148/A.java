package arc148;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		//0しかないなら答えは1
		if(a[n - 1] == 0) {
			System.out.println(1);
			return;
		}
		
		//答えとしてあり得る最大値は2（mod 2を考えれば必ず余りは0か1なので）。
		//答えが1となるのは各要素の差分が1以外の公約数を持つこと。
		int gcd = a[1] - a[0];
		for(int i = 2; i < n ; i++) {
			int d = a[i] - a[i - 1];
			
			if(d == 0) {
				continue;
			}
			if(gcd == 0) {
				gcd = d;
			}
			
			gcd = gcd(d, gcd);
		}
		if(gcd == 1) {
			System.out.println(2);
		}
		else {
			System.out.println(1);
		}
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