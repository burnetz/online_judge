package yahooprocon2019qual;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int connect[] = new int[4];

		for(int i = 0; i < 3; i++){
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;

			connect[a]++;
			connect[b]++;
		}

		for(int i = 0; i <4; i++){
			if(connect[i] == 0 || connect[i] >= 3){
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}
