package abc286;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		char[] str = sc.next().toCharArray();
		
		long result = Long.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			//操作Aは必ず最初に済ませると仮定してよい。
			long tmpResult = a * i;
			
			//nが小さいので全パターン試せる。
			for(int j = 0; j < n/2; j++) {
				int indexA = (j + i)%n;
				int indexB = (i- j - 1 + n)%n;
				if(str[indexA] != str[indexB]) {
					tmpResult += b;
				}
			}
			result = Math.min(result, tmpResult);
		}
		
		System.out.println(result);
	}
}

