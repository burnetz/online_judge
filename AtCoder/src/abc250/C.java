package abc250;

import java.util.HashSet;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String str[] = new String[n];
		int score[] = new int[n];
		
		HashSet<String> set = new HashSet<String>();
		
		for(int i = 0; i < n; i++) {
			str[i] = sc.next();
			score[i] = sc.nextInt();
			
			if(set.contains(str[i])) {
				score[i] = -1;
			}
			else {
				set.add(str[i]);
			}
		}
		
		int max = 0;
		int maxIndex = 0;
		
		for(int i = 0; i < n; i++) {
			if(max < score[i]) {
				max = score[i];
				maxIndex = i + 1;
			}
		}
		
		System.out.println(maxIndex);
	}
}
