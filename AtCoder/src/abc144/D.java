package abc144;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int x = sc.nextInt();


		//水が容器の体積の半分以上かどうかで計算が変わる
		if(a*a*b/2 <= x){
			//傾けたときの上部のこちらから見たときの面積
			double area = ((double)a*a*b - x)/a;
			//上部三角形のaじゃないほうの長さ
			double l = area*2/a;

			System.out.println(Math.atan(l/a)/Math.PI*180);
		}
		else {
			//傾けたときの下部のこちらから見たときの面積
			double area = ((double)x)/a;
			//上部三角形のbじゃないほうの長さ
			double l = area*2/b;

			System.out.println(Math.atan(b/l)/Math.PI*180);

		}
	}

}
