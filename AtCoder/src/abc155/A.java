package abc155;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int input[] = new int[3];
		
		input[0] = sc.nextInt();
		input[1] = sc.nextInt();
		input[2] = sc.nextInt();
		
		Arrays.sort(input);
		
		if((input[0] != input[2]) && (input[0] == input[1] || input[1] == input[2])){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}
