package abc217;

import java.util.Scanner;
import java.util.TreeSet;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt();
		int q = sc.nextInt();

		//順序付きセットを使えば値の挿入もある値の近傍の探索もO(logN)でできる
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(0);
		set.add(l);
		for(int i = 0; i < q; i++){
			int mode = sc.nextInt();
			int x = sc.nextInt();


			if(mode == 1){
				set.add(x);
			}
			else{
				//切れ目とは被らないことが保証されているので
				//xそのものがヒットする危険は考えなくて良い
				int left = set.floor(x);
				int right = set.ceiling(x);

				System.out.println(right - left);
			}
		}

	}

}
