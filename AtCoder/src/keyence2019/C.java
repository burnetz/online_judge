package keyence2019;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		int b[] = new int[n];
		
		long sumA = 0;
		long sumB = 0;
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			sumA += a[i];
		}
		
		for(int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
			sumB += b[i];
		}
		
		if(sumA < sumB) {
			System.out.println(-1);
			return;
		}
		
		Data[] data = new Data[n];
		
		for(int i = 0; i < n; i++) {
			data[i] = new Data(a[i], b[i]);
		}
		
		//aとbの差分（正負の区別あり）でソートする
		Arrays.parallelSort(data);
		
		//足りないことが理由で変化する要素数は変えられない
		//あとはより少ない要素数でそれを補うことを考える
		int index = 0;
		long sum = 0;
		int count = 0;
		while(data[index].a < data[index].b) {
			sum += data[index].b - data[index].a;
			count++;
			index++;
		}
		index = n - 1;
		while(sum > 0) {
			sum += data[index].b - data[index].a;
			count++;
			index--;
		}
		
		System.out.println(count);
	}

}

class Data implements Comparable<Data>{
	long a;
	long b;
	
	Data(int a, int b){
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Data d) {
		// TODO Auto-generated method stub
		long diff1 = this.a - this.b;
		long diff2 = d.a - d.b;
		return diff1 == diff2 ? 0 :
			diff1 > diff2 ? 1 : -1;
	}
}