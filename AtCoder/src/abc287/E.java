package abc287;

import java.util.Arrays;
import java.util.Scanner;

public class E {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int lcp[] = new int[n];
		
		MyString mystr[] = new MyString[n]; 
		for(int i = 0; i < n; i++) {
			mystr[i] = new MyString(i, sc.next());
		}
		
		Arrays.sort(mystr);
		
		for(int i = 0; i < n; i++) {
			int tmpResult = 0;
			
			//最大のlcpとなる組み合わせの候補は各文字列を辞書式にソートしたときの前後の文字列のみ。
			if(i != 0) {
				for(int j = 0; j < mystr[i - 1].str.length() && j < mystr[i].str.length(); j++) {
					if(mystr[i - 1].str.charAt(j) == mystr[i].str.charAt(j)) {
						tmpResult = Math.max(tmpResult, j + 1);
					}
					else break;
				}
			}
			
			if(i != n - 1) {
				for(int j = 0; j < mystr[i + 1].str.length() && j < mystr[i].str.length(); j++) {
					if(mystr[i + 1].str.charAt(j) == mystr[i].str.charAt(j)) {
						tmpResult = Math.max(tmpResult, j + 1);
					}
					else break;
				}
			}
			
			lcp[mystr[i].id] = tmpResult;
		}
	
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < n; i++) {
			sb.append(lcp[i] + "\n");
		}
		System.out.print(sb);
	}
}

class MyString implements Comparable<MyString>{
	String str;
	int id; 
	
	MyString (int id, String str){
		this.id = id;
		this.str = str;
	}

	@Override
	public int compareTo(MyString mystr) {
		// TODO Auto-generated method stub
		return this.str.compareTo(mystr.str);
	}
	
}