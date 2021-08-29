package keyence2020;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Robot[] robots = new Robot[n];

		for(int i = 0; i < n; i++){
			robots[i] = new Robot(sc.nextInt(), sc.nextInt());
		}

		//各ロボットの有効範囲の右端をもとにソートする
		Arrays.sort(robots);

		int currentRight = Integer.MIN_VALUE;
		int count = 0;

		//直前まで適切に間引きが行われているとする。
		//今見ているロボットと既存の範囲がかぶる場合
		//1個選んで1個捨てることになるため敢えて右端を延ばす必要がない。
		//被らないときだけ範囲を追加することで無駄なく右端を延ばすことができる。
		for(int i = 0; i < n; i++){
			if(currentRight <= robots[i].pos - robots[i].arm){
				count++;
				currentRight = robots[i].pos + robots[i].arm;
			}
		}

		System.out.println(count);
	}

}

class Robot implements Comparable<Robot>{
	int pos;
	int arm;

	Robot(int pos, int arm){
		this.pos = pos;
		this.arm = arm;
	}

	@Override
	public int compareTo(Robot r) {
		// TODO 自動生成されたメソッド・スタブ
		long right1 = this.pos + this.arm;
		long right2 = r.pos + r.arm;
		return right1 == right2 ? 0 :
			right1 > right2 ? 1 : -1;
	}

}