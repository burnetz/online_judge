package arc014;

import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		HashSet<String> set = new HashSet<String>();
		String prev = "";
		for(int i = 0 ; i < n; i++){
			String str = sc.next();
			if((i >= 1 && prev.charAt(prev.length() - 1) != str.charAt(0)) || set.contains(str)){
				if(i % 2 == 0){
					System.out.println("LOSE");
				}
				else {
					System.out.println("WIN");
				}

				return;
			}

			prev = str;
			set.add(str);
		}

		System.out.println("DRAW");
	}
}
