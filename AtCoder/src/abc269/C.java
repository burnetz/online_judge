package abc269;

import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		
		Vector<Long> masks = new Vector<Long>();
		
		long tmpMask = 1;
		for(int i = 0; i < 64 && n >= tmpMask; i++) {
			if((n & tmpMask) != 0) {
				masks.add(tmpMask);
			}
			
			tmpMask <<= 1;
		}
		
		Vector<Long> result = new Vector<Long>();
		for(int i = 0; i < Math.pow(2, masks.size()) ; i++) {
			long tmpResult = 0;
			int tmp = 1;
			for(int j = 0; j < masks.size(); j++) {
				if((i & tmp) != 0) {
					tmpResult |= masks.get(j);
				}
				
				tmp <<= 1;
			}
			
			result.add(tmpResult);
		}
		
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		
	}
	
}