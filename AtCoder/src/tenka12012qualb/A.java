package tenka12012qualb;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

//		int count = 0;
		for(int i = 1; i <= 127; i++){
			if(i%3 == a && i%5 == b && i%7 == c){
				System.out.println(i);
//				count++;
			}
		}
//		if(count == 0){
//			System.out.println();
//		}

	}

}
