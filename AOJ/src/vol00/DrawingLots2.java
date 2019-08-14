package vol00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DrawingLots2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
				
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0){
				break;
			}
			int start = Integer.parseInt(br.readLine());
			int goal = Integer.parseInt(br.readLine());
			int d = Integer.parseInt(br.readLine());

			boolean bridge[][] = new boolean[d + 1][n];
			for(int i = 1; i <= d; i++){
				String str = br.readLine();

				for(int j = 1; j < n; j++){
					if(str.charAt(j - 1) == '1'){
						bridge[i][j] = true;
					}
				}
			}

			solve(bridge, start, goal);
		}

	}
	static void solve(boolean bridge[][], int start, int goal){
		int d = bridge.length - 1;
		int n = bridge[0].length;
		
		//まずは普通にあみだくじをプレイ
		int result = playLots(bridge, start);

		if(result == goal){
			System.out.println(0);
			return;
		}
		//総当り
		for(int i = 1; i <= d; i++){
			for(int j = 1; j < n; j++){
				//置きたいところに既に橋がある
				//or そこに置くと繋がっていまう場合は除外
				if(bridge[i][j] || bridge[i][j - 1] || (j != n - 1 && bridge[i][j + 1])){
					continue;
				}

				bridge[i][j] = true;

				result = playLots(bridge, start);

				if(result == goal){
					System.out.println(i+" "+j);
					return;
				}

				//一時的に置いた橋は元に戻す
				bridge[i][j] = false;
			}
		}

		System.out.println(1);

	}
	//あみだくじをプレイ（1オリジン）
	static int playLots(boolean bridge[][], int start){
		int d = bridge.length - 1;
		int n = bridge[0].length;
		
		int current = start;
		
		for(int i = 1; i <= d; i++){
			if(bridge[i][current - 1]){
				current--;
			}
			else if(current != n && bridge[i][current]){
				current++;
			}
			
		}
		
		return current;
	}

}
