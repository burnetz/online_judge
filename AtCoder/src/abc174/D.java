package abc174;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		char input[] = sc.next().toCharArray();

		int l = 0;
		int r = n - 1;
		int count = 0;
		//そもそも色を変える必要がなく、交換だけでクリアできる。
		//右にある赤をできるだけ左の白と交換すればOK
		while(l < r){
			if(input[l] != 'W'){
				l++;
				continue;
			}

			if(input[r] != 'R'){
				r--;
				continue;
			}

			count++;
			l++;
			r--;
		}

		System.out.println(count);
	}
}