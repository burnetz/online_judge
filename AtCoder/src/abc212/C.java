package abc212;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int a[] = new int[n];
		int b[] = new int[m];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		for(int i = 0; i < m; i++){
			b[i] = sc.nextInt();
		}

		Arrays.sort(a);
		Arrays.sort(b);

		int result = Integer.MAX_VALUE;
		int index = 0;
		for(int i = 0; i < n; i++){
			while(index < m){
				result = Math.min(result, Math.abs(a[i] - b[index]));

				if(a[i] < b[index]){
					break;
				}
				else{
					index++;
				}
			}
		}

		System.out.println(result);
	}
}
