package abc047;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt();
		int h = sc.nextInt();
		int n = sc.nextInt();

		boolean blackC[] = new boolean[h];
		boolean blackR[] = new boolean[w];

		for(int i = 0; i < n; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			int a = sc.nextInt();

			switch(a){
			case 1:
				for(int j = 0; j < x; j++){
					blackR[j] = true;
				}
				break;
			case 2:
				for(int j = x; j < w; j++){
					blackR[j] = true;
				}
				break;
			case 3:
				for(int j = 0; j < y; j++){
					blackC[j] = true;
				}
				break;
			case 4:
				for(int j = y; j < h; j++){
					blackC[j] = true;
				}
				break;

			}
		}

		int whiteC = 0;
		for(int i = 0; i < h; i++){
			if(!blackC[i]){
				whiteC++;
			}
		}

		int whiteR = 0;
		for(int i = 0; i < w; i++){
			if(!blackR[i]){
				whiteR++;
			}
		}

		System.out.println(whiteC*whiteR);
    }
}