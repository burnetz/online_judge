package arc069;

import java.io.IOException;
import java.util.Scanner;

public class C {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		long m = sc.nextLong();
		
		//Sが過剰ならCの個数によって答えが確定
		if(n*2 >= m) {
			System.out.println(m/2);
		}
		//Cが過剰なとき
		else {
			//まずはSの個数に合わせてCを消費
			long result = n;
			m -= 2*n;
			
			//Cが4つあればSCCを1つ作れる
			result += m/4;
			
			System.out.println(result);
		}
	}

}
