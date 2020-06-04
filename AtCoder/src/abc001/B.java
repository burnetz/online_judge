package abc001;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String result;
		if(n < 100){
			result = "00";
		}
		else if(n <= 5000){
			if(n <= 999){
				result = "0" + n/100;
			}
			else {
				result = "" + n/100;
			}
		}
		else if(n <= 30000){
			result = "" + (n/1000 + 50);
		}
		else if(n <= 70000){
			result = (n/1000 - 30)/5 + 80 + "";
		}
		else {
			result = "89";
		}

		System.out.println(result);
	}
}