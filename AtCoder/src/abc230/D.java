package abc230;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int d = sc.nextInt();
		
		Wall walls[] = new Wall[n];
		
		for(int i = 0 ; i < n; i++) {
			walls[i] = new Wall(sc.nextInt(), sc.nextInt());
		}
		
		//右端の座標について昇順に並べる
		Arrays.sort(walls);
		
		int count = 0;

		//貪欲法でO(N)で解くことができる。
		//右端の座標について昇順に並べ、右端でパンチして他の壁を巻き込むのが最適。
		//左端の座標でソートすると例えば長い壁が短い壁を含むパターンでうまくいかない。
		for(int i = 0; i < n; i++) {
			count++;
			for(int j = i + 1; j < n; j++) {
				if(walls[j].left > walls[i].right + d - 1) {
					i = j - 1;
					break;
				}
				//巻き込みでフィニッシュしたときのための分岐
				if(j == n - 1) {
					i = n;
					break;
				}
			}
		}
		
		System.out.println(count);
	}

}

class Wall implements Comparable<Wall> {
	int left;
	int right;
	
	Wall(int left, int right){
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(Wall w) {
		return this.right - w.right;
	}
}