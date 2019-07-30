package vol27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LetsSolveGeometricProblems {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int p = Integer.parseInt(tmpArray[0]);
		int q = Integer.parseInt(tmpArray[1]);

		int g = gcd(p, q);

		q /= g;

		//qを構成する約数を調べる
		int result = 1;

		for(int i = 2; i <= q; i++){
			boolean divided = false;

			while(q % i == 0){
				divided = true;
				q /= i;
			}

			//約数の積を計算する（同じ数字は一度しか掛けない）
			if(divided){
				result *= i;
			}
		}

		System.out.println(result);
	}

	static int gcd(int a, int b){
        int tmp;

        while (a % b != 0)
        {
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }
}
