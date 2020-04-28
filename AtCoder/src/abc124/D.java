package abc124;

import java.util.Scanner;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		char s[] = sc.next().toCharArray();

		char target[] = {'1', '0'};
		int targetIndex = 0;
		Vector<Integer> vec = new Vector<Integer>();
		int count = 0;

		//1の塊と0の塊は交互に発生するのでそれぞれの長さをカウントしておく
		//今回は必ず1から始まるものとする（1の塊の長さ0からスタートもありえる）
		for(int i = 0; i < n; i++){

			if(s[i] != target[targetIndex]){
				targetIndex++;
				targetIndex %= 2;
				vec.add(count);
				count = 0;
			}

			count++;

			if(i == n - 1){
				vec.add(count);
				break;
			}
		}


		//K回ひっくり返せるということは1010...1の長さが2K+1になるということ
		//（左からひっくり返してもまとめてひっくり返しても正しい範囲なら結果は同じ）
		//まずは一番左から合計を求める
		int sum = 0;
		for(int i = 0; i < Math.min(vec.size(), 2*k + 1); i++){
			sum += vec.get(i);
		}

		//これ以降はしゃくとり法で考える
		//最終的な長さは必ず1から始まる区間で計算するので1個飛ばしでしゃくとり法
		int tmpSum = sum;
		for(int i = 2; i < vec.size(); i += 2){
			tmpSum -= (vec.get(i - 1) + vec.get(i - 2));
			if(i + 2*k - 1 < vec.size()){
				tmpSum += vec.get(i + 2*k - 1 );
			}
			if(i + 2*k  < vec.size()){
				tmpSum += vec.get(i + 2*k  );
			}

			sum = Math.max(sum, tmpSum);
		}

		System.out.println(sum);
	}

}