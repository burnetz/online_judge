package abc110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();

		boolean checked[] = new boolean[str1.length];

		for(int i = 0; i < str1.length ; i++){
			if(checked[i]){
				continue;
			}

			for(int j = i + 1; j < str1.length ; j++){
				if((str1[i] == str1[j] && str2[i] != str2[j] )||
						(str1[i] != str1[j] && str2[i] == str2[j] )){
					System.out.println("No");
					return;
				}

				else if(str1[i] == str1[j]){
					checked[j] = true;
				}
			}
		}

		System.out.println("Yes");

	}
}
