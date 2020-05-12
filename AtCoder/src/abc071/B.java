package abc071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int[] table = makeCharTable(input);
		char result = getUnexistNumber(table);

		if(result == 0){
			System.out.println("None");
		}
		else {
			System.out.println(result);
		}
	}

	public static int[] makeCharTable(String str){
		char[] carray = str.toCharArray();
		int[] result = new int[26];

		for(int i = 0; i < carray.length ; i++){
			result[carray[i] - 'a']++;
		}

		return result;
	}

	public static char getUnexistNumber(int[] table){
		for(int i = 0; i < table.length ; i++){
			if(table[i] == 0){
				return (char)(i + 'a');
			}
		}

		return (char)0;
	}

}