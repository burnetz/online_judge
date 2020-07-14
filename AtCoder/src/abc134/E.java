package abc134;

import java.util.Arrays;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int a[] = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		int colorValue[] = new int[n];
		Arrays.fill(colorValue, Integer.MAX_VALUE);

		colorValue[0] = a[n - 1];
		int tail = 0;

		//右側から左側へと要素を見ていく。
		//それぞれの色の最小値を記憶し、a[i]がどの要素よりも大きければ色を追加、
		//そうでなければa[i]に更新可能な中で一番小さい要素を探す。
		//やっていることは右から左の最長増加列の長さの求め方と同じ
		for(int i = n - 2; i >= 0; i--){

			if(a[i] >= colorValue[tail]){
				tail++;
				colorValue[tail] = a[i];
			}
			else {
				int tmpIndex = Arrays.binarySearch(colorValue, a[i] - 1);
				if(tmpIndex < 0){
					tmpIndex = -tmpIndex - 1;
				}
				for(int j = tmpIndex; j <= tail; j++){
					if(colorValue[j] > a[i]){
						colorValue[j] = a[i];
						break;
					}
				}
			}
		}

		System.out.println(tail + 1);
	}

}
