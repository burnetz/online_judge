package vol27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AirportCodes {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			int n = Integer.parseInt(br.readLine());

			if(n == 0){
				break;
			}

			String[] input = new String[n];

			for(int i = 0; i < n; i++){
				input[i] = br.readLine();
			}

			String names[] = new String[n];
			for(int i = 0; i < n; i++){

				names[i] = ""+input[i].charAt(0);
				for(int j = 0; j < input[i].length() - 1; j++){
					if(input[i].substring(j, j + 1).matches("[aeiou]")){
						names[i] += input[i].charAt(j + 1);
					}
				}
				//あとで処理をしやすいように余計な文字をたくさん追加しておく
				names[i] += "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

			}

			//比較は素朴にやる

			for(int i = 1; i <= 50; i++){
				boolean same = false;
				for(int j = 0; j < n; j++){
					for(int k = j + 1; k < n; k++){

						if(names[j].substring(0, i).equals(names[k].substring(0, i))){
							same = true;
							break;
						}
					}

					if(same){
						break;
					}
				}

				if(!same){
					System.out.println(i);
					break;
				}
				else if(i == 50){
					System.out.println(-1);
				}
			}


		}
	}

}
