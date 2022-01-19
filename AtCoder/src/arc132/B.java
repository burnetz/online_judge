package arc132;

import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		//1がどこにあったかを記録しておく
		int index1 = -1;
		for(int i = 0; i < n; i++) {
			if(a[i] == 1) {
				index1 = i;
			}
		}
		
		//問題にある操作で1,2,...,nにできるのは
		//k+1,...n,1,2,...k か k,k-1,....1,n,n-1,...k+1のいずれかに分類できるときだけ。
		
		//単に1から増えているだけなので何もしない
		if(a[0] == 1 && a[1] == 2) {
			System.out.println(0);
			return;
		}
		
		//逆にすれば良いだけ
		if(a[n - 1] == 1 && a[n - 2] == 2) {
			System.out.println(1);
			return;
		}	
		
		//前半が昇順かどうか
		boolean ascFirst = true;
		
		if(index1 == 0 || a[index1 - 1] == 2) {
			ascFirst = false;
		}
		
		int result = 0;
		
		//いずれの分岐でも前半と後半（昇順、降順が切り替わる場所で区切る）の数を把握する必要がある。
		if(ascFirst) {
			int left = index1;
			int right = n - index1;
			
			//左側を全部右に送るか、リバース->もともと右側の要素を全部右に送る->リバース
			result = Math.min(left, right + 2);
		}
		else {
			int left = index1 + 1;
			int right = n - left;
			
			//左側を全部右に送ってリバースするか、リバースしてからもともと右側の要素を全部右に送る
			result = Math.min(left + 1, right + 1);
		}
		
		System.out.println(result);
	}
}