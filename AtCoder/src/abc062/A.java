package abc062;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int x[] = new int[2];
		x[0] = sc.nextInt();
		x[1] = sc.nextInt();

		int[][] group = {{1,3,5,7,8,10,12},{4,6,9,11},{2}};

		for(int i = 0; i < 3; i++){
			boolean flag[] = new boolean[2];
			for(int j = 0; j < group[i].length; j++){
				for(int k = 0; k < 2; k++){
					if(x[k] == group[i][j]){
						flag[k] = true;
					}
				}
			}

			if(flag[0] && flag[1]){
				System.out.println("Yes");
				return;
			}
		}

		System.out.println("No");
	}
}