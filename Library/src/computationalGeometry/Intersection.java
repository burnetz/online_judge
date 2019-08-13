package computationalGeometry;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Intersection {

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

			//交差判定は標準のメソッドで可
			if(lines[0].intersectsLine(lines[1])){
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
	}

}
