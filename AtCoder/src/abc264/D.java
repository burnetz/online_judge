package abc264;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		char[] str = sc.next().toCharArray();
		char[] atcoder = "atcoder".toCharArray();
		int count = 0;
		//必要な文字を探してひたすらスワップしていくのが最短
		for(int i = 0; i < atcoder.length; i++) {
			char target = atcoder[i];
			
			int index = 0;
			for(int j = 0; j < str.length; j++) {
				if(str[j] == target) {
					index = j;
					break;
				}
			}
			
			for(int j = index; j >= i + 1; j--) {
				char tmp = str[j];
				str[j] = str[j - 1];
				str[j - 1] = tmp;
				count++;
			}
		}
		
		System.out.println(count);
	}
}