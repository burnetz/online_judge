package abc212;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int pass[] = new int[4];
		String str = sc.next();

		for(int i = 0; i < 4; i++){
			pass[i] = str.charAt(i) - '0';
		}

		if(pass[0] == pass[1] && pass[1] == pass[2] && pass[2] == pass[3]){
			System.out.println("Weak");
			return;
		}

		int count = 0;
		for(int i = 0; i < 3; i++){
			if(pass[i + 1] == (pass[i] + 1)%10 ){
				count++;
			}
		}

		if(count < 3){
			System.out.println("Strong");
		}
		else{
			System.out.println("Weak");
		}
	}
}
