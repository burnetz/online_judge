package abc182;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		
		int k = s.length();
		
		int mod[] = new int[3];
		int sumMod = 0;
		for(int i = 0; i < k; i++) {
			mod[(s.charAt(i) - '0')%3]++;
			sumMod += s.charAt(i) - '0';
		}
		
		sumMod %= 3;
		
		if(sumMod == 0) {
			System.out.println(0);
		}
		else if(sumMod == 1) {
			if(mod[1] > 0 && k >= 2) {
				System.out.println(1);
			}
			else if(mod[2] > 1 && k >= 3) {
				System.out.println(2);
			}
			else {
				System.out.println(-1);
			}
		}
		else {
			if(mod[2] > 0 && k >= 2) {
				System.out.println(1);
			}
			else if(mod[1] > 1 && k >= 3) {
				System.out.println(2);
			}
			else {
				System.out.println(-1);
			}
		}
	}
	

}
