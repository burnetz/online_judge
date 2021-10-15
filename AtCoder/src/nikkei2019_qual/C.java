package nikkei2019_qual;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		long sum = 0;
		long sumB = 0;
		Food foods[] = new Food[n];
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			foods[i] = new Food(a, b);
			sumB += b;
		}
		
		//青木くんが予めbの合計を得ており、高橋くんが何かを食べるとa+bを得ると考えても結果は同じ。
		//そのためa+bでソートすることで解ける
		Arrays.sort(foods);
		
		//青木くんは自分のターンに何も得ない。
		for(int i = 0; i < n ; i++) {
			if(i % 2 == 0) {
				sum += foods[n - 1 - i].a + foods[n - 1 - i].b;
			}
		}
		
		System.out.println(sum - sumB);
	}
}

class Food implements Comparable<Food>{
	int a;
	int b;
	
	Food(int a, int b){
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Food f) {
		// TODO Auto-generated method stub
		return (this.a + this.b) - (f.a + f.b);
	}

}