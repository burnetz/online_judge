package abc116;

import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();

		HashSet<Integer> set = new HashSet<Integer>();

		set.add(s);
		int i = 2;

		while(true){
			if(s % 2 == 0){
				s /= 2;
			}
			else {
				s = s*3 + 1;
			}

			if(set.contains(s)){
				System.out.println(i);
				return;
			}

			set.add(s);
			i++;
		}

	}

}
