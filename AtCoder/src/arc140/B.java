package arc140;

import java.util.ArrayList;
import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String str = sc.next();
		
		//A...ARC....Cを1つのブロックとする。
		//今回の問題ではブロックどうしが相互に干渉することはない。
		//ただし前から処理するだけでは駄目。
		//偶数回目の処理ではなるべくあと1回しか処理できないものを優先する。
		ArrayList<Block> list = new ArrayList<Block>();
		ArrayList<Block> oneList = new ArrayList<Block>();
		for(int i = 1; i < n - 1; i++) {
			if(str.charAt(i) != 'R') {
				continue;
			}
			
			Block tmpBlock = new Block();
			
			int tmpA = 0;
			
			for(int j = i - 1; j >= 0 && str.charAt(j) == 'A' ; j--) {
				tmpA++;
			}

			int tmpC = 0;
			
			for(int j = i + 1; j < n && str.charAt(j) == 'C' ; j++) {
				tmpC++;
			}
			
			tmpBlock.a = tmpA;
			tmpBlock.c = tmpC;
			
			if(Math.min(tmpA, tmpC) == 0) {
				continue;
			}
			else if(Math.min(tmpA, tmpC) == 1) {
				oneList.add(tmpBlock);
			}
			else {
				list.add(tmpBlock);
			}
		}
		
		int count = 0;
		
		while(!oneList.isEmpty() || !list.isEmpty()) {
			if(count%2 == 0) {
				if(!list.isEmpty()) {
					Block tmpBlock = list.get(0);
					if(tmpBlock.dec() == 1) {
						list.remove(0);
						oneList.add(tmpBlock);
					}
				}
				else {
					oneList.remove(0);
				}
			}
			else {
				if(!oneList.isEmpty()) {
					oneList.remove(0);
				}
				else {
					list.remove(0);
				}
			}
			
			count++;
		}
		
		System.out.println(count);
		
	}
	
}

class Block {
	int a;
	int c;
	
	//処理できる最大数はAとCのうち文字数が少ない方
	int min() {
		return Math.min(a, c);
	}
	
	int dec() {
		a--;
		c--;
		
		return min();
	}
}
