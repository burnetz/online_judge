package arc006;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Pack[] packs = new Pack[n];
		for(int i = 0; i < n; i++){
			int w = sc.nextInt();

			packs[i] = new Pack(w, i);
		}

		//まずはあまり考えずに上が軽くなるように全部積んでいく
		Arrays.sort(packs);

		boolean[] used = new boolean[n];

		int count = 0;
		//タイムスタンプ上矛盾がなければそのような山を作れるということ
		//既に重さ順に並んでいるので、タイムスタンプについて最長増加列を考える
		//今回はO(N^2)でも十分間に合う
		for(int i = 0; i < n; i++){
			if(used[i]){
				continue;
			}

			used[i] = true;
			int tmpTime = packs[i].time;
			for(int j = i + 1; j < n; j++){
				if(used[j]){
					continue;
				}

				if(tmpTime > packs[j].time){
					used[j] = true;
					tmpTime = packs[j].time;
				}
			}

			count++;
		}

		System.out.println(count);
	}
}

class Pack implements Comparable<Pack>{
	int weigh;
	int time;

	Pack(int weigh, int time){
		this.weigh = weigh;
		this.time = time;
	}

	@Override
	public int compareTo(Pack p) {
		return this.weigh == p.weigh ? p.time - this.time : this.weigh - p.weigh;
	}


}