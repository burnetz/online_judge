package abc065;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws Exception {
		// Here your code !
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] data = new int[n+1];
		for(int i = 1; i < n+1; i ++){
			data[i] = Integer.parseInt(br.readLine());
		}

		int[] light = new int[n+1];
		int[] pushed = new int[n+1];
		light[1] = 1;
		pushed[1] = 0;
		for(int i = 2; i <= n ; i++){
			light[i] = 0;
			pushed[i] = 0;
		}

		int count = 0;
		boolean achieve = false;
		//光っているボタンを探す
		int next = 1;
		while(true){
			boolean breakFlag = false;


			for(int i = next; i <= n; i++){
				if(light[i] == 1){
					light[i] = 0;
					light[data[i]] = 1;
					next = data[i];
					pushed[i] = 1;
					count++;

					if(data[i] == 2){
						achieve = true;
						breakFlag = true;
					}

					else if(pushed[data[i]] == 1){
						breakFlag = true;
					}

					break;
				}
			}

			if(breakFlag){
				break;
			}
		}

		if(achieve){
			System.out.println(count);
		}
		else {
			System.out.println(-1);
		}

	}
}