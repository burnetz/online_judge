package arc065;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		
		int right = str.length();
		
		//前から検索すると末尾のerと先頭のerが区別がつかない
		//後ろから検索すると誤解が無く楽
		while(right > 0) {
			if(right >= 7 && str.substring(right - 7, right).equals("dreamer")) {
				right -= 7;
			}
			else if(right >= 6 && str.substring(right - 6, right).equals("eraser")) {
				right -= 6;
			}
			else if(right >= 5){
				String tmp = str.substring(right - 5, right);
				
				if(tmp.equals("dream") || tmp.equals("erase")) {
					right -= 5;
				}
				else {
					System.out.println("NO");
					return;
				}
			}
			else {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}

}
