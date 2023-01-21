package abc195;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int q = sc.nextInt();

		Item[] items = new Item[n];

		for(int i = 0; i < n; i++){
			items[i] = new Item(sc.nextInt(), sc.nextInt());
		}

		int box[] = new int[m];
		for(int i = 0; i < m; i++){
			box[i] = sc.nextInt();
		}

		for(int i = 0; i < q; i++){
			int l = sc.nextInt() - 1;
			int r = sc.nextInt() - 1;

			int avail = m - (r - l + 1);

			if(avail == 0){
				System.out.println(0);
				continue;
			}

			int availBox[] = new int[avail];

			int tmpIndex = 0;
			for(int j = 0; j < m; j++){
				if(j < l || j > r){
					availBox[tmpIndex] = box[j];
					tmpIndex++;
				}
			}
			Arrays.sort(availBox);

			long result = 0;
			boolean used[] = new boolean[n];

			//容量の小さな箱から調べ、重量がオーバーしない範囲で価値があるものを選び続けるのが最適。
			//（普通のナップサック問題とは違いこの方法で最適になる）
			//そのためのループが2重でもO(NMQ)なので十分間に合う。
			for(int j = 0; j < avail; j++){
				int maxIndex = -1;
				for(int k = 0; k < n; k++){
					if(used[k] || items[k].weight > availBox[j]){
						continue;
					}
					if(maxIndex < 0 || items[k].value > items[maxIndex].value ){
						maxIndex = k;
					}
				}

				if(maxIndex >= 0){
					used[maxIndex] = true;
					result += items[maxIndex].value;
				}
			}

			System.out.println(result);
		}
	}

}

class Item {
	int value;
	int weight;

	Item(int weight, int value){
		this.value = value;
		this.weight = weight;
	}
}