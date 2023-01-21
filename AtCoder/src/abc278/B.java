package abc278;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int h = sc.nextInt();
		int m = sc.nextInt();
		
		int time = h*60 + m;
		int mod = 60*24;
		
		while(true) {
			int tmpH = time / 60;
			int a = tmpH / 10;
			int b = tmpH % 10;
			
			int tmpM = time % 60;
			int c = tmpM / 10;
			int d = tmpM % 10;
			
			int h2 = a*10 + c;
			int m2 = b*10 + d;
			
			if(h2 <= 23 && m2 <= 59) {
				System.out.println((a*10 + b) + " " + (c*10 + d));
				break;
			}
			
			time++;
			time %= mod;
		}
	}
}
