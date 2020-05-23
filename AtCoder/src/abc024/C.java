package abc024;

import java.util.Scanner;

public class C {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();

		int l[] = new int[d];
		int r[] = new int[d];

		for(int i = 0; i < d; i++){
			l[i] = sc.nextInt() - 1;
			r[i] = sc.nextInt() - 1;
		}

		int s[] = new int[k];
		int t[] = new int[k];
		for(int i = 0; i < k; i++){
			s[i] = sc.nextInt() - 1;
			t[i] = sc.nextInt() - 1;
		}

		for(int i = 0; i < k; i++){
			//最初に移動ができるのが何日目なのか調べる
			int start = 0;
			for(int j = 0; j < d; j++){
				if(s[i] >= l[j] && s[i] <= r[j]){
					start = j;
					break;
				}
			}

			//区間が同じならどの街でも答えは変わらないので
			//繋がっている区間を次々に併合することを考える
			int currentL = s[i];
			int currentR = s[i];
			for(int j = start; j < d; j++){
				if(!(r[j] < currentL || l[j] > currentR)){
					currentL = Math.min(currentL, l[j]);
					currentR = Math.max(currentR, r[j]);
					if(t[i] >= currentL && t[i] <= currentR){
						System.out.println(j + 1);
						break;
					}
				}
			}
		}
	}
}
