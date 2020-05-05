package abc115;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int h[] = new int[n];

		for(int i = 0; i < n; i++){
			h[i] = sc.nextInt();
		}

		Arrays.sort(h);
		int minDiff = Integer.MAX_VALUE;

		for(int i = 0; i + k - 1 < n; i++){
			minDiff = Math.min(minDiff, h[i + k - 1] - h[i]);
		}
		System.out.println(minDiff);
	}
}
