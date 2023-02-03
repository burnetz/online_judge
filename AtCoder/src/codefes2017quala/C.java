package codefes2017quala;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int alpha[] = new int[26];
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		for(int i = 0; i < h; i++) {
			char[] str = sc.next().toCharArray();
			for(int j = 0; j < w; j++) {
				alpha[str[j] - 'a']++;
			}
		}
		
		//回文を作れるかどうかの判断は例えば長さが偶数の場合
		//同じ文字を2文字ずつ並べることが可能かどうかで判断できる。
		//行列で同じことをやるためにはまず2*2の領域に同じ文字を4文字ずつ配置できるかを考える。
		int currentAlpha = 0;
		for(int i = 0; i < h/2*2; i+= 2) {
			for(int j = 0; j < w/2*2; j += 2) {
				while(alpha[currentAlpha] < 4) {
					currentAlpha++;
					if(currentAlpha == 26) {
						
						System.out.println("No");
						return;
					}
				}
				alpha[currentAlpha] -= 4;
			}
		}
		
		//行および列が奇数のこともあるので
		//残った行・列について同じ文字を2文字ずつ置けるかを試す。
		currentAlpha = 0;
		if(h % 2 == 1) {
			for(int j = 0; j < w/2*2; j += 2) {
				while(alpha[currentAlpha] < 2) {
					currentAlpha++;
					if(currentAlpha == 26) {
						System.out.println("No");
						return;
					}
				}
				alpha[currentAlpha] -= 2;
			}
		}
		currentAlpha = 0;
		if(w % 2 == 1) {
			for(int j = 0; j < h/2*2; j += 2) {
				while(alpha[currentAlpha] < 2) {
					currentAlpha++;
					if(currentAlpha == 26) {
						System.out.println("No");
						return;
					}
				}
				alpha[currentAlpha] -= 2;
			}
		}
		
		System.out.println("Yes");
	}

}
