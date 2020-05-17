package abc032;

import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int k = sc.nextInt();

		HashSet<String> set = new HashSet<String>();
		for(int i = 0; i < str.length(); i++){
			if(i + k <= str.length()){
				set.add(str.substring(i, i + k));
			}
		}

		System.out.println(set.size());

	}
}