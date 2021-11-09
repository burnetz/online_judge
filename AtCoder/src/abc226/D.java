package abc226;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		//ベクトルを文字列で管理しておくと楽
		HashSet<String> set = new HashSet<String>();
		
		int x[] = new int[n];
		int y[] = new int[n];
		for(int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j) {
					continue;
				}
				
				int dx = x[i] - x[j];
				int dy = y[i] - y[j];
				
				if(dx == 0) {
					set.add("0,1");
					set.add("0,-1");
				}
				else if(dy == 0) {
					set.add("1,0");
					set.add("-1,0");
				}
				else {
					//x成分とy成分を互いに素にするのが最適
					int g = gcd(Math.abs(dx), Math.abs(dy));

					int tmpX = dx/g;
					int tmpY = dy/g;
					
					set.add(tmpX+","+tmpY);
					//任意の往来のためには必ず逆方向も必要
					set.add(-tmpX + "," + (-tmpY));
				}
			}
		}
		
		System.out.println(set.size());
	}
	
	static int gcd(int a, int b){
        int tmp;

        while (a % b != 0)
        {
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }
}