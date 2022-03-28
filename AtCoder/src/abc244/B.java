package abc244;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str = sc.next();
		
		int dir = 0;
		int dx[] = {1, 0, -1, 0};
		int dy[] = {0, -1, 0, 1};
		
		int x = 0;
		int y = 0;
		for(int i = 0; i < n; i++) {
			char c = str.charAt(i);
			
			if(c == 'S') {
				x += dx[dir];
				y += dy[dir];
			}
			else {
				dir++;
				dir %= 4;
			}
		}
		
		System.out.println(x + " " + y);
	}
}