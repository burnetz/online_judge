package abc089;

import java.io.IOException;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for(int i = 0; i < n; i++){
			if(sc.next().equals("Y")){
				System.out.println("Four");
				return;
			}
		}

		System.out.println("Three");
	}
}
