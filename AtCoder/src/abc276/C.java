package abc276;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		Vector<Integer> vec = new Vector<Integer>();
		vec.add(a[n - 1]);
		
		for(int i = n - 2; i >= 0; i--) {
			vec.add(a[i]);

			if(a[i] < a[i + 1]) {
				continue;
			}
			
			for(int j = 0; j < i; j++) {
				System.out.print(a[j] + " ");
			}
			
			Collections.sort(vec);
			
			for(int j = vec.size() - 1; j >= 0; j--) {
				int tmp = vec.get(j);
				
				if(tmp < a[i]) {
					System.out.print(tmp + " ");
					vec.remove(j);
					break;
				}
			}
			
			for(int j = vec.size() - 1; j >= 0; j--) {
				System.out.print(vec.get(j) + " ");
			}
			System.out.println();
			
			break;
		}
	}
}

