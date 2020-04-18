package arc043;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int s[] = new int[n];
		
		double max = 0;
		double min = Integer.MAX_VALUE;
		double sum = 0;
		for(int i = 0; i < n; i++) {
			s[i] = sc.nextInt();
			
			max = Math.max(s[i], max);
			min = Math.min(s[i], min);
			sum += s[i];
		}
		
		//最大値と最小値に差がないときはどうやっても引き延ばせない
		//逆に言えばそれ以外のときは必ず変換が存在する
		if(max == min) {
			System.out.println(-1);
			return;
		}
		
		double p = (double)b/(max - min);
		double q = a - p*sum/n;

		System.out.println(p + " "+q);
	}
}