package arc137;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long result = 1;
		//基本的には2重ループで愚直に解を探すが
		//素数を含む組み合わせを見つけた後はより良い解は発生しない。
		//素数の間隔はせいぜい1500程度なのでそれを超えたら途中でやめて良い。
		for(int i = 0; i <= 1500 && b - i > a ; i++) {
			for(int j = 0; j <= 1500 && b - i > a + j; j++) {
				if(gcd(a + j, b - i) == 1) {
					result = Math.max(result, b - i - (a + j));
				}
			}
		}
		
		System.out.println(result);
	}
	
	static long gcd(long a, long b){
        long tmp;

        while (a % b != 0)
        {
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }
}