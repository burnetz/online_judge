package abc170;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();

		for(int i = 0; i <= x; i++){
			if(i * 2 + (x - i)*4 == y){
				System.out.println("Yes");
				return;
			}
		}

		System.out.println("No");
	}

}
