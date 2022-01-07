package arc130;

import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		int c = sc.nextInt();
		int q = sc.nextInt();
		
		long painted[] = new long[c + 1];
		HashSet<Integer> row = new HashSet<Integer>();
		HashSet<Integer> col = new HashSet<Integer>();
		
		int tmpT[] = new int[q];
		int tmpN[] = new int[q];
		int tmpC[] = new int[q];
		for(int i = 0; i < q; i++) {
			tmpT[i] = sc.nextInt();
			tmpN[i] = sc.nextInt();
			tmpC[i] = sc.nextInt();
		}
		//例えば最後に染めたところは途中のクエリの影響を受けないので
		//逆から考えた方が楽。
		for(int i = q - 1; i >= 0; i--) {
			int mode = tmpT[i];
			int n = tmpN[i];
			int color = tmpC[i];
			
			if(mode == 1) {
				//行の塗りについては将来塗りが発生する列の分だけ塗れる数が減る。
				if(!row.contains(n)) {
					row.add(n);
					painted[color] += w - col.size();
				}
			}
			else {
				if(!col.contains(n)) {
					col.add(n);
					painted[color] += h - row.size();
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i <= c; i++) {
			if(i != 1) {
				sb.append(" ");
			}
			sb.append(painted[i]);
		}
		
		System.out.println(sb);
	}
}