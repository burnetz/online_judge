package codefes2015qualb;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int a[] = new int[n];
		int count[] = new int[m + 1];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			count[a[i]]++;
		}

		int result = -1;
		for(int i = 0; i <= m; i++){
			if(count[i] > n/2){
				if(result >= 0){
					System.out.println("?");
					return;
				}
				else{
					result = i;
				}
			}
		}

		System.out.println(result >= 0 ? result : "?");
	}

}
