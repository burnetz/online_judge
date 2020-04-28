package abc124;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int h[] = new int[n];

		for(int i = 0; i < n; i++){
			h[i] = sc.nextInt();
		}

		int count = 1;
		int maxH = h[0];
		for(int i = 1; i < n; i++){
			if(h[i] >= maxH){
				count++;
				maxH = h[i];
			}
		}

		System.out.println(count);
	}

}
