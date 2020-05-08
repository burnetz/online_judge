package abc104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int len = str.length();

		if(str.charAt(0) != 'A'){
			System.out.println("WA");
			return;
		}

		if(str.charAt(1) == 'C'){
			System.out.println("WA");
			return;
		}

		int numOfc = 0;

		for(int i = 2; i < len - 1; i++){
			if(str.charAt(i) == 'C'){
				numOfc++;
			}
		}

		if(numOfc != 1){
			System.out.println("WA");
			return;
		}

		int lower = 0;
		for(int i = 0; i < len; i++){
			if(Character.isLowerCase(str.charAt(i))){
				lower++;
			}
		}

		if(lower != len - 2){
			System.out.println("WA");
			return;
		}

		System.out.println("AC");
	}

}
