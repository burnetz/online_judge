package abc235;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int n = sc.nextInt();
		//桁数が大きくなりすぎた場合に小さくする方法が無いので限度がある
		int limit = 10_000_001;
		
		//自明なパターン
		if(a == n) {
			System.out.println(1);
			return;
		}
		
		//途中に出てくる数字の候補は多くないので
		//BFSで最短の手数を求める
		boolean visited[] = new boolean[limit];
		ArrayDeque<Node> que = new ArrayDeque<>();
		visited[1] = true;
		que.add(new Node(1, 0));
		
		while(!que.isEmpty()) {
			Node tmp = que.remove();
			if(tmp.num == n){
				System.out.println(tmp.dist);
				return;
			}
			
			//a倍
			long t = tmp.num*a;
			if(t <= limit && !visited[(int)t]) {
				visited[(int)t] = true;
				que.add(new Node((int)t, tmp.dist + 1));
			}
			
			//数字を1つずらす
			if(tmp.num >= 10 && tmp.num%10 != 0) {
				String str = Integer.toString((int)tmp.num);
				int t2 = Integer.parseInt(str.charAt(str.length() - 1) + str.substring(0, str.length() - 1));
				if(t2 <= limit && !visited[t2]) {
					que.add(new Node(t2, tmp.dist + 1));
				}
			}
		}
		System.out.println(-1);
	}
}

class Node {
	long num;
	int dist;
	
	Node (int num, int dist){
		this.num = num;
		this.dist = dist;
	}
}