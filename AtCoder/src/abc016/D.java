package abc016;

import java.awt.geom.Line2D;
import java.util.Scanner;

public class D {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		Line2D.Double line = new Line2D.Double(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());

		int n = sc.nextInt();

		int x[] = new int[n + 1];
		int y[] = new int[n + 1];

		for(int i = 0; i < n; i++){
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		x[n] = x[0];
		y[n] = y[0];

		int cross = 0;

		for(int i = 0; i < n; i++){
			if(line.intersectsLine(x[i], y[i], x[i + 1], y[i + 1])){
				cross++;
			}
		}

		//多角形の周の線分と交わった回数は必ず偶数になる
		//2回交わるたびに切れ端が1つ増える
		System.out.println(cross/2 + 1);
	}

}