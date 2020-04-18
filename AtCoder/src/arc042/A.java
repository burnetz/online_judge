package arc042;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		MyThread threads[] = new MyThread[n];
		
		for(int i = 0; i < n; i++) {
			threads[i] = new MyThread(i + 1);
		}
		
		//スレッドごとに最終更新時刻を残しておけば後で一括ソート可
		for(int i = 0; i < m; i++) {
			int index = sc.nextInt() - 1;
			
			threads[index].time = i;
		}
		
		Arrays.sort(threads);
		
		for(int i = 0; i < n; i++) {
			System.out.println(threads[i].id);
		}
	}
}

class MyThread implements Comparable<MyThread>{
	int id;
	int time = -1;
	
	public MyThread(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}
	@Override
	public int compareTo(MyThread th) {
		// TODO Auto-generated method stub
		return this.time == th.time ? this.id - th.id : th.time - this.time;
	}
	
	
}