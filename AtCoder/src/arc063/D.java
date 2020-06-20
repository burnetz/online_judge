package arc063;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		//売買のいずれも複数の街に分散する意味がないので個数は実は関係ない
		int t = sc.nextInt();

		int a[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		//もともとの価格での最高効率はある1つの安い街で全部仕入れてそれより後の最も高い街で全部売ること
		//それを調べるためにループが必要
		int min = a[0];
		int maxBenefit = 0;
		for(int i = 1; i < n; i++){
			min = Math.min(min, a[i]);
			maxBenefit = Math.max(maxBenefit, a[i] - min);
		}

		int minNum = 1;
		int maxNum = 0;
		min = a[0];
		int result = 0;
		//最小値が更新されるまでを1区間として考える
		for(int i = 1; i < n; i++){
			if(a[i] == min){
				minNum++;
			}
			if(a[i] == min + maxBenefit){
				maxNum++;
			}

			//区間が変わる場合でかつ最大効率が狙えたのであれば
			//仕入れ値と売値のうち出現回数が少ない方を1円ずつ変えれば利益が減る
			//なお、次の区間への影響は発生しない（それで影響があるならそもそもこの区間で最高効率を狙えていない）
			if(a[i] < min || i == n - 1){
				min = a[i];

				result += Math.min(minNum, maxNum);

				minNum = 1;
				maxNum = 0;
			}
		}

		System.out.println(result);
	}

}
