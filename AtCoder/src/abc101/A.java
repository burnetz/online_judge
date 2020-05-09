package abc101;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		int num = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == '+'){
				num++;
			}
			else {
				num--;
			}
		}
		System.out.println(num);
	}

}
