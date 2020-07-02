package agc029;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();
		int n = str.length;

		long result = 0;
		int prevBlack = n;

		if(str[n - 1] == 'B'){
			prevBlack = n - 1;
		}

		//右から見ていってBを行けるところまで右に詰め続けるのが最善
		//2重ループにしなくても直前に見た黒の場所を覚えておけば計算可
		for(int i = n - 2; i >= 0; i--){
			if(str[i] == 'B' && str[i + 1] == 'W'){
				result += prevBlack - i - 1;
				prevBlack--;
				str[i] = 'W';
			}
			else if(str[i] == 'B'){
				prevBlack = i;
			}
		}

		System.out.println(result);
	}
}
