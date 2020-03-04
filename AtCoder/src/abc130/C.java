package abc130;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long w = sc.nextLong();
		long h = sc.nextLong();
		long x = sc.nextLong();
		long y = sc.nextLong();
		
		//もう一点を中心にすれば良いので必ず半分に分けられる
		System.out.print((double)w*h/2+" ");
		
		//もともと(x,y)が中心のときはパターンが無限
		if((double)x == (double)w/2 && (double)y == (double)h/2) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}

}
