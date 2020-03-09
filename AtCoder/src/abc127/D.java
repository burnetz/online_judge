package abc127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int cards[] = new int[n];
		for(int i = 0; i < n; i++){
			cards[i] = sc.nextInt();
		}

		Arrays.sort(cards);

		ArrayList<Numbers> list = new ArrayList<Numbers>();
		//もともとのカードにそれぞれの数字が何回出てきたかを記録しておく
		int count = 0;
		for(int i = 0; i < n; i++){
			if(i >= 1 && cards[i] != cards[i - 1]){
				list.add(new Numbers(cards[i - 1], count));
				count = 1;
			}
			else {
				count++;

			}
			if(i == n - 1){
				list.add(new Numbers(cards[i], count));
			}
		}

		//変更可能な数字についてもカードと同様に扱って良い
		for(int i = 0; i < m; i++){
			int b = sc.nextInt();
			int c = sc.nextInt();

			list.add(new Numbers(c, b));
		}
		//カードの値について降順にソート
		Collections.sort(list);

		long sum = 0;
		int remain = n;

		//あとはカードの値が大きい順にn枚選ぶだけ
		for(int i = 0; i < list.size(); i++){
			Numbers tmpNum = list.get(i);

			int use = Math.min(remain, tmpNum.num);

			sum += (long)use*tmpNum.value;

			remain -= use;

			if(remain == 0){
				break;
			}
		}

		System.out.println(sum);
	}

}

class Numbers implements Comparable<Numbers>{
	int value;
	int num;

	Numbers(int value, int num){
		this.value = value;
		this.num = num;
	}

	@Override
	public int compareTo(Numbers c1) {
		return c1.value - this.value;
	}
}
