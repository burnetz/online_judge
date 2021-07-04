package codefes2016final;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				if(sc.next().equals("snuke")){
					System.out.println((char)('A' + j) + "" + (i + 1));
					return;
				}
			}
		}
	}

}
