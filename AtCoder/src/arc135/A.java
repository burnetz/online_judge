package arc135;

import java.util.HashMap;
import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long x = sc.nextLong();
		
		System.out.println(calc(x));
	}
	
	static HashMap<Long, Long> map = new HashMap<Long, Long>();
	static int mod = 998244353;
	
	//メモ化しておけばDFSで十分間に合う
	static long calc(long x) {
		if(map.containsKey(x)) {
			return map.get(x);
		}
		//x<=4であれば割らないでそのまま返した方が大きい。
		//この判定を後半の処理でやろうとすると途中でmodを取る都合上うまくいかない。
		if(x <= 4) {
			map.put(x, x);
			return x;
		}
		
		long result = 1;
		result = calc(x/2) * calc((x + 1)/2);
		result %= mod;
		map.put(x, result);
		return result;
	}
}