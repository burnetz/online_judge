package arc133;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		
		int top = n - 1;
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n - 1; i++) {
			if(a[i + 1] < a[i]) {
				top = i;
				break;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < n; i++) {
			if(a[i] != a[top]) {
				sb.append(a[i]);
				sb.append(" ");
			}
		}
		
		System.out.println(sb);
	}
}