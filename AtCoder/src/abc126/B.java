package abc126;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		int aa = input / 100;
		int bb = input % 100;
		
		boolean yymm = false;
		boolean mmyy = false;
		
		if(aa >= 1 && aa <= 12) {
			mmyy = true;
		}
		
		if(bb >= 1 && bb <= 12) {
			yymm = true;
		}
		
		if(yymm && mmyy) {
			System.out.println("AMBIGUOUS");
		}
		else if(yymm && !mmyy) {
			System.out.println("YYMM");
		}
		else if(!yymm && mmyy) {
			System.out.println("MMYY");
		}
		else {
			System.out.println("NA");
		}
	}

}
