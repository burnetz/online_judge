package arc092;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Point red[] = new Point[n];
		for(int i = 0; i < n; i++){
			red[i] = new Point(sc.nextInt(), sc.nextInt());
		}

		Point blue[] = new Point[n];
		for(int i = 0; i < n; i++){
			blue[i] = new Point(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(red);
		Arrays.sort(blue);

		int result = 0;

		//各青点から見て、ペアにすることが可能な赤点のうち
		//最もy座標が高いものを選び続ける。
		//Nが小さいのでデータ構造の工夫は不要
		boolean used[] = new boolean[n];
		for(int i = 0; i < n; i++){
			int maxIndex = -1;
			int maxY = -1;
			for(int j = 0; j < n; j++){
				if(red[j].x > blue[i].x){
					break;
				}

				if(!used[j] && red[j].y < blue[i].y && red[j].y > maxY){
					maxY = red[j].y;
					maxIndex = j;
				}
			}

			if(maxIndex >= 0){
				used[maxIndex] = true;
				result++;

			}
		}

		System.out.println(result);
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
		return this.x - p.x;
	}


}