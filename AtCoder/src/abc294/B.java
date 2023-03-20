package abc294;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				int tmp = sc.nextInt();
				
				if(tmp == 0) {
					System.out.print(".");
				}
				else {
					System.out.print((char)(tmp + 'A' - 1));
				}
			}
			System.out.println();
		}
	}		
}