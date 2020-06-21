package abc019;

import java.util.Scanner;

public class D {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		//頂点1から最も遠い頂点vを探す
		int maxIndex = 0;
		int maxLen = 0;
		for(int i = 1; i < n; i++){
			System.out.println("? 1 "+(i + 1));
			int cost = sc.nextInt();

			if(maxLen < cost){
				maxIndex = i;
				maxLen = cost;
			}
		}

		//頂点vから最も遠い頂点までの距離が直径
		long max = 0;
		for(int i = 0; i < n ; i++){
			System.out.println("? "+(maxIndex + 1)+" "+(i + 1));
			int cost = sc.nextInt();;

			if(max < cost){
				max = cost;
			}
		}

		System.out.println("! "+max);
	}

}