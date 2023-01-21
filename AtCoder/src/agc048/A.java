package agc048;

import java.util.PriorityQueue;
import java.util.Scanner;


public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		char[] atcoder = "atcoder".toCharArray();
		//注　公式の解説によるとこれよりも遥かに簡単にできるらしい
		for(int i = 0; i < t; i++) {
			char[] str = sc.next().toCharArray();
			
			//面倒なので最初から条件を満たしている場合はここで処理
			if(new String(str).compareTo("atcoder") > 0) {
				System.out.println(0);
				continue;
			}
			
			//解の候補を全て保存する
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			int result = 0;
			
			for(int j = 0; j < Math.min(atcoder.length, str.length); j++) {
				boolean available = false;
				int tmpResult1 = 10001;
				int tmpResult2 = 10001;
				for(int k = j ; k < str.length ; k++) {
					int time = k - j;
					//j文字目を明確に大きくできる文字が見つかった場合
					if(atcoder[j] < str[k]) {
						available = true;
						tmpResult1 = time;
						break;
					}
					//j文字目をatcoderと等しくできる文字が見つかった場合
					//ただしスワップの必要がない場合は無視
					if(atcoder[j] == str[k] && str[j] != str[k]) {
						available = true;
						tmpResult2 = Math.min(tmpResult2, time);
					}
				}
				//何の操作もできなかった場合は探索をやめる
				if(!available) {
					if(pq.isEmpty()) {
						result = -1;
						pq.add(result);
					}
					break;
				}
				//明確に大きい文字の前に等しい文字が無かった場合
				//より時間をかける意味がないのでここで打ち切る。
				if(tmpResult1 < tmpResult2) {
					pq.add(result + tmpResult1);
					//ただしスワップをしなくてもj文字目同士が同じならまだチャンスはある
					if(atcoder[j] != str[j]) {
						break;
					}

				}
				//明確に大きい文字の前に等しい文字があった場合
				//こちらの分岐では実際にスワップも行う。
				else {
					for(int k = j + tmpResult2; k > j; k--) {
						char tmp = str[k];
						str[k] = str[k - 1];
						str[k - 1] = tmp;
					}
					
					result += tmpResult2;
					//同じ文字に揃え続けてなおかつまだ文字がある場合は大きいということ
					if(j == atcoder.length - 1 && atcoder.length < str.length) {
						pq.add(result);
					}
				}
			}
			
			System.out.println(pq.peek());
		}
	}
}
