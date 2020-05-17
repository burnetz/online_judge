package abc036;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];
		int b[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			b[i] = a[i];
		}

		Arrays.sort(b);

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int rank = 0;
		for(int i = 0; i < n; i++){
			if(!map.containsKey(b[i])){

				map.put(b[i], rank);
				rank++;
			}
		}

		for(int i = 0; i < n; i++){
			System.out.println(map.get(a[i]));
		}

	}
}

