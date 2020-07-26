package vol16;

import java.util.Scanner;

public class ICPCCalculator {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		while(true){
			int n = sc.nextInt();

			if(n == 0){
				break;
			}

			char value[] = new char[n];
			int depth[] = new int[n];

			//事前に深さを数値化しておいたほうが楽
			for(int i = 0; i < n; i++){
				String tmpStr = sc.next();
				value[i] = tmpStr.charAt(tmpStr.length() - 1);
				depth[i] = tmpStr.length() - 1;
			}

			System.out.println(solve(value, depth, 0, OP_SUM, 0));
		}
	}

	//今回はスタックとかを使うよりも再帰のほうが多分楽
	static final int OP_SUM = 0;
	static final int OP_PROD = 1;
	static int solve(char value[], int depth[], int targetDepth, int opMode, int beginIndex){
		int result = 0;
		if(opMode == OP_PROD){
			result = 1;
		}

		for(int i = beginIndex; i < value.length; i++){
			//浅いところに来てしまったならもう戻るべき
			if(depth[i] < targetDepth ){
				break;
			}
			//深いところは再帰に任せているので無視
			else if(depth[i] > targetDepth){
				continue;
			}

			int tmpRes;
			if(value[i] == '*'){
				tmpRes = solve(value, depth, targetDepth + 1, OP_PROD, i + 1);
			}
			else if(value[i] == '+'){
				tmpRes = solve(value, depth, targetDepth + 1, OP_SUM, i + 1);
			}
			else {
				tmpRes = value[i] - '0';
			}

			if(opMode == OP_SUM){
				result += tmpRes;
			}
			else {
				result *= tmpRes;
			}
		}

		return result;
	}

}
