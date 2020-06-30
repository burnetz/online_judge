package agc014;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int cost[] = new int[n + 1];

		//1を根と仮定し、1を含むルートなら1からの辺1本だけのコストを1加算、
		//aもbも1でないなら1を経由するという体で1->aと1->bのコストを1ずつ加算
		for(int i = 0; i < m; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();

			if(a == 1){
				cost[b]++;
			}
			else if(b == 1){
				cost[a]++;
			}
			else {
				cost[a]++;
				cost[b]++;
			}
		}

		//1を根としてコストに矛盾が生じるなら他の節を根にしても結論は同じ
		for(int i = 0; i <= n; i++){
			if(cost[i] % 2 == 1){
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
