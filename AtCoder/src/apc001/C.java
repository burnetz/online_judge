package apc001;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		//とりあえず0番目の席を聞いておく
		int n = sc.nextInt();
		System.out.println(0);
		
		String input = sc.next();
		boolean maleStart = false;
		
		if(input.equals("Vacant")) {
			return;
		}
		else if(input.equals("Male")) {
			maleStart = true;
		}
		
		int left = 0;
		int right = n;
		//0からn-1までの一方向のみを考える。反対方向は考えなくてOK
		//空席になるまでは男性と女性の偶奇は変化しないので
		//偶奇が崩れた瞬間を二分探索で探す。
		for(int i = 0; i < 20; i++) {
			int output = (left + right)/2;
			
			System.out.println(output);
			
			input = sc.next();
			boolean valid = true;
			if(input.equals("Vacant")) {
				return;
			}
			else if(input.equals("Male")) {
				if(maleStart && output%2 == 1) {
					valid = false;
				}
				if(!maleStart && output%2 == 0) {
					valid = false;
				}
			}
			else {
				if(maleStart && output%2 == 0) {
					valid = false;
				}
				if(!maleStart && output%2 == 1) {
					valid = false;
				}
			}
			
			if(valid) {
				left = output;
			}
			else {
				right = output;
			}
		}
	}

}
