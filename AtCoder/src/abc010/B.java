package abc010;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int result = 0;
		for(int i = 0; i < n; i++){
			int tmp = sc.nextInt();

			switch(tmp){
			case 2:
			case 4:
			case 8:
				result++;
				break;
			case 5:
				result += 2;
				break;
			case 6:
				result += 3;
				break;
			case 1:
			case 3:
			case 7:
			case 9:
			}
		}

		System.out.println(result);
	}
}