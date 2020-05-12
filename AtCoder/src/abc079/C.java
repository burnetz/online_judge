package abc079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String tmp = br.readLine();

		int numbers[] = new int[4];

		for(int i = 0; i < 4; i++){
			numbers[i] = tmp.charAt(i) - '0';
		}

		String[] op = {"+","-"};
		//全探索
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 2; j++){
				for(int k = 0; k < 2; k++){
					int result = numbers[0];

					if(i == 0){
						result += numbers[1];
					}
					else {
						result -= numbers[1];
					}

					if(j == 0){
						result += numbers[2];
					}
					else {
						result -= numbers[2];
					}

					if(k == 0){
						result += numbers[3];
					}
					else {
						result -= numbers[3];
					}

					if(result == 7){
						System.out.println(numbers[0] + op[i] + numbers[1] + op[j] + numbers[2] + op[k] + numbers[3] + "=7");
						return;
					}
				}
			}
		}

	}

}