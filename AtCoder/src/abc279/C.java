package abc279;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt();
		int h = sc.nextInt();
		
		char[][] mat1 = new char[h][w];
		char[][] mat2 = new char[h][w];
		
		for(int i = 0; i < w; i++) {
			String tmp = sc.next();
			for(int j = 0; j < h; j++) {
//				System.out.println("i " + i + " j " + j);
				mat1[j][i] = tmp.charAt(j);
			}
		}
		for(int i = 0; i < w; i++) {
			String tmp = sc.next();
			for(int j = 0; j < h; j++) {
				mat2[j][i] = tmp.charAt(j);
			}
		}
		
		String str1[] = new String[h];
		String str2[] = new String[h];

		for(int i = 0; i < h; i++) {
			str1[i] = new String(mat1[i]);
			str2[i] = new String(mat2[i]);
		}
		
		Arrays.sort(str1);
		Arrays.sort(str2);
		
		for(int i = 0; i < h; i++) {
//			System.out.println(str1[i] + " " + str2[i]);
			if(!str1[i].equals(str2[i])) {
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
	}
}

