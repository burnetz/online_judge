package abc258;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char matrix[][] = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			
			for(int j = 0; j < n; j++) {
				matrix[i][j] = str.charAt(j);
			}
		}
		
		int dx[] = {0,1,1,1,0,-1,-1,-1};
		int dy[] = {1,1,0,-1,-1,-1,0,1};
		
		//文字列は比較可能かつ今回は桁数が大きくなるのでStringで管理するのが楽
		Vector<String> vec = new Vector<String>();
		
		//nが小さいので全パターン試せる
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < 8; k++) {
					String tmp = "";
					for(int l = 0; l < n; l++) {
						int x = (j + dx[k]*l + n)%n;
						int y = (i + dy[k]*l + n)%n;
						
						tmp += matrix[y][x];
					}
					
					vec.add(tmp);
				}
			}
		}
		
		Collections.sort(vec);
		
		System.out.println(vec.lastElement());
	}
}