package abc028;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a[] = new int[5];

		for(int i = 0; i < 5; i++){
			a[i] = sc.nextInt();
		}

		int result[] = new int[10];
		int index = 0;
		for(int i = 0; i < 5; i++){
			for(int j = i + 1; j < 5; j++){
				for(int k = j + 1; k < 5; k++){
					result[index] = a[i] + a[j] + a[k];
					index++;
				}
			}
		}

		Arrays.sort(result);

		System.out.println(result[7]);
	}

}

