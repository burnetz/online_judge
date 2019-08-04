package abc136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char input[] = br.readLine().toCharArray();
		
		int n = input.length;
		int result[] = new int[n];
		
		//RLを探す
		for(int i = 0; i < n - 1; i++){
			if(input[i] == 'R' && input[i + 1] == 'L'){
				//RLから見て左側
				//同じRでも"RL"から見た距離の偶奇で"RL"のどちらに落ち着くかが決まる
				for(int j = i; j >= 0 && input[j] == 'R' ; j--){
					if((i - j) % 2 == 0){
						result[i]++;
					}
					else {
						result[i + 1]++;
					}
				}
				
				//RLから見て右側
				for(int j = i + 1; j < n && input[j] == 'L'; j++){
					if((j - i + 1) % 2 == 0){
						result[i + 1]++;
					}
					else {
						result[i] ++;
					}
				}
			}
		}
		//output
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < n; i++){
			if(i != 0){
				sb.append(" ");
			}
			sb.append(result[i]);
		}
		
		System.out.println(sb);
	}

}
