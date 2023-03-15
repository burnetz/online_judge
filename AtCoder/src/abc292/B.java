package abc292;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		int q = sc.nextInt();
		int a[] = new int[n];
		
		for(int i = 0; i < q; i++) {
			int query = sc.nextInt();
			int target = sc.nextInt() - 1;
			
			switch(query) {
			case 1:
				a[target]++;
				break;
			case 2:
				a[target] += 2;
				break;
			default:
				System.out.println(a[target] >= 2 ? "Yes" : "No");
			}
		}
	}
}
