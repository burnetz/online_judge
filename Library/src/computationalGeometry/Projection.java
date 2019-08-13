package computationalGeometry;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Projection {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");
		double px1 = Double.parseDouble(tmpArray[0]);
		double py1 = Double.parseDouble(tmpArray[1]);
		double px2 = Double.parseDouble(tmpArray[2]);
		double py2 = Double.parseDouble(tmpArray[3]);

		Point2D p1 = new Point2D.Double(px1, py1);
		Point2D p2 = new Point2D.Double(px2, py2);

		int q = Integer.parseInt(br.readLine());

		for(int i = 0; i < q; i++){
			tmpArray = br.readLine().split(" ");
			double x = Double.parseDouble(tmpArray[0]);
			double y = Double.parseDouble(tmpArray[1]);

			Point2D p = new Point2D.Double(x,y);

			Point2D result = calcProjection(p, p1, p2);
			System.out.printf("%.10f %.10f\n", result.getX(), result.getY());
		}

	}

	static Point2D calcProjection(Point2D p, Point2D p1, Point2D p2){
		double theta = Math.PI/2;

		//直線のなす角が90度ではないときはここで計算
		if(p1.getX() != p2.getX()){
			theta = Math.atan((p1.getY() - p2.getY()) / (p1.getX() - p2.getX()));
		}


		AffineTransform affine = AffineTransform.getTranslateInstance(p1.getX(), p1.getY());
		affine.concatenate(AffineTransform.getRotateInstance(theta));
		//y座標を0にする
		affine.concatenate(new AffineTransform(1, 0, 0, 0, 0, 0));
		affine.concatenate(AffineTransform.getRotateInstance(-theta));
		affine.concatenate(AffineTransform.getTranslateInstance(-p1.getX(), -p1.getY()));

		Point2D result = new Point2D.Double();
		result = affine.transform(p, result);

		return result;

	}

}
