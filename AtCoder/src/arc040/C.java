package arc040;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		char[][] matrix = new char[n][n];

		for(int i = 0; i < n; i++){
			matrix[i] = sc.next().toCharArray();
		}

		int count = 0;
		for(int i = 0; i < n; i++){
			int c = -1;
			//同じ行で2回塗るのは無駄なので一番右の.まで塗れるようにする
			//次の行の左側に漏れが出るかもしれないが、今の行を2回塗ってまで考えることではない
			for(int j = n - 1; j >= 0; j--){
				if(matrix[i][j] == '.'){
					c = j;
					count++;
					break;
				}
			}

			if(c >= 0 && i != n - 1){
				for(int j = c; j < n; j++){
					matrix[i + 1][j] = 'o';
				}
			}

		}

		System.out.println(count);
	}
}

