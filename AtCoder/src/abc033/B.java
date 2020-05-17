package abc033;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int sum = 0;
		int largeNum = 0;
		String largeName = "";

		for(int i = 0; i < n; i++){
			String s = sc.next();
			int p = sc.nextInt();

			if(largeNum < p){
				largeNum = p;
				largeName = s;
			}

			sum += p;
		}

		if(largeNum > sum/2){
			System.out.println(largeName);
		}
		else {
			System.out.println("atcoder");
		}
	}
}