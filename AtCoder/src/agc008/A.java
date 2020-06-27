package agc008;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int absX = Math.abs(x);
		int absY = Math.abs(y);

		int result = 0;
		if(y > 0){
			if(absX <= absY){
				result = absY - absX;
				if(x < 0){
					result++;
				}
			}
			else {
				result = absX - absY + 1;
				if(x > 0){
					result++;
				}
			}
		}
		else if(y == 0){
			result = absX - absY;
			if(x > 0){
				result++;
			}
		}
		else {
			if(absX <= absY){
				result = absY - absX + 1;
				if(x < 0){
					result++;
				}
			}
			else {
				result = absX - absY;
				if(x > 0){
					result++;
				}
			}
		}

		System.out.println(result);
	}
}
