package abc130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmpArray = br.readLine().split(" ");
		
		int n = Integer.parseInt(tmpArray[0]);
		long k = Long.parseLong(tmpArray[1]);
		
		int[] input = new int[n];
		tmpArray = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(tmpArray[i]);
		}
		
		long sum = input[0];
		long count = 0;

		//総和がぎりぎりk以上になる部分列をしゃくとり法で探す
		int l = 0;
		int r = 1;
		
		while(l < n) {
			if(r < n && sum < k) {
				sum += input[r];
				r++;
			}
			else {
				//(l,r)でk以上になるなら次以降の要素を含めても当然条件を満たす
				if(sum >= k) {
					count += n - r + 1;
				}
				sum -= input[l];
				l++;
			}
		}
		
		System.out.println(count);
	}

}
