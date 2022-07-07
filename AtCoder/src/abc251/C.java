package abc251;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		int x[] = new int[n];
		//それぞれの数字がどこにあるかを記録する配列
		int index[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			x[i] = index[i] = i;
		}
		
		for(int i = 0; i < q; i++) {
			int tmp = sc.nextInt() - 1;
			int tmpIndex = index[tmp];
			int nextIndex;
			if(tmpIndex != n - 1) {
				nextIndex = tmpIndex + 1;
			}
			else {
				nextIndex = tmpIndex - 1;
			}
			
			int swapTmp = x[tmpIndex];
			x[tmpIndex] = x[nextIndex];
			index[x[tmpIndex]] = tmpIndex;
			x[nextIndex] = swapTmp;
			index[x[nextIndex]] = nextIndex;
						
			StringBuffer sb = new StringBuffer();
			
		}
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < n; i++) {
			sb.append((x[i] + 1) + " ");
		}
		System.out.println(sb);
	}
}
