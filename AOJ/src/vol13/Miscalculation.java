package vol13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Miscalculation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int inputAns = Integer.parseInt(br.readLine());

		//真面目に計算する方
		int numArray1[] = new int[input.length()/2 + 1];
		//左からしか計算しない方
		int numArray2[] = new int[input.length()/2 + 1];

		for(int i = 0; i < numArray1.length; i++){
			numArray1[i] = numArray2[i] = input.charAt(i*2) - '0';
		}

		int ans1=0, ans2=0;

		//真面目に計算する方（掛け算->足し算で考える）
		for(int i = 0; i < input.length() / 2; i++){
			if(input.charAt(i*2 + 1) == '*'){
				numArray1[i + 1] = numArray1[i]*numArray1[i+1];
				numArray1[i] = 0;
			}
		}
		for(int i = 0; i < numArray1.length; i++){
			ans1 += numArray1[i];
		}

		//左から計算する方
		for(int i = 0; i < input.length() / 2; i++){
			if(input.charAt(i*2 + 1) == '*'){
				numArray2[i + 1] = numArray2[i]*numArray2[i+1];
			}
			else {
				numArray2[i + 1] = numArray2[i]+numArray2[i+1];
			}
		}
		ans2 = numArray2[numArray2.length - 1];

		String result = null;
		if(ans1 == inputAns && ans2 != inputAns){
			result = "M";
		}
		else if(ans1 != inputAns && ans2 == inputAns){
			result = "L";
		}
		else if(ans1 == inputAns && ans2 == inputAns){
			result = "U";
		}
		else {
			result = "I";
		}

		System.out.println(result);
	}

}
