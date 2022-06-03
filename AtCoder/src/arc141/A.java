package arc141;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			long result = 0;
			String strN = sc.next();
			long n = Long.parseLong(strN);

			//同じ文字列を何回繰り返すかを先に決める。
			for(int j = 2; j <= strN.length() ; j++) {
				int len = strN.length() / j;
				
				long left = 0;
				long right = (long)Math.pow(10, len);
				
				//1から順に試す時間はないので二部探査で最大値を求める。
				while(right > left + 1) {
					long mid = (left + right)/2;
					String tmpStr = "";
					
					for(int l = 0; l < j; l++) {
						tmpStr += mid;
					}
					
					long tmpN = Long.parseLong(tmpStr);
					
					if(tmpN > n) {
						right = mid;
					}
					else {
						left = mid;
					}
				}
				String tmpResult = "";
				for(int k = 0; k < j; k++) {
					tmpResult += left;
				}
				result = Math.max(result, Long.parseLong(tmpResult));
			}
			
			System.out.println(result);
		}
	}
	
}