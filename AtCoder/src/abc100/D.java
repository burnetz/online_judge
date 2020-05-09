package abc100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class D {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int n = Integer.parseInt(tmpArray[0]);
		int m = Integer.parseInt(tmpArray[1]);

		long param[][] = new long[n][3];

		Cake[] cakes = new Cake[n];
		for(int i = 0; i < n; i++){
			tmpArray = br.readLine().split(" ");

			for(int j = 0; j < 3; j++){
				param[i][j] = Long.parseLong(tmpArray[j]);
			}

			cakes[i] = new Cake(param[i][0], param[i][1], param[i][2]);
		}

		long result[] = new long[8];

		//pattern1
		Arrays.sort(cakes, new Comparator<Cake>() {

			@Override
			public int compare(Cake c1, Cake c2) {
				// TODO 自動生成されたメソッド・スタブ
				long tmp = (c1.beauty - c2.beauty) + (c1.delicious - c2.delicious) + (c1.popular - c2.popular);
				if(tmp > 0){
					return 1;
				}
				else if(tmp == 0){
					return 0;
				}
				else {
					return -1;
				}
			}
		});

		result[0] = sum(cakes, m);

		//pattern2
		Arrays.sort(cakes, new Comparator<Cake>() {

			@Override
			public int compare(Cake c1, Cake c2) {
				// TODO 自動生成されたメソッド・スタブ
				long tmp =  (c1.beauty - c2.beauty) + (c1.delicious - c2.delicious) - (c1.popular - c2.popular);
				if(tmp > 0){
					return 1;
				}
				else if(tmp == 0){
					return 0;
				}
				else {
					return -1;
				}
			}
		});

		result[1] = sum(cakes, m);

		//pattern3
		Arrays.sort(cakes, new Comparator<Cake>() {

			@Override
			public int compare(Cake c1, Cake c2) {
				// TODO 自動生成されたメソッド・スタブ
				long tmp =  (c1.beauty - c2.beauty) - (c1.delicious - c2.delicious) + (c1.popular - c2.popular);
				if(tmp > 0){
					return 1;
				}
				else if(tmp == 0){
					return 0;
				}
				else {
					return -1;
				}
			}
		});

		result[2] = sum(cakes, m);

		//pattern4
		Arrays.sort(cakes, new Comparator<Cake>() {

			@Override
			public int compare(Cake c1, Cake c2) {
				// TODO 自動生成されたメソッド・スタブ
				long tmp =  (c1.beauty - c2.beauty) - (c1.delicious - c2.delicious) - (c1.popular - c2.popular);
				if(tmp > 0){
					return 1;
				}
				else if(tmp == 0){
					return 0;
				}
				else {
					return -1;
				}
			}
		});

		result[3] = sum(cakes, m);

		//pattern5
		Arrays.sort(cakes, new Comparator<Cake>() {

			@Override
			public int compare(Cake c1, Cake c2) {
				// TODO 自動生成されたメソッド・スタブ
				long tmp =  -(c1.beauty - c2.beauty) + (c1.delicious - c2.delicious) + (c1.popular - c2.popular);
				if(tmp > 0){
					return 1;
				}
				else if(tmp == 0){
					return 0;
				}
				else {
					return -1;
				}
			}
		});

		result[4] = sum(cakes, m);

		//pattern6
		Arrays.sort(cakes, new Comparator<Cake>() {

			@Override
			public int compare(Cake c1, Cake c2) {
				// TODO 自動生成されたメソッド・スタブ
				long tmp = -(c1.beauty - c2.beauty) + (c1.delicious - c2.delicious) - (c1.popular - c2.popular);
				if(tmp > 0){
					return 1;
				}
				else if(tmp == 0){
					return 0;
				}
				else {
					return -1;
				}
			}
		});

		result[5] = sum(cakes, m);

		//pattern7
		Arrays.sort(cakes, new Comparator<Cake>() {

			@Override
			public int compare(Cake c1, Cake c2) {
				// TODO 自動生成されたメソッド・スタブ
				long tmp = -(c1.beauty - c2.beauty) - (c1.delicious - c2.delicious) + (c1.popular - c2.popular);
				if(tmp > 0){
					return 1;
				}
				else if(tmp == 0){
					return 0;
				}
				else {
					return -1;
				}
			}
		});

		result[6] = sum(cakes, m);
//		System.out.println(sum(cakes, m));

		//pattern8
		Arrays.sort(cakes, new Comparator<Cake>() {

			@Override
			public int compare(Cake c1, Cake c2) {
				// TODO 自動生成されたメソッド・スタブ
				long tmp = -(c1.beauty - c2.beauty) - (c1.delicious - c2.delicious) - (c1.popular - c2.popular);
				if(tmp > 0){
					return 1;
				}
				else if(tmp == 0){
					return 0;
				}
				else {
					return -1;
				}
			}
		});

		result[7] = sum(cakes, m);

		Arrays.sort(result);

		System.out.println(result[7]);

	}

	static void showCakes(Cake cakes[]){
		for(int i = 0; i < cakes.length; i++){
			System.out.println(cakes[i].beauty + " "+ cakes[i].delicious + " "+ cakes[i].popular);
		}
	}
	static long sum(Cake cakes[] , int m){

		long b = 0, d = 0, p = 0;
		for(int i = 0; i < m; i++){
			b += cakes[i].beauty;
			d += cakes[i].delicious;
			p += cakes[i].popular;
		}

		return Math.abs(b)+Math.abs(d)+Math.abs(p);
	}

}

class Cake {
	long beauty;
	long delicious;
	long popular;

	public Cake(long b, long d, long p){
		this.beauty = b;
		this.delicious = d;
		this.popular = p;
	}
}