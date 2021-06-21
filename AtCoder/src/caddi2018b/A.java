package caddi2018b;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String x = sc.next();
		int count = 0;

		for(int i = 0; i < x.length(); i++){
			if(x.charAt(i) == '2'){
				count++;
			}
		}

		System.out.println(count);
	}

}
