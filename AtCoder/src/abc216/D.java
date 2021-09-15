package abc216;

import java.util.ArrayDeque;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		//筒の中身を記録する。頻繁に末尾削除を行うので多分Dequeが良い。
		@SuppressWarnings("unchecked")
		ArrayDeque<Integer> slots[] = new ArrayDeque[m];

		for(int i = 0; i < m; i++){
			slots[i] = new ArrayDeque<Integer>();
		}

		for(int i = 0; i < m; i++){
			int k = sc.nextInt();

			for(int j = 0; j < k; j++){
				slots[i].add(sc.nextInt() - 1);
			}
		}

		//全n色について、各色が登場した筒の番号を記録する。各色高々2回。
		@SuppressWarnings("unchecked")
		ArrayDeque<Integer> color[] = new ArrayDeque[n];
		for(int i = 0; i < n; i++){
			color[i] = new ArrayDeque<Integer>();
		}

		//取り出し可能な色を記憶するためのキュー
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		for(int i = 0; i < m; i++){
			int lastColor = slots[i].getLast();

			color[lastColor].add(i);

			//同じ色を2回観測したらキューに入れる。
			if(color[lastColor].size() == 2){
				que.add(lastColor);
			}
		}

		int count = 0;
		while(!que.isEmpty()){
			count++;

			int tmpColor = que.remove();

			int index1 = color[tmpColor].getFirst();
			int index2 = color[tmpColor].getLast();

			slots[index1].removeLast();
			slots[index2].removeLast();

			//削除した後も常に新しく見えた球を確認し
			//必要に応じてキューに追加する。
			//これによって同じ色を探すのにO(M)かけずに済むので間に合う。
			if(!slots[index1].isEmpty()){
				int lastColor = slots[index1].getLast();

				color[lastColor].add(index1);

				if(color[lastColor].size() == 2){
					que.add(lastColor);
				}
			}

			if(!slots[index2].isEmpty()){
				int lastColor = slots[index2].getLast();

				color[lastColor].add(index2);

				if(color[lastColor].size() == 2){
					que.add(lastColor);
				}
			}
		}

		if(count == n){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}

}
