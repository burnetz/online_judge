package abc103;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();

		Demand[] demands = new Demand[m];
		for(int i = 0; i < m; i++){
			demands[i] = new Demand(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(demands);
		int result = 1;
		//ここは絶対落とす
		int bridgeID = demands[0].end - 1;

		for(int i = 1; i < m; i++){
			//既に区間が破壊されていなかった場合
			if(!demands[i].hasBridge(bridgeID)){
				result++;
				bridgeID = demands[i].end - 1;
			}
		}

		System.out.println(result);
	}


}

class Demand implements Comparable<Demand>{
	int begin;
	int end;

	Demand(int a, int b){
		this.begin = a;
		this.end = b;
	}

	@Override
	public int compareTo(Demand d) {
		return this.end - d.end;
	}

	public boolean hasBridge(int bid){
		return begin <= bid && end > bid;
	}
}
