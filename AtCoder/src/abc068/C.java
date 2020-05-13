package abc068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class C {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmpArray = br.readLine().split(" ");
		int numOfIsland = Integer.parseInt(tmpArray[0]);
		int numOfShip = Integer.parseInt(tmpArray[1]);

		ArrayList<Integer> shipFrom1 = new ArrayList<Integer>();
		ArrayList<Integer> shipToN = new ArrayList<Integer>();

		boolean result = false;

		for(int i = 0; i < numOfShip ; i++){
			int a = 0;
			int b = 0;
			int num = 0;
			int tmp = br.read();
			int flag = 0;
			//a bの読み込み
			while(tmp != -1 && tmp != 10 && tmp != 13){
	            num = 0;
	            while(tmp >= '0' && tmp <= '9'){
	                num = num * 10 + (tmp - '0');
	                tmp = br.read();
	            }
	            if(tmp == -1){
	                break;
	            }
	            if(flag == 0){
	            	a = num;
	            	tmp = br.read();
	            }
	            else b = num;
	            flag++;
	        }

			if(a == 1){
				shipFrom1.add(b);
			}

			else if(b == numOfIsland){
				shipToN.add(a);
			}
		}

		//配列に変換
		Integer[] array1 = shipFrom1.toArray(new Integer[0]);
		Arrays.sort(array1);
		Integer[] array2 = shipToN.toArray(new Integer[0]);
		Arrays.sort(array2);

		if(array1.length <= array2.length){
			for(int i = 0; i < array1.length ; i++){
				if(Arrays.binarySearch(array2, array1[i]) >= 0){
					result = true;
					break;
				}
			}
		}
		else {
			for(int i = 0; i < array2.length ; i++){
				if(Arrays.binarySearch(array1, array2[i]) >= 0){
					result = true;
					break;
				}
			}
		}

		if(result){
			System.out.println("POSSIBLE");
		}
		else {
			System.out.println("IMPOSSIBLE");
		}
	}

}