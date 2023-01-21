package abc238;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		
loop:		for(int i = 0; i < t; i++) {
			long a = sc.nextLong();
			long s = sc.nextLong();
			long mask = 1;
			boolean cin = false;
			
			//And, Sum, 下のケタからの繰り上がりで2つの数字x,yの組み合わせを絞れる。
			//x,yのあるビットのうち片方だけが1となる場合はどちらを選んでも支障はない。
			for(int j = 0; j <= 60; j++, mask <<= 1) {
				boolean bitAnd = (a & mask) != 0;
				boolean bitSum = (s & mask) != 0;
				
				if(!cin && !bitAnd && !bitSum) {
					
				}
				else if(!cin && !bitAnd && bitSum) {
					
				}
				else if(!cin && bitAnd && !bitSum) {
					cin = true;
				}
				else if(cin && !bitAnd && !bitSum) {
					cin = true;
				}
				else if(cin && !bitAnd && bitSum) {
					cin = false;
				}
				else if(cin && bitAnd && bitSum) {
					cin = true;
				}
				else {
					System.out.println("No");
					continue loop;
				}
			}
			
			//最後まで桁上がりを消化できなかった場合
			if(cin) {
				System.out.println("No");
			}
			else {
				System.out.println("Yes");
			}
		}
	}
}