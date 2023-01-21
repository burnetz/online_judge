package arc125;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int s[] = new int[n];
		int t[] = new int[m];

		int zeroS = 0;
		int oneS = 0;
		int zeroT = 0;
		int oneT = 0;
		for(int i = 0; i < n; i++){
			s[i] = sc.nextInt();

			if(s[i] == 0){
				zeroS++;
			}
			else{
				oneS++;
			}
		}

		for(int i = 0; i < m; i++){
			t[i] = sc.nextInt();

			if(t[i] == 0){
				zeroT++;
			}
			else{
				oneT++;
			}
		}

		if((zeroT != 0 && zeroS == 0) || (oneT != 0 && oneS == 0)){
			System.out.println(-1);
			return;
		}

		//a_1と異なる文字にするための移動距離
		int flip = Integer.MAX_VALUE;

		for(int i = 1; i < n; i++){
			if(s[0] != s[i]){
				flip = i;
				break;
			}
		}

		for(int i = n - 1; i >= 1; i--){
			if(s[0] != s[i]){
				flip = Math.min(flip, n - i);
				break;
			}
		}

		long result = 1;
		boolean firstFlip = true;

		if(s[0] != t[0]){
			result += flip;
			firstFlip = false;
		}

		//ある程度飛ぶ可能性があるのは最初に文字の種類が変わるときだけ。
		//そこからは最適な方法であれば1ずつの移動で十分
		for(int i = 1; i < m; i++){
			if(t[i] != t[i - 1]){
				if(firstFlip){
					result += flip;
					firstFlip = false;
				}
				else{
					result++;
				}
			}
			result++;
		}
		System.out.println(result);
	}
}