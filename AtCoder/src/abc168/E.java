package abc168;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int mod = 1000000007;


		long a[] = new long[n];
		long b[] = new long[n];

		int zeros = 0;
		//内積の問題なので傾きを保持する
		//実数だと精度が怪しいので既約分数を文字列で保存
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++){
			a[i] = sc.nextLong();
			b[i] = sc.nextLong();

			if(a[i] == 0 && b[i] == 0){
				zeros++;
				continue;
			}
			if(a[i] == 0 && b[i] != 0){
				b[i] = 1;
			}
			if(a[i] != 0 && b[i] == 0){
				a[i] = 1;
			}
			if(a[i] != 0 && b[i] != 0){
				long gcd = gcd(a[i], b[i]);
				a[i] /= gcd;
				b[i] /= gcd;
			}
			//簡単のため分子は非負になるよう統一
			if(a[i] < 0){
				a[i] *= -1;
				b[i] *= -1;
			}

			String tmpStr = a[i] + "," +b[i];

			if(!map.containsKey(tmpStr)){
				map.put(tmpStr, 1);
			}
			else {
				map.put(tmpStr, map.get(tmpStr) + 1);
			}
		}

		Iterator<String> it = map.keySet().iterator();

		HashSet<String> used = new HashSet<String>();
		long result = 1;
		while(it.hasNext()){
			String tmpStr = it.next();

			if(used.contains(tmpStr)){
				continue;
			}
			String tmpArray[] = tmpStr.split(",");

			long tmpA = Long.parseLong(tmpArray[0]);
			long tmpB = Long.parseLong(tmpArray[1]);

			//ある傾きと対になる（仲が悪い）傾きを考える
			String counterStr = "";
			if(tmpA == 0 && tmpB == 1){
				counterStr = "1,0";
			}
			else if(tmpA == 1 && tmpB == 0){
				counterStr = "0,1";
			}
			else {
				if(tmpB > 0){
					counterStr = tmpB + "," + (-tmpA);
				}
				else {
					counterStr = -tmpB + "," + tmpA;
				}
			}

			//仲が悪いペアが存在するとき
			if(map.containsKey(counterStr)){
				//AグループとBグループのどちらかを選び好きな数だけ選択する（1を引かないと全く選ばないパターンが重複する）
				result *= (repeatablePow(2, map.get(tmpStr), mod) + repeatablePow(2, map.get(counterStr), mod) + mod - 1)%mod;
			}
			else {
				//仲が悪いペアがないなら好きな数だけ選択すればよい
				result *= repeatablePow(2, map.get(tmpStr), mod)%mod;
			}
			result %= mod;
			used.add(counterStr);
		}

		//(0,0)は他のパターンに混ぜることができない。どの(0,0)を1匹選ぶかが別で加算されるだけ
		result += zeros ;
		//1匹も選ばないのは駄目
		result += mod - 1;
		result %= mod;

		System.out.println(result);
	}

	static long gcd(long a, long b){
        long tmp;

        while (a % b != 0)
        {
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }
	static long repeatablePow(int x, int n, int mod){
		if(n == 0){
			return 1;
		}
		long result = repeatablePow((int)((long)x*x%mod), n/2, mod);
		if(n % 2 == 1){
			result = result*x%mod;
		}
		return result;
	}

}