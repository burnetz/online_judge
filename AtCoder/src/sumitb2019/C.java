package sumitb2019;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();

		if(x <= 99){
			System.out.println(0);
			return;
		}

		boolean a[] = new boolean[100001];
		a[100] = a[101] = a[102] = a[103] = a[104] = a[105] = true;

		for(int i = 106; i <= x; i++){
			for(int j = 0; j <= 5; j++){
				if(a[i - (100 + j)]){
					a[i] = true;
				}
			}
		}

		System.out.println(a[x] ? 1 : 0);
	}

}
