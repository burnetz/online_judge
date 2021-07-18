package abc210;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String s = sc.next();

		if(s.indexOf('1') % 2 == 0){
			System.out.println("Takahashi");
		}
		else{
			System.out.println("Aoki");
		}
	}
}
