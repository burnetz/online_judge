package abc140;

import java.util.Scanner;

public class D {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		char str[] = sc.next().toCharArray();
		char str2[] = (char[])str.clone();
		
		char target;
		char overWrite;
		
		if(str[0] == 'L'){
			target = 'R';
			overWrite = 'L';
		}
		else {
			target = 'L';
			overWrite = 'R';
		}
		
		//最適なのはLLL RRRR LLL R Lなどの場合
		//偶数番目のセクションを全て0文字目に合わせること
		//どのくらい同じ文字が連続しているかは反転しても関係ないので
		//単純に左からk回やれば十分
		
		for(int i = 1; i < n ; i++){
			if(str[i] != target){
				if(k == 0){
					break;
				}
				continue;
			}
			
			if(str[i - 1] != target){
				k--;
			}
			
			str2[i] = overWrite;
		}
		
		int result = 0;
		
		for(int i = 0; i < n; i++){
			if(i != 0 && str2[i - 1] == str2[i] && str2[i] == 'L'){
				result++;
			}
			
			else if (i != n - 1 && str2[i + 1] == str2[i] && str2[i] == 'R'){
				result++;
			}
		}
		
		System.out.println(result);
	}

}
