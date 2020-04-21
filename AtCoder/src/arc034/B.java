package arc034;

import java.util.ArrayList;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();

		ArrayList<Long> list = new ArrayList<Long>();
		//f(x)が取りうる値はせいぜい9*桁数までなので
		//nが大きくなれば初期値も合わせて大きくなり回す数は少なくてよい
		for(long i = Math.max(1, n - 9*20); i <= n; i++){
			if(i + func(i) == n){
				list.add(i);
			}
		}

		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}

	static int func(long n){
		int result = 0;

		while(n > 0){
			result += n % 10;
			n /= 10;
		}

		return result;
	}
}