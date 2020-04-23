package arc031;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for(int i = 0; i < 10; i++){
			String str = sc.next();
			for(int j = 0; j < 10; j++){
				if(str.charAt(j) == 'o'){
					original[i][j] = true;
				}
			}
		}

		if(solve()){
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

	static boolean original[][] = new boolean[10][10];
	static boolean map[][] = new boolean[10][10];
	static boolean visit[][] = new boolean[10][10];

	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};

	static boolean solve(){
		int startX = -1, startY = -1;


		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(original[i][j]){
					startX = j;
					startY = i;
					break;
				}
			}

			if(startX >= 0){
				break;
			}
		}


		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				init();

				map[i][j] = true;

				dfs(startX, startY);

				if(united()){
					return true;
				}
			}
		}


		return false;
	}

	static void dfs(int x, int y){
		visit[y][x] = true;

		for(int i = 0; i < 4; i++){
			int tmpX = x + dx[i];
			int tmpY = y + dy[i];

			if(tmpX >= 0 && tmpX < 10 && tmpY >= 0 && tmpY < 10 && map[tmpY][tmpX] && !visit[tmpY][tmpX]){
				dfs(tmpX, tmpY);
			}
		}
	}

	static void init(){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				map[i][j] = original[i][j];
				visit[i][j] = false;
			}
		}
	}

	static boolean united(){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(map[i][j] && !visit[i][j]){
					return false;
				}
			}
		}

		return true;
	}
}
