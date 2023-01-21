package abc255;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		long a[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		
		Arrays.sort(a);
		
		long sum[] = new long[n];
		
		sum[0] = a[0];
		
		for(int i = 1; i < n; i++) {
			sum[i] = a[i] + sum[i - 1];
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < q; i++) {
			long x = sc.nextInt();
			
			//事前にソートしてあるのでx以下の区間とx以上の区間に分けることができる。
			//区間ごとの和もsum[]を使ってO(1)で出せる
			int index = Arrays.binarySearch(a, x);
			
			long result = 0;
			
			//xが配列内にある場合
			if(index >= 0) {
				int lessLen = index + 1;
				int moreLen = n - index - 1;
				
				result += x*lessLen - sum[index];
				result += sum[n - 1] - sum[index] - x*moreLen;
			}
			//xが配列内にない場合
			else {
				index++;
				index *= -1;
				
				int lessLen = index;
				int moreLen = n - index;
				
				result += x*lessLen;
				result += sum[n - 1] - x*moreLen;
				if(index > 0) {
					result -= 2*sum[index - 1];
				}
				
			}
			
			sb.append(result + "\n");
		}
		
		System.out.print(sb);
	}
}