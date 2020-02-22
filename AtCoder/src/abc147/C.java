package abc147;

import java.util.Arrays;
import java.util.Scanner;

public class C {
	static final int UNKNOWN = 0;
	static final int HONEST = 1;
	static final int DISKIND = 2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int input[][] = new int[n][n];

		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();

			for(int j = 0; j < a; j++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt();

				if(y == 1) {
					input[i][x] = HONEST;
				}
				else {
					input[i][x] = DISKIND;
				}
			}
		}

		int result = 0;
		//全探索
		loop:		for(int i = 0; i < (int)Math.pow(2, n) ; i++) {

			int tmp = i;

			boolean isHonest[] = new boolean[n];

			for(int j = 0; j < n; j++) {
				if(tmp % 2 == 1) {
					isHonest[j] = true;
				}
				else {
					isHonest[j] = false;
				}

				tmp /= 2;
			}

			int num = i;
			int honestNum = 0;

			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {

					//正直者のkがjを不親切と指摘したが実際はjが正直→矛盾
					if(isHonest[k] && input[k][j] == DISKIND) {
						if(isHonest[j]) {
							continue loop;
						}
					}

					//正直者のkがjを正直と指摘したが実際はjは不親切→矛盾
					if(isHonest[k] && input[k][j] == HONEST) {

						if(!isHonest[j]) {
							continue loop;
						}
					}
				}

				num /= 2;
			}

			for(int j = 0; j < n; j++) {
				if(isHonest[j]) {
					honestNum++;
				}
			}

			result = Math.max(honestNum, result);
		}

		System.out.println(result);
	}

}
