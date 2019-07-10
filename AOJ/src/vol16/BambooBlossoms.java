package vol16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BambooBlossoms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			String[] tmpArray = br.readLine().split(" ");

			int m = Integer.parseInt(tmpArray[0]);
			int n = Integer.parseInt(tmpArray[1]);

			if(m == 0){
				break;
			}

			//上限がこの値であることはわかっている
			boolean flower[] = new boolean[7368792];

			//エラトステネスもどき
			for(int i = m; i < flower.length && n > 0 ; i++){
				if(flower[i]){
					continue;
				}

				n--;
				for(int j = 1; i*j < flower.length ; j++){
					flower[i*j] = true;
				}
			}

			//何年まで花が咲き続けるか
			for(int i = m; i < flower.length ; i++){
				if(!flower[i]){
					System.out.println(i);
					break;
				}
			}
		}
	}

}
