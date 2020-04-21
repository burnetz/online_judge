package arc033;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int na = sc.nextInt();
		int nb = sc.nextInt();

		int array[] = new int[na + nb];

		for(int i = 0; i < na + nb; i++){
			array[i] = sc.nextInt();
		}

		Arrays.sort(array);

		int totalA = 0;
		int totalB = 1;
		for(int i = 1; i < na + nb; i++){
			//同じ数字は高々2回しか出てこないのでこの方法で良い
			if(array[i - 1] == array[i]){
				totalA++;
			}
			else {
				totalB++;
			}
		}
		System.out.println((double)totalA/totalB);
	}
}
