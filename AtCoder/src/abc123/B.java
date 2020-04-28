package abc123;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a[] = new int[5];
		int roughTotal = 0;
		int maxBlank = 0;
		for(int i = 0; i < 5; i++){
			a[i] = sc.nextInt();

			roughTotal += (a[i] + 9)/10*10;
			if(a[i]%10 != 0){
				maxBlank = Math.max(maxBlank, 10 - a[i]%10);
			}
		}

		System.out.println(roughTotal - maxBlank);
	}

}
