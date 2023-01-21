package abc221;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] carray = sc.next().toCharArray();
		
		Arrays.sort(carray);
		
		long result = 0;
		for(int i = 0; i < Math.pow(2, carray.length) ; i++) {
			long mask = 1;
			String numStr1 = "", numStr2 = "";
			
			for(int j = carray.length - 1; j >= 0; j--) {
				if((i & mask) != 0) {
					numStr1 += carray[j];
				}
				else {
					numStr2 += carray[j];
				}
				
				mask <<= 1;
			}

			if(numStr1.equals("") || numStr2.equals("")) {
//				System.out.println("continue "+ numStr1 + " " + numStr2);
				continue;
			}
			long num1 = Long.parseLong(numStr1);
			long num2 = Long.parseLong(numStr2);
//			System.out.println(num1 + " " + num2);

			result = Math.max(result, num1*num2);
		}

		System.out.println(result);
	}
}
