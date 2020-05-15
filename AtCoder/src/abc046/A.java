package abc046;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int a[] = new int[3];
		a[0] = sc.nextInt();
		a[1] = sc.nextInt();
		a[2] = sc.nextInt();

		Arrays.sort(a);

		int result = 1;
		if(a[0] != a[1]){
			result++;
		}
		if(a[1] != a[2]){
			result++;
		}

		System.out.println(result);
	}
}