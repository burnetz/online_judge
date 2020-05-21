package abc027;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];
		int sum = 0;
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			sum += a[i];
		}

		if(sum % n != 0){
			System.out.println(-1);
			return;
		}

		int perIsl = sum / n;
		int sectionSum = 0;
		int sectionBegin = 0;
		int bridge = 0;
		//左から見ていく。人口の和が島の数*各島の最終的な人数と一致しなければ
		//多くても少なくても右に橋が必要
		for(int i = 0; i < n; i++){
			sectionSum += a[i];

			if(sectionSum == perIsl * (i - sectionBegin + 1)){
				sectionSum = 0;
				sectionBegin = i + 1;
			}
			else {
				bridge++;
			}
		}

		System.out.println(bridge);
	}
}