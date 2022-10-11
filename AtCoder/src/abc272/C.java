package abc272;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Vector<Integer> odd = new Vector<Integer>();
		Vector<Integer> even = new Vector<Integer>();
		
		for(int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			
			if(tmp%2 == 1) {
				odd.add(tmp);
			}
			else {
				even.add(tmp);
			}
		}
		
		int result = -1;
		
		Collections.sort(odd);
		Collections.sort(even);
		
		if(odd.size() >= 2) {
			result = Math.max(result, odd.get(odd.size() - 1) + odd.get(odd.size() - 2));
		}
		if(even.size() >= 2) {
			result = Math.max(result, even.get(even.size() - 1) + even.get(even.size() - 2));
		}
		
		System.out.println(result);
	}
}

