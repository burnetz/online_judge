package vol13;

import java.math.BigInteger;
import java.util.Scanner;

public class SecretOfChocolatePoles {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int l = scan.nextInt();
		int k = scan.nextInt();

		long result = 0;
		//厚いチョコの枚数を事前に決めておく
		//あとはパターン数はコンビネーションで計算できる
		for(int thick = 0; thick <= 50; thick++){
			if(thick*k > l){
				break;
			}

			for(int thin = 0; thin <= 50; thin++){
				int height = thick*k + thin + (thick + thin - 1);

				if(height <= 0){
					continue;
				}
				if(height > l){
					break;
				}

				result += combination(thick + thin, thick);
			}
		}

		System.out.println(result);
	}

	//愚直な方法でコンビネーションを求める
	//BigIntegerも使ってしまったが今回は十分間に合う
	static long combination(int n, int m){
		BigInteger result = new BigInteger("1");

		for(int i = 0; i < m; i++){
			result = result.multiply(BigInteger.valueOf(n - i));
		}

		for(int i = 1; i <= m ; i++){
			result = result.divide(BigInteger.valueOf(i));
		}

		return result.longValue();
	}

}
