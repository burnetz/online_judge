package arc034;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String input = sc.next();
		//BCをあらかじめDと置き換えて良い
		input = input.replaceAll("BC", "D");

		//残ったBやCは区切りとして使う
		String array[] = input.split("[BC]");
		long result = 0;
		for(int i = 0; i < array.length; i++){

			//最終的にはDDDD...AAAA..となるので転置数を求める
			int countA = 0;
			for(int j = 0; j < array[i].length(); j++){
				int c = array[i].charAt(j);

				if(c == 'A'){
					countA++;
				}
				else {
					result += countA;
				}
			}
		}
		System.out.println(result);
	}
}