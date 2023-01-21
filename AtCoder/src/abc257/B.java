package abc257;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int q = sc.nextInt();
		
		int pos[] = new int[k];
		
		for(int i = 0; i < k; i++) {
			pos[i] = sc.nextInt();
		}
		
		for(int i = 0; i < q; i++) {
			int l = sc.nextInt() - 1;
			
			if(pos[l] == n) {
				continue;
			}
			else if(l < k - 1 && pos[l] + 1 == pos[l + 1]) {
				continue;
			}
			else {
				pos[l]++;
			}
		}
		
		for(int i = 0; i < k; i++) {
			System.out.print(pos[i] + " " );
		}
	}
}