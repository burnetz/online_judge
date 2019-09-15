package abc141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class D {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");
		int n = Integer.parseInt(tmpArray[0]);
		int m = Integer.parseInt(tmpArray[1]);

		tmpArray = br.readLine().split(" ");

		//最も大きい整数が先頭に来るように
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		});

		for(int i = 0; i < n; i++){
			int tmp = Integer.parseInt(tmpArray[i]);
			pq.add(tmp);
		}

		//最もお得な買い方は現状で一番高いものに割引券を使う
		//それを枚数分繰り返す
		for(int i = 0; i < m; i++){
			int tmp = pq.remove();
			tmp /= 2;
			pq.add(tmp);
		}

		long result = 0;
		for(int i = 0; i < n; i++){
			int tmp = pq.remove();
			result += tmp;
		}

		System.out.println(result);

	}

}
