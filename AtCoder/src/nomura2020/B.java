package nomura2020;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();

		for(int i = 0; i < str.length; i++){
			if(str[i] == '?'){
				str[i] = 'D';
			}
		}

		System.out.println(str);
	}

}
