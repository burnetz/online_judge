package abc291;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] str = sc.next().toCharArray();

		int x = 0;
		int y = 0;

		HashSet<String> set = new HashSet<String>();
		set.add("0,0");

		for(int i = 0; i < n; i++) {
			switch (str[i]) {
			case 'R': {
				x++;
				break;
			}
			case 'L': {
				x--;
				break;
			}
			case 'U': {
				y--;
				break;
			}
			case 'D': {
				y++;
				break;
			}
			}
			String tmp = x + "," + y;

			if(set.contains(tmp)) {
				System.out.println("Yes");
				return;
			}
			set.add(tmp);
			}
		System.out.println("No");
	}
}