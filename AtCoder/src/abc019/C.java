package abc019;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class C {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);

		HashSet<Integer> set = new HashSet<Integer>();
		int count = 0;
		for(int i = 0; i < n; i++){
			if(!set.contains(a[i])){
				long tmp = a[i];
				while(tmp <= 1_000_000_000){
					set.add((int)tmp);
					tmp *= 2;
				}

				count++;
			}
		}

		System.out.println(count);
	}

}