package abc287;

import java.util.HashMap;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		char s[] = sc.next().toCharArray();
		char t[] = sc.next().toCharArray();
		
		//左からi文字までtとマッチできるか
		boolean matchLeft[] = new boolean[s.length];
		//i文字から右を使ってtとマッチできるか
		boolean matchRight[] = new boolean[s.length];
		
		matchLeft[0] = true;
		for(int i = 0; i < t.length; i++) {
			if(s[i] == '?' || t[i] == '?' || s[i] == t[i]) {
				matchLeft[i + 1] = true;
			}
			//マッチできなければそこから先でtrueになることはない。
			else {
				break;
			}
		}
		
		matchRight[s.length - 1] = true;
		for(int i = 0; i < t.length; i++) {
			if(s[s.length - i - 1] == '?' || t[t.length - i - 1] == '?' || s[s.length - i - 1] == t[t.length - i - 1]) {
				matchRight[s.length - i - 2] = true;
			}
			else {
				break;
			}			
		}
		
		for(int i = 0; i <= t.length; i++) {
			if(matchLeft[i] && matchRight[s.length - t.length + i - 1]) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
	}
}