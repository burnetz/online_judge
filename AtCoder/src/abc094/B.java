package abc094;

import java.io.IOException;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();

		boolean gate[] = new boolean[n + 1];
		for(int i = 0; i < m; i++){
			gate[sc.nextInt()] = true;
		}

		int result = 0;
		int tmp = 0;
		for(int i = x; i >= 0; i--){
			if(gate[i]){
				tmp++;
			}
		}

		result = tmp;

		tmp = 0;
		for(int i = x; i <= n; i++){
			if(gate[i]){
				tmp++;
			}
		}

		result = Math.min(result, tmp);

		System.out.println(result);
	}
}
