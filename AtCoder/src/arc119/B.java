package arc119;

import java.util.Scanner;
import java.util.Vector;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		
		char[] s = sc.next().toCharArray();
		char[] t = sc.next().toCharArray();
		
		Vector<Integer> zeroS = new Vector<Integer>();
		Vector<Integer> zeroT = new Vector<Integer>();
		
		for(int i = 0; i < n; i++) {
			if(s[i] == '0') {
				zeroS.add(i);
			}
			if(t[i] == '0') {
				zeroT.add(i);
			}
		}
		//0の個数が違う場合は明らかに無理。
		//それ以外の場合は最悪O(N^2)かければ必ず可能
		if(zeroS.size() != zeroT.size()) {
			System.out.println(-1);
			return;
		}
		
		int count = 0;
		
		//もともとSとTで同じ場所にある0は移動させる必要がない。
		//それ以外の0は左右のどちらに移動するとしても各1回で正しい場所に移動できる。
		for(int i = 0; i < zeroS.size() ; i++) {
			int a = zeroS.get(i);
			int b = zeroT.get(i);
			if(a != b) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}