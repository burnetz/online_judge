package abc122;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();
		String str = sc.next();

		int leftAC[] = new int[n];

		for(int i = n - 2; i >= 0; i--){
			leftAC[i] = leftAC[i + 1];
			if(str.substring(i, i + 2).equals("AC")){
				leftAC[i]++;
			}
		}

		for(int i = 0; i < q; i++){
			int l = sc.nextInt() - 1;
			int r = sc.nextInt() - 1;

			System.out.println(leftAC[l] - leftAC[r]);
		}
	}
}