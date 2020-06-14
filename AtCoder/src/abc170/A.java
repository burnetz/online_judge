package abc170;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int i = 1;
		while(true){
			if(sc.nextInt() == 0){
				System.out.println(i);
				return;
			}
			i++;
		}
	}

}
