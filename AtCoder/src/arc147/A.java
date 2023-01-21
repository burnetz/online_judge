package arc147;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		
		for(int i = 0; i < n; i++) {
			que.add(a[i]);
		}
		
		int count = 0;
		
		while(que.size() > 1) {
			int first = que.getFirst();
			int last = que.removeLast();
			
			if(last%first != 0) {
				que.addFirst(last%first);
			}
			
			count++;
		}
		
		System.out.println(count);
	}

}