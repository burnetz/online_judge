package abc028;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int count[] = new int[6];
		for(int i = 0; i < str.length(); i++){
			count[str.charAt(i) - 'A']++;
		}

		for(int i = 0; i < 6; i++){
			System.out.print(count[i]);

			if(i != 5){
				System.out.print(" ");
			}
			else{
				System.out.println();
			}
		}
	}
}