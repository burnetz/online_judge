package zone2021;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		int count = 0;

		for(int i = 0; i < str.length() - 3; i++){
			if(str.substring(i, i + 4).equals("ZONe")){
				count++;
			}
		}

		System.out.println(count);
	}

}
