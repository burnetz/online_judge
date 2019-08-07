package computationalGeometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParallelOrthogonal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int q = Integer.parseInt(br.readLine());
		for(int i = 0; i < q; i++){
			String[] tmpArray = br.readLine().split(" ");

			int px1 = Integer.parseInt(tmpArray[0]);
			int py1 = Integer.parseInt(tmpArray[1]);
			int px2 = Integer.parseInt(tmpArray[2]);
			int py2 = Integer.parseInt(tmpArray[3]);
			int px3 = Integer.parseInt(tmpArray[4]);
			int py3 = Integer.parseInt(tmpArray[5]);
			int px4 = Integer.parseInt(tmpArray[6]);
			int py4 = Integer.parseInt(tmpArray[7]);

			if(isParallel(px1, py1, px2, py2, px3, py3, px4, py4)){
				System.out.println(2);
			}
			else if(isOrthogonal(px1, py1, px2, py2, px3, py3, px4, py4)){
				System.out.println(1);
			}
			else{
				System.out.println(0);
			}
		}
	}

	static final double EPS = 0.0000001;

	//2直線が平行かどうかを判定する
	static boolean isParallel(double px1, double py1, double px2, double py2, double px3, double py3, double px4, double py4){
		double vx1 = px2 - px1;
		double vy1 = py2 - py1;
		double vx2 = px4 - px3;
		double vy2 = py4 - py3;

		if(Math.abs(vx1*vx2) < EPS){
			if(Math.abs(vx1 + vx2) < EPS){
				return true;
			}
			else {
				return false;
			}
		}

		else if(Math.abs(vy1/vx1 - vy2/vx2) < EPS){
			return true;
		}
		else {
			return false;
		}

	}

	//2直線が直交しているかどうかを判定する
	static boolean isOrthogonal(double px1, double py1, double px2, double py2, double px3, double py3, double px4, double py4){
		double vx1 = px2 - px1;
		double vy1 = py2 - py1;
		double vx2 = px4 - px3;
		double vy2 = py4 - py3;

		double innerProduct = vx1*vx2 + vy1*vy2;

		if(Math.abs(innerProduct) < EPS){
			return true;
		}
		else {
			return false;
		}
	}

}
