package abc037;

import java.util.PriorityQueue;
import java.util.Scanner;

public class D {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		final int mod = 1_000_000_007;
		int matrix[][] = new int[h][w];

		//移動は全方位とはいえ一方通行なので書かれている数字が小さいマスから順次処理をすればよい
		PriorityQueue<Tile> pq = new PriorityQueue<Tile>();
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				matrix[i][j] = sc.nextInt();
				pq.add(new Tile(j, i, matrix[i][j]));
			}
		}

		long result[][] = new long[h][w];

		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		while(!pq.isEmpty()){
			Tile tile = pq.poll();
			//そのマスから始まったパターンとして1
			result[tile.y][tile.x] = 1;
			//他のマスからの入り方を加算する
			for(int i = 0; i < 4; i++){
				int tmpX = tile.x + dx[i];
				int tmpY = tile.y + dy[i];

				if(tmpX < 0 || tmpX >= w || tmpY < 0 || tmpY >= h){
					continue;
				}

				if(matrix[tmpY][tmpX] < matrix[tile.y][tile.x]){
					result[tile.y][tile.x] += result[tmpY][tmpX];
					result[tile.y][tile.x] %= mod;
				}
			}
		}

		//途中で移動をやめたパターンも考えるので全マスの結果を足す
		long sum = 0;
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				sum += result[i][j];
				sum %= mod;
			}
		}

		System.out.println(sum);
	}
}

class Tile implements Comparable<Tile>{
	int x;
	int y;
	int num;

	Tile(int x, int y, int num){
		this.x = x;
		this.y = y;
		this.num = num;
	}

	@Override
	public int compareTo(Tile t) {
		// TODO 自動生成されたメソッド・スタブ
		return this.num - t.num;
	}


}