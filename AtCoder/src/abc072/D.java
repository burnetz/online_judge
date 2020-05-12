package abc072;

import java.util.Scanner;

public class D {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int p[] = new int[n];
		for(int i = 0; i < n; i++){
			p[i] = sc.nextInt() - 1;
		}

		int count = 0;
		//最後の数字の入れ替えが必要なパターンは下のループではできないので別に処理
		if(p[n - 1] == n - 1){
			int tmp = p[n - 2];
			p[n - 2] = p[n - 1];
			p[n - 1] = tmp;
			count++;

		}

		//左から見ていき、i番目の数字がiなら右とスワップすればよい
		for(int i = 0; i < n - 1; i++){
			if(p[i] == i){
				int tmp = p[i];
				p[i] = p[i + 1];
				p[i + 1] = tmp;
				count++;
			}
		}

		System.out.println(count);
	}

}