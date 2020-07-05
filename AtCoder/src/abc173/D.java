package abc173;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];
		long sum = 0;
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			sum += a[i];
		}

		Arrays.sort(a);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer n1, Integer n2) {
				// TODO 自動生成されたメソッド・スタブ
				return n2 - n1;
			}
		});

		long result = a[n - 1];
		pq.add(a[n - 2]);
		pq.add(a[n - 2]);

		//ソート後にあるところにa[i]を挿入すれば幸福度がa[i]の区間が2つ発生する
		//幸福度が大きい区間に順に入れていけば良い
		for(int i = 2; i < n; i++){
			int tmp = pq.remove();
			result += tmp;

			pq.add(a[n - i - 1]);
			pq.add(a[n - i - 1]);
		}

		System.out.println(result);

	}
}