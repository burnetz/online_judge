package abc217;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();

		if(a.compareTo(b) < 0){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}

}
