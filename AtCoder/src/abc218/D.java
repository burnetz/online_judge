package abc218;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int x[] = new int[n];
		int y[] = new int[n];

		int xcopy[] = new int[n];
		int ycopy[] = new int[n];

		for(int i = 0; i < n; i++){
			x[i] = xcopy[i] = sc.nextInt();
			y[i] = ycopy[i] = sc.nextInt();
		}

		Arrays.sort(xcopy);
		Arrays.sort(ycopy);

		//座標圧縮
		HashMap<Integer, Integer> xMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> yMap = new HashMap<Integer, Integer>();

		int xIndex = 0;
		int yIndex = 0;
		for(int i = 0; i < n; i++){
			if(!xMap.containsKey(xcopy[i])){
				xMap.put(xcopy[i], xIndex);
				xIndex++;
			}
			if(!yMap.containsKey(ycopy[i])){
				yMap.put(ycopy[i], yIndex);
				yIndex++;
			}
		}

		//圧縮済みの座標を元に点の有無、各点の座標を管理する
		boolean matrix[][] = new boolean[2001][2001];
		Point points[] = new Point[n];
		for(int i = 0; i < n; i++){
			int newX = xMap.get(x[i]);
			int newY = yMap.get(y[i]);

			matrix[newY][newX] = true;
			points[i] = new Point(newX, newY);
		}
		//y座標順。y座標が等しければx座標順。
		Arrays.sort(points);

		long count = 0;
		//最悪O(N^3)程度あるが枝刈りにより一応間に合う。
		for(int i = 0; i < n - 3; i++){
			for(int j = i + 1; j < n - 2; j++){
				//枝刈り。ソート済みなのでもしここでy座標が異なるならもうx軸に平行にはできない。
				if(points[i].y != points[j].y){
					break;
				}

				//3つ目の点が決まれば条件を満たす長方形を作れるか判断可
				for(int k = points[i].y + 1; k < matrix.length; k++){
					int x1 = points[i].x;
					int x2 = points[j].x;
					int y2 = k;

					if(matrix[y2][x1] && matrix[y2][x2]){
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}

}

class Point implements Comparable<Point>{
	int x;
	int y;

	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Point p) {
		// TODO 自動生成されたメソッド・スタブ
		return this.y == p.y ? this.x - p.x : this.y - p.y;
	}

}