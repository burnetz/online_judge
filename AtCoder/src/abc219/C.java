package abc219;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String alpha = sc.next();

		int n = sc.nextInt();
		String[] input = new String[n];

		for(int i = 0; i < n; i++){
			input[i] = sc.next();
		}

		String[] encoded = new String[n];

		for(int i = 0; i < n; i++){
			encoded[i] = encodeStr(input[i], alpha);
		}

		Arrays.sort(encoded);

		for(int i = 0; i < n; i++){
			System.out.println(decodeStr(encoded[i], alpha));
		}
	}

	static String encodeStr(String str, String alpha){
		String result = "";

		for(int i = 0; i < str.length(); i++){
			result += (char)(alpha.indexOf(str.charAt(i)) + 'a');
		}

		return result;
	}

	static String decodeStr(String str, String alpha){
		String result = "";

		for(int i = 0; i < str.length(); i++){
			result += alpha.charAt(str.charAt(i) - 'a');
		}

		return result;
	}
}
