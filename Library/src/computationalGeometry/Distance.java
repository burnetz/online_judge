package computationalGeometry;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Distance {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());


		for(int i = 0; i < n; i++){
			String[] tmpArray = br.readLine().split(" ");

			Point2D[] points = new Point2D[4];

			for(int j = 0; j < 4; j++){
				int x = Integer.parseInt(tmpArray[j*2]);
				int y = Integer.parseInt(tmpArray[j*2 + 1]);

				points[j] = new Point2D.Double(x, y);
			}

			Line2D[] lines = new Line2D[2];
			for(int j = 0; j < 2; j++){
				lines[j] = new Line2D.Double(points[j*2], points[j*2 + 1]);
			}

			double result = distance(lines[0], lines[1]);

			System.out.printf("%.8f\n", result);
		}
	}

	static double distance(Line2D l1, Line2D l2){
		//線分が交わっていれば距離は0（この分岐いらないかも）
		if(l1.intersectsLine(l2)){
			return 0;
		}

		//一方の線分ともう一方の端点との距離を測ればいずれかは最短になる
		else {
			return Math.min(Math.min(l2.ptSegDist(l1.getP1()), l2.ptSegDist(l1.getP2())), Math.min(l1.ptSegDist(l2.getP1()), l1.ptSegDist(l2.getP2())));
		}
	}

}
