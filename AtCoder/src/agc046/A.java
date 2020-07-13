package agc046;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();

		int i = 1;
		while(true){
			if(x*i%360 == 0){
				System.out.println(i);
				return;
			}
			i++;
		}
	}
}
