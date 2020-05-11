package abc089;

import java.io.IOException;
import java.util.Scanner;

public class C {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for(int i = 0; i < n; i++){
			char c = sc.next().charAt(0);

			int index = 0;
			switch(c){
			case 'M':
				index = 0;
				break;
			case 'A':
				index = 1;
				break;
			case 'R':
				index = 2;
				break;
			case 'C':
				index = 3;
				break;
			case 'H':
				index = 4;
				break;
			default :
				continue;
			}

			count[index]++;
		}

		dfs(0, -1);

		System.out.println(result);
	}

	static int count[] = new int[5];
	static int index[] = new int[3];
	static long result = 0;

	//文字の選択は10パターンしかないので全探索で間に合う
	static void dfs(int depth, int prevIndex){
		if(depth == 3){
			long tmp = 1;

			for(int i = 0; i < 3; i++){
				tmp *= count[index[i]];
			}

			result += tmp;

			return;
		}

		for(int i = prevIndex + 1; i < 5; i++){
			index[depth] = i;
			dfs(depth + 1, i);
		}
	}


}
