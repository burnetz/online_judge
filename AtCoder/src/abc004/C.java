package abc004;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//30で1サイクル。あとは同じ結果が繰り返すだけ。
		int n = sc.nextInt()%30;
		
		char[] array = "123456".toCharArray();
		
		for(int i = 0; i < n; i++) {
			int idx1 = i%5;
			int idx2 = i%5 + 1;
			
			char tmp = array[idx1];
			array[idx1] = array[idx2];
			array[idx2] = tmp;
		}
		
		System.out.println(array);
	}
}