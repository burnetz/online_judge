package abc161;

import java.util.Scanner;
import java.util.Stack;

public class E {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();

		char[] str = sc.next().toCharArray();
		//dp[i] : i日目にこなしている仕事の最大値
		int dp[] = new int[n];

		for(int i = 0; i < n; i++){
			//i日目に仕事が可能なら、累計数はi-(c + 1)日目より1大きくなる
			if(str[i] == 'o'){
				if(i <= c){
					dp[i] = 1;
				}
				else {
					dp[i] = dp[i - c - 1] + 1;
				}
			}
			//i日目に仕事ができないなら前日と累計数が変わらない
			else {
				if(i == 0){
					dp[i] = 0;
				}
				else {
					dp[i] = dp[i - 1];
				}
			}

		}

		//k日を上回る仕事をこなせるのなら、必ず働かなければならない日は存在しない
		if(dp[n - 1] > k){
			return;
		}

		//後で逆順で出力するのでスタックを採用
		Stack<Integer> stack = new Stack<Integer>();

		//dpテーブル内の数字が一致しているグループ内で勤務可能な日数
		int count = 0;
		//上記の勤務可能日の中で一番大きい日付
		int firstIndex = -1;

		//大きい日付から順に調べる
		for(int i = n - 1; i >= 0; i--){
			//dpテーブル内の数字が一致しているグループ内で勤務可能な日数を数える
			if(str[i] == 'o'){
				count++;
				if(firstIndex == -1){
					firstIndex = i;
				}
			}

			//グループの終端に到達したとき
			if(i == 0 || dp[i - 1] != dp[i]){
				//countが1ということは同グループ内で勤務可能な日が1日しかなかったということ
				//確実にその日は働く
				if(count == 1){
					stack.add(firstIndex + 1);
				}
				count = 0;
				if(i != 0){

					//firstIndex（グループ内で一番後の勤務可能日）から見てc日前まではたとえoでも勤務不可能なのでスキップする必要がある
					//ただしスキップしてもiより小さくならない場合はスキップしない
					i = Math.min(i, firstIndex - c);
				}
				firstIndex = -1;

			}
		}

		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

}
