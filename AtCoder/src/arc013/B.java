package arc013;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int c = sc.nextInt();

		int minN = 0;
		int minM = 0;
		int minL = 0;

		for(int i = 0 ; i < c; i++){
			int size[] = new int[3];

			for(int j = 0; j < 3; j++){
				size[j] = sc.nextInt();
			}

			Arrays.sort(size);

			minN = Math.max(minN, size[0]);
			minM = Math.max(minM, size[1]);
			minL = Math.max(minL, size[2]);
		}

		System.out.println(minN*minM*minL);
	}
}
