package abc128;

import java.util.ArrayList;
import java.util.Scanner;

public class C {
	static Switch switches[];
	static Light lights[];

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		switches = new Switch[n];
		lights = new Light[m];

		for(int i = 0; i < n; i++){
			switches[i] = new Switch();
		}

		for(int i = 0; i < m; i++){
			int k = sc.nextInt();

			lights[i] = new Light();

			for(int j = 0; j < k; j++){
				lights[i].connected.add(switches[sc.nextInt() - 1]);
			}
		}

		for(int i = 0; i < m; i++){
			lights[i].p = sc.nextInt();
		}

		solve(0);

		System.out.println(result);
	}

	static int result = 0;
	//DFSで全探索する
	static void solve(int depth){
		if(depth == switches.length){
			for(int i = 0; i < lights.length ; i++){
				if(!lights[i].on()){
					return;
				}
			}
			result++;
			return;
		}

		switches[depth].on = false;
		solve(depth + 1);
		switches[depth].on = true;
		solve(depth + 1);
	}

}

class Light {
	ArrayList<Switch> connected;
	int p;

	Light(){
		this.p = 0;
		connected = new ArrayList<Switch>();
	}

	boolean on(){
		int count = 0;

		for(int i = 0; i < connected.size(); i++){
			if(connected.get(i).on){
				count++;
			}
		}

		return count%2 == p;
	}
}

class Switch {
	boolean on = false;
}