package agc016;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] input = sc.next().toCharArray();

		int result = Integer.MAX_VALUE;
		//途中で対象の文字を変える意味がないのでとりあえず26パターン全部試してしまえば良い
		for(char c = 'a' ; c < 'z'; c++){
			int n = input.length;

			char str[] = Arrays.copyOf(input, n);
			while(true){
				boolean single = true;
				for(int i = 0; i < n; i++){
					if(i != 0 && str[i] != str[i - 1]){
						single = false;
					}
				}

				if(single){
					result = Math.min(result,str.length - n);
					break;
				}

				for(int i = 0; i < n - 1; i++){
					if(str[i + 1] == c){
						str[i] = c;
					}
				}

				n--;
			}
		}
		System.out.println(result);
	}
}
