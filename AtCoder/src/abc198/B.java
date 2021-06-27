package abc198;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		int index;

		for(index = s.length() - 1; index >= 0 ; index--){
			if(s.charAt(index) != '0'){
				break;
			}
		}

		if(index >= 0){
			s = s.substring(0, index + 1);
		}

		if(s.equals(new StringBuffer(s).reverse().toString())){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}
