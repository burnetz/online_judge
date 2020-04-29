package abc121;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int c = sc.nextInt();

		int b[] = new int[m];

		for(int i = 0; i < m; i++){
			b[i] = sc.nextInt();
		}

		int count = 0;
		for(int i = 0; i < n; i++){
			int tmp = c;
			for(int j = 0; j < m; j++){
				int a = sc.nextInt();

				tmp += a*b[j];
			}

			if(tmp > 0){
				count++;
			}
		}

		System.out.println(count);

	}

}
