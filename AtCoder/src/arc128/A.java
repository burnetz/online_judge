package arc128;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		int method[] = new int[n];
		
		int count = 0;
		boolean hasGold = true;
		for(int i = 0; i < n ; i++) {
			//ラストは次の要素がないので別扱い。
			//もし銀をもっていてレートが良ければ交換
			//レートが悪くて交換できない場合の処理は後で行う
			if(i == n - 1) {
				if(!hasGold && a[i - 1] >= a[i]) {
					hasGold = true;
					method[i] = 1;
					count++;
				}
			}
			//基本的にはレートの増減が変わる瞬間に金銀を手放すのが最適
			else {
				if(hasGold) {
					if(a[i] > a[i + 1]) {
						hasGold = false;
						method[i] = 1;
						count++;
					}
				}
				else {
					if(a[i] < a[i + 1]) {
						hasGold = true;
						method[i] = 1;
						count++;
					}
				}
			}
		}
		
		//交換の回数が奇数だと最後に持っているのが銀になってしまうので
		//最後の交換を無かったことにする。
		if(count % 2 == 1) {
			for(int i = n - 1; i >= 0; i--) {
				if(method[i] == 1) {
					method[i] = 0;
					break;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			if(i != 0) {
				System.out.print(" ");
			}
			System.out.print(method[i]);
		}
		System.out.println();
	}
}