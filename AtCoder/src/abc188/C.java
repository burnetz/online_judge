package abc188;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[(int)Math.pow(2, n)];
		int b[] = new int[a.length];

		for(int i = 0; i < a.length; i++){
			a[i] = sc.nextInt();
			b[i] = i;
		}

		for(int i = n; i >= 2; i--){
			int c[] = new int[b.length / 2];

			for(int j = 0; j < b.length; j += 2){
				if(a[b[j]] > a[b[j + 1]]){
					c[j / 2] = b[j];
				}
				else {
					c[j / 2] = b[j + 1];
				}
			}

			b = c;

		}

		if(a[b[0]] < a[b[1]]){
			System.out.println(b[0] + 1);
		}
		else {
			System.out.println(b[1] + 1);
		}
	}

}
