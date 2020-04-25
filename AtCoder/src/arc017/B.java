package arc017;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int a[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		if(k == 1){
			System.out.println(n);
			return;
		}

		int count = 0;
		int seq = 1;
		for(int i = 1; i < n; i++){
			if(a[i] > a[i - 1]){
				seq++;
			}
			else {
				seq = 1;
			}

			if(seq >= k){
				count++;
			}
		}

		System.out.println(count);
	}
}
