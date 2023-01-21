package abc206;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		//置換が必要になったときに実際に何の数字にするかは考慮しなくて良い。
		//「xとyを同値とみなす」処理を端から順に行えば良い（順番には依存しない）
		DisjointSet dj = new DisjointSet(200001);
		int count = 0;
		for(int i = 0; i < n/2; i++){
			int num1 = a[i];
			int num2 = a[n - i - 1];

			if(!dj.isSameSet(num1, num2)){
				dj.union(num1, num2);
				count++;
			}
		}

		System.out.println(count);
	}

}

class DisjointSet {
	private int n;
	private int[] p;
	private int[] rank;
	//各グループの要素数を管理する
	private int[] num;
	//グループ数を管理する
	private int numOfGroup;

	public DisjointSet(int n){
		this.n = n;

		p = new int[n + 1];
		rank = new int[n + 1];

		num = new int[n + 1];

		Arrays.fill(num, 1);

		for(int i = 1; i <= n; i++){
			makeSet(i);
		}

		numOfGroup = n;
	}

	private void makeSet(int x){
		p[x] = x;
		rank[x] = 0;
	}

	public void union(int x, int y){
		int p1 = findSet(x), p2 = findSet(y);
		int num1 = num[p1];
		int num2 = num[p2];
		link (findSet(x), findSet(y));

		if(p1 != p2) {
			num[p1] = num[p2] = num1 + num2;
			numOfGroup--;
		}
	}

	public int amountOfOwnGroup(int x) {
		return num[findSet(x)];
	}

	public int numOfGroup() {
		return numOfGroup;
	}
	private int findSet(int x){
		if(x != p[x]){
			p[x] = findSet( p[x]);
		}
		return p[x];
	}

	public boolean isSameSet(int x, int y){
		return findSet(x) == findSet(y);
	}

	private void link(int x, int y){
		if(rank[x] > rank[y]){
			p[y] = x;
		}
		else {
			p[x] = y;
			if(rank[x] == rank[y]){
				rank[y]++;
			}
		}
	}

	//for debug
	public void printPArray() {
		for(int i = 1; i <= n; i++) {
			System.out.print(p[i]+" ");
		}
		System.out.println();
	}
}