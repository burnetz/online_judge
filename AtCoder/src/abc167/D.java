package abc167;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long k = sc.nextLong();

		int a[] = new int[n];
		int time[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt() - 1;
		}

		Arrays.fill(time, -1);

		//必ずどこかでループに入るはずなので、ループの始点、長さを調べる
		time[0] = 0;
		int currentTime = 0;
		int loopBegin = -1;
		int loopLength = -1;
		int next = a[0];
		while(true){
			currentTime++;
			if(time[next] == -1){
				time[next] = currentTime;
				next = a[next];
			}
			else {
				loopBegin = next;
				loopLength = currentTime - time[next];
				break;
			}
		}

		int loopBeginTime = time[loopBegin];

		//ループ突入前ならタイムスタンプがkと一致するものを探すだけ
		if(k <= loopBeginTime){
			for(int i = 0; i < n; i++){
				if(time[i] == k){
					System.out.println(i + 1);
					return;
				}
			}
		}
		else {
			//ループ突入前と周回分をkから除去
			k -= loopBeginTime;
			k %= loopLength;

			//その結果ちょうどループの始点となる場合
			if(k == 0){
				System.out.println(loopBegin + 1);
			}
			//それ以外の場合は実際にループ内を走査。最悪でもn回なので間に合う
			else {
				next = a[loopBegin];
				for(int i = 0; i < k - 1; i++){
					next = a[next];
				}

				System.out.println(next + 1);
			}
		}

	}

}
