package abc124;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();

		int count = 0;
		int tmpCount = 0;

		for(int i = 0; i < str.length; i++){
			if((i % 2 == 0 && str[i] == '0') ||( i % 2 == 1 && str[i] == '1')){
				count++;
			}
		}

		for(int i = 0; i < str.length; i++){
			if((i % 2 == 1 && str[i] == '0') ||( i % 2 == 0 && str[i] == '1')){
				tmpCount++;
			}
		}

		System.out.println(Math.min(count, tmpCount));

	}

}