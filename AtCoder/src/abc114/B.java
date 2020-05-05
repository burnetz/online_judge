package abc114;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String s = sc.next();

		int minDiff = Integer.MAX_VALUE;

		for(int i = 0; i + 2 < s.length(); i++){
			int tmp = Integer.parseInt(s.substring(i, i + 3));

			minDiff = Math.min(minDiff, Math.abs(753 - tmp));
		}

		System.out.println(minDiff);

	}

}
