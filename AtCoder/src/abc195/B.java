package abc195;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int w = sc.nextInt();

		int max = 0;
		int min = Integer.MAX_VALUE;
		//1個あたりの重さは実数なのでバラバラの必要がない。
		//個数を決め打ちして1個あたりの重さが条件を満たすかを考える
		for(int i = 1; i <= 1_000_000; i++){
			double unit = (double)w*1000/i;

			if(unit >= a && unit <= b){
				max = Math.max(max, i);
				min = Math.min(min, i);
			}
		}

		if(max != 0){
			System.out.println(min+ " "+ max);
		}
		else{
			System.out.println("UNSATISFIABLE");
		}
	}

}
