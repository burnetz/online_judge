package arc003;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		char[] str = sc.next().toCharArray();

		int score = 0;
		for(int i = 0; i < n; i++){
			switch(str[i]){
			case 'A':
				score += 4;
				break;
			case 'B':
				score += 3;
				break;
			case 'C':
				score += 2;
				break;
			case 'D':
				score += 1;
				break;
			}
		}

		double gpa = 0;

		if(score > 0){
			gpa = (double)score/n;
		}

		System.out.println(gpa);
	}
}
