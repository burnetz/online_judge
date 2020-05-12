package abc075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int n = Integer.parseInt(tmpArray[0]);
		int K = Integer.parseInt(tmpArray[1]);

		Point[] points = new Point[n];
		long x[] = new long[n];
		long y[] = new long[n];

		for(int i = 0; i < n; i++){
			tmpArray = br.readLine().split(" ");
			points[i] = new Point(Long.parseLong(tmpArray[0]), Long.parseLong(tmpArray[1]));
			x[i] = Long.parseLong(tmpArray[0]);
			y[i] = Long.parseLong(tmpArray[1]);
		}

		Arrays.sort(x);
		Arrays.sort(y);

		//長方形を探索
		long minArea = Long.MAX_VALUE;

		//ガチの全探索
		for(int i = 0; i < n - 1; i++){
			for(int j = i + 1; j < n; j++){
				for(int k = 0; k < n - 1; k++){
					for(int l = 0; l < n; l++){
						long left = x[i];
						long right = x[j];
						long bottom = y[k];
						long top = y[l];

						int count = pointInRect(left, right, top, bottom, points);
						if(count >= K){
							long tmpArea = (right - left)*(top - bottom);

							if(tmpArea < minArea){
								minArea = tmpArea;
							}
						}
					}
				}
			}
		}

		System.out.println(minArea);
	}

	static int pointInRect(long left, long right, long top, long bottom, Point[] points){
		int result = 0;


		for(int i = 0; i < points.length ; i++){
			if(points[i].x >= left && points[i].x <= right
					&& points[i].y >= bottom && points[i].y <= top ){
				result++;
			}
		}

		return result;
	}

	static long minY(Point[] points, int start, int end){
		long min = points[start].y;

		for(int i = start + 1; i <= end; i++){
			if(min > points[i].y){
				min = points[i].y;
			}
		}

		return min;
	}

	static long maxY(Point[] points, int start, int end){
		long max = points[start].y;

		for(int i = start + 1; i <= end; i++){
			if(max < points[i].y){
				max = points[i].y;
			}
		}

		return max;
	}

}

class Point implements Comparable<Point>{

	long x;
	long y;

	public Point(long x, long y){
		this.x = x;
		this.y = y;
	}

	public int compareTo(Point p) {
		// TODO Auto-generated method stub
		if(this.x > p.x){
			return 1;
		}
		else if(this.x == p.x){
			return 0;
		}
		else {
			return -1;
		}
	}

}