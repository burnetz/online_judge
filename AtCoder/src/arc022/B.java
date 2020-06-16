package arc022;

import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		int left = 0;
		int right = 1;

		int maxLen = 1;
		//登場した色はHashSetで覚えておくと効率が良い
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(a[0]);
		//尺取法ならO(N)で解くことができる
		while(right < n){
			if(set.contains(a[right])){
				set.remove(a[left]);
				left++;
			}
			else{
				set.add(a[right]);
				right++;
			}

			maxLen = Math.max(maxLen, right - left);
		}

		System.out.println(maxLen);
	}
}
