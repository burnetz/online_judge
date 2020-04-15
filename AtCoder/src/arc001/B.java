package arc001;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		if(a > b){
			int tmp = a;
			a = b;
			b = tmp;
		}

		int count = 0;
		while(b >= a + 10){
			a += 10;
			count++;
		}

		int diff = b - a;

		switch (diff) {
		case 1:
		case 2:
		case 3:
			count += diff;
			break;
		case 4:
			count += 2;
		case 5:
		case 6:
		case 7:
			count += diff - 4;
			break;
		case 8:
			count += 3;
			break;
		case 9:
			count += 2;

		default:
			break;
		}

		System.out.println(count);
	}

}
