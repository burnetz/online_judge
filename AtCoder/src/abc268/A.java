package abc268;

import java.util.HashSet;
import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < 5; i++) {
			set.add(sc.nextInt());
		}
		
		System.out.println(set.size());
	}
}