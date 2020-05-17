package abc035;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();

		int x = 0;
		int y = 0;
		int unknown = 0;

		for(int i = 0; i < s.length(); i++){
			switch(s.charAt(i)){
			case 'L':
				x++;
				break;
			case 'R':
				x--;
				break;
			case 'U':
				y++;
				break;
			case 'D':
				y--;
				break;
			default :
				unknown++;
			}
		}

		int t = sc.nextInt();
		if(t == 1){
			System.out.println(Math.abs(x) + Math.abs(y) + unknown);
		}
		else {
			int remain = unknown - Math.abs(x) - Math.abs(y);

			if(remain <= 0){
				System.out.println(Math.abs(x) + Math.abs(y) - unknown);
			}
			else {
				System.out.println(remain % 2);
			}
		}
	}
}