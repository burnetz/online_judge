package arc121;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		Vector<Long> red = new Vector<Long>();
		Vector<Long> green = new Vector<Long>();
		Vector<Long> blue = new Vector<Long>();
		
		for(int i = 0; i < n*2; i++) {
			long a = sc.nextLong();
			String s = sc.next();
			
			switch (s) {
			case "R": {
				red.add(a);
				break;
			}				
			case "G": {
				green.add(a);
				break;
			}				
			case "B": {
				blue.add(a);
				break;
			}				
			default:
				throw new IllegalArgumentException("Unexpected value: " + s);
			}
		}
		
		Collections.sort(red);
		Collections.sort(green);
		Collections.sort(blue);
		
		if(red.size()%2 == 0 && green.size()%2 == 0 && blue.size()%2 == 0) {
			System.out.println(0);
		}
		else {
			long result;
			if(red.size()%2 == 0) {
				result = minDif(green, blue, red);
			}
			else if(green.size()%2 == 0) {
				result = minDif(blue, red, green);
			}
			else {
				result = minDif(red, green, blue);
			}
			
			System.out.println(result);
		}
	}
	
	static long INF = 9_000_000_000_000_000L;
	static long minDif(Vector<Long> v1, Vector<Long> v2, Vector<Long> v3) {
		long result = INF;
		
		//こちらは2色（v1,v2）だけで完結するパターン
		for(int i = 0; i < v1.size(); i++) {
			long num1 = v1.get(i);
			int index = Collections.binarySearch(v2, num1);
			
			if(index >= 0) {
				return 0;
			}
			
			index = -index;
			
			//真面目に狙い撃ちをするのがめんどくさかったので十分な範囲をループ
			for(int j = Math.max(0, index - 2) ; j < Math.min(v2.size(), index + 3) ; j++){
				result = Math.min(result, Math.abs(num1 - v2.get(j)));
			}
		}
		
		//こちらは3色絡むパターン
		long tmpResult1 = INF;
		long tmpResult2 = INF;
		
		//差の絶対値の和なので、(v3,v1)の差の最小値と(v3,v2)の差の最小値を個別に求めて後から足せばよい。
		//v3内の同じ要素が2回選ばれる可能性があるが、その場合はそもそも2色だけでも良かったはずなので値の更新が起こらない。
		for(int i = 0; i < v3.size(); i++) {
			long num1 = v3.get(i);
			
			int index1 = Collections.binarySearch(v1, num1);
			
			if(index1 < 0) {
				index1 = -index1;

				for(int j = Math.max(0, index1 - 2) ; j < Math.min(v1.size(), index1 + 3) ; j++){
					tmpResult1 = Math.min(tmpResult1, Math.abs(num1 - v1.get(j)));
				}
			}
			else {
				tmpResult1 = 0;
			}
		}
		
		for(int i = 0; i < v3.size(); i++) {
			long num1 = v3.get(i);
			int index2 = Collections.binarySearch(v2, num1);
			
			if(index2 < 0) {

				index2 = -index2;

				for(int j = Math.max(0, index2 - 2) ; j < Math.min(v2.size(), index2 + 3) ; j++){
					tmpResult2 = Math.min(tmpResult2, Math.abs(num1 - v2.get(j)));
				}
			}
			else {
				tmpResult2 = 0;
			}
		}
		result = Math.min(result, tmpResult1 + tmpResult2);
		
		return result;
	}
}
