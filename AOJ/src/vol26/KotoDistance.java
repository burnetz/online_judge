package vol26;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KotoDistance {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();

		AP[] aps = new AP[n];
		for(int i = 0; i < n; i++){
			aps[i] = new AP(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		//貪欲法で解くことができる
		//横方向のチェックの場合、事前にカバーできる左端の座標基準でソートすることで
		//順番に確認すれば全範囲覆うことができているかチェックできる。
		//縦か横かいずれかで全範囲覆えていることが確かめられればYes
		Arrays.sort(aps, new Comparator<AP>() {

			@Override
			public int compare(AP o1, AP o2) {
				// TODO 自動生成されたメソッド・スタブ
				return o1.x - o1.w - o2.x + o2.w;
			}
		});

		boolean clear = true;
		int right = 0;
		for(int i = 0; i < n; i++){
			if(aps[i].x - aps[i].w > right){
				clear = false;
				break;
			}

			right = Math.max(right, aps[i].x + aps[i].w);
		}

		if(right < w){
			clear = false;
		}

		if(clear){
			System.out.println("Yes");
			return;
		}

		//ここからはy方向に検証
		Arrays.sort(aps, new Comparator<AP>() {

			@Override
			public int compare(AP o1, AP o2) {
				// TODO 自動生成されたメソッド・スタブ
				return o1.y - o1.w - o2.y + o2.w;
			}
		});

		clear = true;
		int top = 0;
		for(int i = 0; i < n; i++){
			if(aps[i].y - aps[i].w > top){
				clear = false;
				break;
			}

			top = Math.max(top, aps[i].y + aps[i].w);
		}
		if(top < h){
			clear = false;
		}

		if(clear){
			System.out.println("Yes");
			return;
		}
		System.out.println("No");

	}

}

class AP {
	int x;
	int y;
	int w;

	AP (int x, int y, int w){
		this.x = x;
		this.y = y;
		this.w = w;
	}
}