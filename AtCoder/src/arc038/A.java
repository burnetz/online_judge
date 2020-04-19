package arc038;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int input[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		
		Arrays.sort(input);
		
		int result[] = new int[2];
		//相手の妨害とかを考えないなら単純に大きい順に選んでいくのが最適
		for(int i = n - 1; i >= 0; i--) {
			result[(n - 1 - i) % 2] += input[i];
		}
		
		System.out.println(result[0]);
	}		
}