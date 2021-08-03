package arc108;

import java.util.ArrayList;
import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String str1 = sc.next();
		ArrayList<Character> str2 = new ArrayList<Character>();
		
		//もともとの文字列の文字を前から順に別のリストに追加し
		//リストの末尾がfoxになるたびに削除するのが最適
		//ただし解説のとおり文字列でそれをやるとTLEになるのでArrayListを使う
		for(int i = 0; i < n; i++) {
			char c = str1.charAt(i);
			str2.add(c);
			int size = str2.size();
			if(size >= 3 && str2.get(size - 3) == 'f' && str2.get(size - 2) == 'o' && str2.get(size - 1) == 'x') {
				str2.remove(str2.size() - 1);
				str2.remove(str2.size() - 1);
				str2.remove(str2.size() - 1);
			}
		}
		
		System.out.println(str2.size());
	}
}