package arc118;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class C {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		//下記のロジックではn=3のときだけは対応できないので別扱い
		if(n == 3) {
			System.out.println("6 10 15");
			return;
		}
		int base[] = {6,10,15};
		
		//求める答えは6,10,15を必ず含みそれらの倍数も含む集合。
		//10000以下の数で約2600個存在する。
		//ソート可能なデータ構造にしないと6,10,15が出力されない。
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i = 0; i < 3; i++) {
			int j = 1;
			while(base[i]*j <= 10000) {
				set.add(base[i]*j);
				j++;
			}
		}
		
		Iterator<Integer> it = set.iterator();
		
		for(int i = 0; i < n; i++) {
			if(i != 0) {
				System.out.print(" ");
			}
			System.out.print(it.next());
		}
		System.out.println();
	}
	
}