package abc076;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		char[] cinput = input.toCharArray();
		char[] hint = br.readLine().toCharArray();

		//まずは力任せでやってみる
		for(int i = cinput.length - hint.length; i >= 0; i--){
			if(canReplace(cinput, hint, i)){
				replaceHint(cinput, hint, i);
				replaceToA(cinput);
				System.out.println(cinput);
				return;
			}
		}
		System.out.println("UNRESTORABLE");

	}

	static void replaceToA(char[] input){
		for(int i = 0; i < input.length ; i++){
			if(input[i] == '?'){
				input[i] = 'a';
			}
		}
	}

	static void replaceHint(char[] input, char[] hint, int start){
		for(int i = start ; i < start + hint.length ; i++){
			input[i] = hint[i - start];
		}
	}

	static boolean canReplace(char[] input, char[] hint, int start){
		for(int i = start ; i < start + hint.length ; i++){
			if(!(input[i] == '?' || input[i] == hint[i - start])){
				return false;
			}
		}

		return true;
	}

}