package abc088;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];
		int alice = 0;
		int bob = 0;

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		Arrays.sort(a);

		for(int i = 0; i < n; i++){
			if(i % 2 == 0){
				alice += a[n - i - 1];
			}
			else {
				bob += a[n - i - 1];
			}
		}

		System.out.println(alice - bob);
	}
}
