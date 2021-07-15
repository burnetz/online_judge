package abc207;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long[] l = new long[n];
		long[] r = new long[n];

		for(int i = 0; i < n; i++) {
			int t = sc.nextInt();
			long tmpL = sc.nextLong();
			long tmpR = sc.nextLong();
			tmpL *= 10;
			tmpR *= 10;
			
			switch(t) {
			case 2:
				tmpR--;
				break;
			case 3:
				tmpL++;
				break;
			case 4:
				tmpL++;
				tmpR--;
				break;
			}
			l[i] = tmpL;
			r[i] = tmpR;
		}
		
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if((l[j] >= l[i] && l[j] <= r[i]) ||
						(r[j] >= l[i] && r[j] <= r[i]) ||
						(l[i] >= l[j] && l[i] <= r[j]) ||
						(r[i] >= l[j] && r[i] <= r[j])) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
