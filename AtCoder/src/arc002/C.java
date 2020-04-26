package arc002;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String command = sc.next();

		String[] pattern = {"AA", "AB", "AX", "AY", "BA", "BB", "BX", "BY",
				"XA", "XB", "XX", "XY", "YA", "YB", "YX", "YY"};

		if(n == 1){
			System.out.println(1);
			return;
		}

		int result = n;
		//lとrのどちらに割り当てるかは関係ないし、同じショートカットを割り当てる意味もない
		for(int l = 0; l < pattern.length; l++){
			for(int r = l + 1; r < pattern.length; r++){
				int count = 0;

				//前から処理していけばよい
				//（先に使ったショートカットキーのせいで次に使えなくなるショートカットも存在しうるが
				//合計回数は変わらないため）
				for(int i = 0; i < n; i++){
					if(i < n - 1 && (command.substring(i, i + 2).equals(pattern[l]) ||
							command.substring(i, i + 2).equals(pattern[r]))){
						i++;
					}
					count++;
				}

				result = Math.min(result, count);
			}
		}

		System.out.println(result);
	}
}
