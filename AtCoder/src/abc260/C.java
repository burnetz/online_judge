package abc260;

import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		long red = 1;
		long blue = 0;
		
		//各レベルについてまず全ての赤で操作1を行い
		//次に全ての青で操作2を行うのが最も効率がよい。
		for(int i = 0; i < n - 1; i++) {
			blue += red*x;
			red += blue;
			blue *= y;
		}
		
		System.out.println(blue);
	}
}