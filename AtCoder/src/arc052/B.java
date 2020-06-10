package arc052;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();

		Corn[] corns = new Corn[n];
		for(int i = 0; i < n; i++){
			corns[i] = new Corn(i, sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		//多分解くだけならソートしなくてよい
		Arrays.sort(corns);

		for(int i = 0; i < q; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();

			double result = 0;
			for(int j = 0; j < n; j++){
				if(corns[j].intersect(a, b)){
					result += corns[j].volume(a, b);
				}
			}

			System.out.printf("%f\n",result);
		}
	}

}

class Corn implements Comparable<Corn>{
	int id;
	int x;
	int r;
	int h;

	Corn(int id, int x, int r, int h){
		this.id = id;
		this.x = x;
		this.r = r;
		this.h = h;
	}

	boolean intersect(int a, int b){
		if(!(a > x + h) && !(b < x )){
			return true;
		}
		else {
			return false;
		}
	}

	double volume(int a, int b){
		double tmpR;
		double tmpH;

		//左端がどこにあるかによっては相似比を考える必要がある
		if(a <= x){
			tmpR = r;
			tmpH = h;
		}
		else {
			tmpR = (h - a + x)*r/(double)h;
			tmpH = h - a + x;
		}

		double vol = Math.PI*tmpR*tmpR*tmpH/3;

		//区間より右に出てしまった円錐の体積もこのメソッドで計算できる
		if(b < x + h){
			vol -= this.volume(b, Integer.MAX_VALUE);
		}

		return vol;
	}
	@Override
	public int compareTo(Corn c) {
		// TODO 自動生成されたメソッド・スタブ
		return this.x - c.x;
	}
}