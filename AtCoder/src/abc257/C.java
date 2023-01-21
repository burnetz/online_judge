package abc257;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String str = sc.next();
		
		int w[] = new int[n + 2];
		ArrayList<Double> adult = new ArrayList<Double>();
		ArrayList<Double> child = new ArrayList<Double>();

		for(int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			w[i] = tmp;
			
			if(str.charAt(i) == '0') {
				child.add((double)tmp);
			}
			else {
				adult.add((double)tmp);
			}
		}
		
		w[n] = 0;
		w[n + 1] = Integer.MAX_VALUE;
		
		Collections.sort(child);
		Collections.sort(adult);
		
		int result = 0;
		//バイナリサーチを使うことでO(NlogN)で解ける
		for(int i = 0; i < w.length; i++) {
			//Javaにはupper_bound等がないので0.5ずらしてわざと外す
			int index1 = Collections.binarySearch(child, w[i] - 0.5);
			index1++;
			index1 *= -1;
			int correctC = index1;
			
			int index2 = Collections.binarySearch(adult, w[i] - 0.5);
			index2++;
			index2 *= -1;
			int correctA = adult.size() - index2;
			
			result = Math.max(result, correctA + correctC);
		}
		
		System.out.println(result);
	}
}

