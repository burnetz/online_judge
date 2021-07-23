package abc185;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		//要素n個の配列は多分作れない。
		//青いマスは最大で2*10^5なので青の場所だけを記録する

		//最初と最後は青いことにする
		int a[] = new int[m + 2];

		for(int i = 1; i <= m; i++){
			a[i] = sc.nextInt();
		}
		a[m + 1] = n + 1;

		Arrays.sort(a);

		int width = Integer.MAX_VALUE;

		//はんこの幅を決定
		for(int i = 0; i <= m; i++){
			if(a[i + 1] - a[i] == 1){
				continue;
			}
			width = Math.min(width, a[i + 1] - a[i] - 1);
		}

		if(width == Integer.MAX_VALUE){
			System.out.println(0);
			return;
		}

		int result = 0;

		for(int i = 0; i <= m; i++){
			result += Math.ceil((double)(a[i + 1] - a[i] - 1)/width);
		}

		System.out.println(result);
	}

}
