package abc137;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class D {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int n = Integer.parseInt(tmpArray[0]);
		int m = Integer.parseInt(tmpArray[1]);

		Job jobs[] = new Job[n];

		for(int i = 0; i < n; i++){
			tmpArray = br.readLine().split(" ");
			int a = Integer.parseInt(tmpArray[0]);
			int b = Integer.parseInt(tmpArray[1]);
			jobs[i] = new Job(a, b);
		}

		//すぐにお金がもらえる順にソート
		Arrays.sort(jobs);

		int currentIndex = 0;
		long result = 0;
		//pqでは給料が高い順
		PriorityQueue<Job> pq = new PriorityQueue<Job>(new Comparator<Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				return o2.salary - o1.salary;
			}
		});
		//m-1日目から今日の順で請ける仕事を決めるのが最適
		//そのときにm日目までにお給料がもらえるものだけを見る
		for(int i = 1; i <= m; i++){

			//お給料がm日目に間に合う仕事をpqに入れていく
			//先頭はそれらの仕事の中で最も給料が良いものになる
			for(; currentIndex < n; currentIndex++){
				if(jobs[currentIndex].date > i){
					break;
				}
				else {
					pq.add(jobs[currentIndex]);
				}
			}

			Job top = pq.poll();
			if(top != null){
				result += top.salary;
			}
		}

		System.out.println(result);
	}

}

class Job implements Comparable<Job>{
	int date;
	int salary;

	Job (int date, int salary){
		this.date = date;
		this.salary = salary;
	}

	@Override
	public int compareTo(Job j) {
		return  this.date == j.date ? (j.salary - this.salary) : this.date - j.date;
	}


}