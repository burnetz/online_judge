package abc217;

import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		HashSet<String> set = new HashSet<String>();

		for(int i = 0; i < 3; i++){
			set.add(sc.next());
		}

		String[] contests = {"ABC", "ARC", "AGC", "AHC"};

		for(int i = 0; i < 4; i++){
			if(!set.contains(contests[i])){
				System.out.println(contests[i]);
			}
		}
	}
}

