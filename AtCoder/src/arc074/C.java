package arc074;

import java.util.Scanner;

public class C {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long h = sc.nextInt();
		long w = sc.nextInt();

		//この場合は3等分が可能
		if(h%3 == 0 || w%3 == 0){
			System.out.println(0);
			return;
		}

		long result = Long.MAX_VALUE;

		//最初の長方形を決めるステップについては全パターン試す時間がある
		for(int i = 1; i <= h; i++){
			long area1 = (long)i*w;

			long h2 = h - i;
			long w2 = w;

			long area2;

			//こちらは残った方の長方形がちょうど2分割可能な場合
			if(h2 % 2 == 0 || w2 % 2 == 0){
				area2 = h2*w2/2;
			}
			//2分割後のサイズが一致しない場合は差が小さくなる分け方をする
			else {
				area2 = Math.max(h2, w2)/2*Math.min(h2, w2);
			}
			long area3 = h*w - area1 - area2;

			long maxArea = Math.max(area1, Math.max(area2, area3));
			long minArea = Math.min(area1, Math.min(area2, area3));

			result = Math.min(maxArea - minArea, result);
		}

		for(int i = 1; i <= w; i++){
			long area1 = (long)i*h;

			long h2 = h;
			long w2 = w - i;

			long area2;
			if(h2 % 2 == 0 || w2 % 2 == 0){
				area2 = h2*w2/2;
			}
			else {
				area2 = Math.max(h2, w2)/2*Math.min(h2, w2);
			}
			long area3 = h*w - area1 - area2;

			long maxArea = Math.max(area1, Math.max(area2, area3));
			long minArea = Math.min(area1, Math.min(area2, area3));

			result = Math.min(maxArea - minArea, result);
		}


		System.out.println(result);
	}

}
