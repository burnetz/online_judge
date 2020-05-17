package abc033;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		String[] term = str.split("\\+");

		int result = 0;
		//減算はないので、それぞれの項が0になればよい
		for(int i = 0; i < term.length; i++){

			int zeros = 0;

			for(int j = 0; j < term[i].length(); j++){
				if(term[i].charAt(j) == '0'){
					zeros++;
					break;
				}
			}

			if(zeros == 0){
				result++;
			}
		}

		System.out.println(result);
	}
}