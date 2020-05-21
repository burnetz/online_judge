package abc029;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int count = 0;
		for(int i = 0; i < 12; i++){
			if(sc.next().contains("r")){
				count++;
			}
		}

		System.out.println(count);
	}
}