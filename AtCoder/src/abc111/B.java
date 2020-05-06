package abc111;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for(int i = 1; i <= 9; i++){
			if(n <= 111*i){
				System.out.println(111*i);
				return;
			}
		}
	}

}
