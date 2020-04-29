package abc121;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		Shop[] shops = new Shop[n];

		for(int i = 0; i < n; i++){
			shops[i] = new Shop(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(shops);
		long total = 0;
		for(int i = 0; i < n; i++){
			if(shops[i].stock < m){
				total += (long)shops[i].stock*shops[i].price;
				m -= shops[i].stock;
			}
			else {
				total += (long)m*shops[i].price;
				break;
			}

//			System.out.println("total "+total+" m "+m);
		}

		System.out.println(total);
	}
}

class Shop implements Comparable<Shop>{
	int price;
	int stock;

	Shop(int price, int stock){
		this.price = price;
		this.stock = stock;
	}

	@Override
	public int compareTo(Shop s) {
		// TODO 自動生成されたメソッド・スタブ
		return this.price - s.price;
	}


}