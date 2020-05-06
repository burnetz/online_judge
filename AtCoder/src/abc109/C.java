package abc109;

import java.util.Scanner;

public class C {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();

		int absPos[] = new int[n];

		for(int i = 0; i < n; i++){
			absPos[i] = Math.abs(x - sc.nextInt());
		}

		int gcd = absPos[0];
		for(int i = 1; i < n; i++){
			gcd = gcd(gcd, absPos[i]);
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
