package abc258;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		String str = sc.next();
		int offset = 0;
		
		for(int i = 0; i < q; i++) {
			int type = sc.nextInt();
			int x = sc.nextInt();
			
			//実際に文字を移動させなくてもオフセットだけ変えればよい
			if(type == 1) {
				offset += n - x;
				offset %= n;
			}
			else {
				System.out.println(str.charAt((offset + x - 1) % n));
			}
		}
	}
}
