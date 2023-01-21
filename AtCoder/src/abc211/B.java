package abc211;

import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		HashSet<String> set = new HashSet<String>();

		while(sc.hasNext()){
			set.add(sc.next());
		}

		if(set.contains("H") && set.contains("2B") && set.contains("3B") && set.contains("HR")){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}
}
