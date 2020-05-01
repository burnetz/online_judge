package abc116;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int h[] = new int[n];

		for(int i = 0; i < n; i++){
			h[i] = sc.nextInt();
		}

		//左からできるだけ長い区間水やりをすることを考える
		//NもHも小さいので愚直な方法でOK
		int count = 0;;
		while(true){
			//0じゃないところを探す
			int start = -1;
			for(int i = 0; i < n; i++){
				if(h[i] != 0){
					start = i;
					break;
				}
			}

			if(start < 0){
				break;
			}

			count++;

			for(int i = start; i < n; i++){
				if(h[i] == 0){
					break;
				}

				h[i]--;
			}
		}

		System.out.println(count);
	}
}
