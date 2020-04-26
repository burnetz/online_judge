package arc003;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		MyString array[] = new MyString[n];

		for(int i = 0; i < n; i++){
			array[i] = new MyString(sc.next());
		}

		Arrays.sort(array);


		for(int i = 0; i < n; i++){
			System.out.println(array[i].original);
		}
	}
}

class MyString implements Comparable<MyString> {
	String original;
	String reverse;

	MyString(String original){
		this.original = original;
		reverse = new StringBuffer(original).reverse().toString();
	}

	@Override
	public int compareTo(MyString ms) {
		// TODO 自動生成されたメソッド・スタブ
		return this.reverse.compareTo(ms.reverse);
	}
}