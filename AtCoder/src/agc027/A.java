package agc027;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();

		int a[] = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		Arrays.sort(a);

		int count = 0;

		//要求数が少ない順に配るのが最善
		//最後の一人はちょうどでなければいけないので条件が厳しいが、
		//他の順番で同じことをやれば喜ぶ子供がもっと減る
		for(int i = 0; i < n; i++){
			if(x >= a[i] && i != n - 1){
				count++;
				x -= a[i];
			}
			//最後の一人はちょうどでないと喜ばない
			else if(i == n - 1 && a[i] == x){
				count++;
			}
			else {
				break;
			}
		}

		System.out.println(count);
	}
}
