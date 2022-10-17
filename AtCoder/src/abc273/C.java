package abc273;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];
		HashSet<Integer> set = new HashSet<Integer>();
		Vector<Integer> vec = new Vector<Integer>();
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			
			if(!set.contains(a[i])) {
				vec.add(a[i]);
				set.add(a[i]);
			}
		}
		Collections.sort(vec);
		
		int count[] = new int[n + 1];
		for(int i = 0; i < n; i++) {
			int index = Collections.binarySearch(vec, a[i]);
//			System.out.println("a[i] " + a[i] + " index "+index);
			
			count[vec.size() - index - 1]++;
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < n; i++) {
//			System.out.println(count[i]);
			sb.append(count[i] + "\n");
		}
		System.out.print(sb);
	}
}

