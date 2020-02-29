package abc143;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int l[] = new int[n];
		for(int i = 0; i < n; i++){
			l[i] = sc.nextInt();
		}

		Arrays.sort(l);
		int result = 0;

		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				//本当はバイナリサーチを使ったほうが良いと思うが一応これでも間に合う
				for(int k = j + 1; k < n; k++){
					//ソート済みなのでここでbreak可
					if(l[k] >= l[i] + l[j]){
						break;
					}
					if(l[j] < l[i] + l[k] && l[k] < l[i] + l[j]){
						result++;
					}
				}
			}
		}

		System.out.println(result);
	}

}
