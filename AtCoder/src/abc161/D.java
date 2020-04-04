package abc161;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		k = sc.nextInt();

		dfs(0);

	}

	static int k;
	//最大のルンルン数でも12桁あれば間に合う
	static final int DEPTH_MAX = 12;
	static int[] digits = new int[DEPTH_MAX];
	static int count = 1;


	//以下、leading zeroの意味で-1を使う
	static void dfs(int depth){
		if(depth == DEPTH_MAX){
			//これはleading zeroだけで作ってしまった場合
			if(digits[DEPTH_MAX - 1] == -1){
				return;
			}
			//ここで強制終了してもよいが、最後まで空回ししても間に合う
			if(count == k){
				printDigits();
			}

			count++;
			return;
		}

		int start = 0;
		//一番左の桁そのもの、あるいは前の桁がleading zeroなら今の桁もleading zeroの可能性を考慮
		if(depth == 0 || digits[depth - 1] == -1){
			start = -1;
		}
		for(int i = start; i <= 9; i++){
			//一番左の桁そのもの、あるいは前の桁がleading zeroのときは普通の0にしてはいけない
			if(i == 0 && (depth == 0 || digits[depth - 1] == -1)){
				continue;
			}
			//0は上で弾いたので、あとはleading zeroかルンルン数ならOK
			if(i == -1 || (depth >= 1 && (digits[depth - 1] == -1 || Math.abs(digits[depth - 1] - i) <= 1))){
				digits[depth] = i;
				dfs(depth + 1);
 			}
		}
	}

	static void printDigits(){
		for(int i = 0; i < DEPTH_MAX; i++){
			//leading zeroはスキップ
			if(digits[i] != -1){
				System.out.print(digits[i]);
			}
		}
		System.out.println();
	}

}
