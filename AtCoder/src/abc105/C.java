package abc105;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if(n == 0){
			System.out.println(0);
			return;
		}

		String result = "";


		int count = 0;

		//mod 2 の偶奇で1or0を判断すればよいこと自体は普通の2進数と同じ
		//ただし-2のべき乗となる桁のときは減算でなく加算する必要がある
		while(n != 0){
			if(n % 2 != 0){
				result = "1" + result;

				if(count %2 == 0){
					n--;
				}
				else {
					n++;
				}
			}
			else {
				result = "0" + result;
			}

			count++;
			n /= 2;
		}

		System.out.println(result);
	}

}
