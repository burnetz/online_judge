package abc122;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();

		int result = 0;

		int tmpCount = 0;
		for(int i = 0; i < str.length; i++){

			if(str[i] != 'A' && str[i] != 'C' && str[i] != 'T' && str[i] != 'G'){
				tmpCount = 0;
				continue;
			}
			tmpCount++;
			result = Math.max(result, tmpCount);
		}

		System.out.println(result);
	}

}
