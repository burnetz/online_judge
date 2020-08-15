package abc174;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		//偶数はありえない。5の倍数も絶対に下1桁が7にならないのでありえない。
		if(k % 2 == 0 || k % 2 == 5){
			System.out.println(-1);
			return;
		}

		int result = 1;
		int sevens = 7;
		while(true){
			if(sevens % k == 0){
				System.out.println(result);
				return;
			}

			//7を1桁増やす作業だが、どのみち全部の桁は保存できないのでmodだけ管理
			sevens *= 10;
			sevens += 7;
			sevens %= k;

			result++;

			//桁数がkより大きくなってしまったならループに入っているので放棄
			if(result > k){
				System.out.println(-1);
				return;
			}
		}
	}
}