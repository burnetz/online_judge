package abc254;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long square[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			square[i] = (long)(i + 1)*(i + 1);
		}
		
		Vector<Integer> primes = new Vector<Integer>();
		
		long result = 0;
		//iとjをそれぞれ平方数である最大の約数で割ったものをa,bとする。
		//i*jが平方数になるためには(i/a)*(j/b)が平方数となる必要がある。
		//また、i/aには同じ素数が2回以上含まれず（aの定義に違反する）j/bも同様なので
		//i/a=j/bとなることがi*jが平方数である条件。
		//なので全てのi/aを計算してその分布を記録する。
		long count[] = new long[n + 1];
		
		for(int i = 1; i <= n; i++) {
			int maxSq = 1;
			for(int j = 2; j*j <= i; j++) {
				if(i % (j*j) == 0) {
					maxSq = j*j;
				}
			}
			count[i/maxSq]++;
		}
		
		//同じi/aから重複を許して2回選ぶ。
		for(int i = 1; i <= n; i++) {
			result += count[i]*count[i];
		}
		
		System.out.println(result);
	}
	
}

