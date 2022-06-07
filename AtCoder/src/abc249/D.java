package abc249;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//各数字の登場回数
		int count[] = new int[200001];
		
		for(int i = 0; i < n; i++) {
			count[sc.nextInt()]++;
		}
		
		long result = 0;
		
		//数値の上限が2*10^5なので約数のチェックは一応可能
		//ただし平方まででやめること。
		for(int i = 1; i <= 200000; i++) {
			if(count[i] == 0) {
				continue;
			}
			for(int j = 1; j <= Math.sqrt(i); j++) {
				if(count[j] != 0 && i%j == 0 && count[i/j] != 0) {
					if(i == 1) {
						result += (long)count[1]*count[1]*count[1];
					}
					//AiとAkが交換可能なパターンなので2倍する
					else if(j == 1) {
						result += (long)count[1]*count[i]*count[i]*2;
					}
					else if(j == i/j) {
						result += (long)count[i]*count[j]*count[j];
					}
					//AjとAkが交換可能なパターンなので2倍する
					else {
						result += (long)count[i]*count[j]*count[i/j]*2;
					}
				}
			}
		}
		
		System.out.println(result);
	}
}