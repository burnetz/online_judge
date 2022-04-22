package abc248;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		//まともに数えている時間はないので平方分割を使う
		int sectionSize = 512;
		int count[][] = new int[n + 1][sectionSize];
		
		for(int i = 0; i < n; i++) {
			int sectionId = i / sectionSize;
			
			count[a[i]][sectionId]++;
		}
		
		int q = sc.nextInt();
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < q; i++) {
			int l = sc.nextInt() - 1;
			int r = sc.nextInt() - 1;
			int x = sc.nextInt();
			
			int sectionL = l / sectionSize;
			int sectionR = r / sectionSize;
			
			int result = 0;
			for(int j = 0; j < sectionSize; j++) {
				if(j < sectionL) {
					continue;
				}
				
				if(j > sectionR) {
					continue;
				}
				
				if(count[x][j] == 0) {
					continue;
				}
				
				if(sectionL < j && sectionR > j) {
					result += count[x][j];
				}
				//左端がセクション内にあるときは地道に数える
				else if(sectionL <= j) {
					for(int k = Math.max(l, j*sectionSize); k <= Math.min(r, (j + 1)*sectionSize - 1); k++) {
						if(a[k] == x) {
							result++;
						}
					}
				}
			}
			
			sb.append(result + "\n");
		}
		System.out.print(sb);
	}
}