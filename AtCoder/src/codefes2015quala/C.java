package codefes2015quala;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long t = sc.nextLong();

		Task tasks[] = new Task[n];
		long sumA = 0;

		for(int i = 0; i < n; i++){
			tasks[i] = new Task(sc.nextInt(), sc.nextInt());
			sumA += tasks[i].a;
		}

		//bとaの差が大きい順に並べるのが最も効率が良い
		Arrays.sort(tasks);

		if(sumA <= t){
			System.out.println(0);
			return ;
		}

		long diff = sumA - t;

		for(int i = 0; i < n; i++){
			diff -= tasks[i].a - tasks[i].b;

			if(diff <= 0){
				System.out.println(i + 1);
				return;
			}
		}

		System.out.println(-1);
	}

}

class Task implements Comparable<Task>{
	int a;
	int b;

	Task(int a, int b){
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Task t) {
		// TODO 自動生成されたメソッド・スタブ
		int diff1 = this.a - this.b;
		int diff2 = t.a - t.b;
		return diff2 - diff1;
	}
}