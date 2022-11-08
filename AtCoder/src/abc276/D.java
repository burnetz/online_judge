package abc276;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		Arrays.sort(a);
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		int gcd = a[0];
		
		//最終的に等しくできるならその値はGCD
		for(int i = 1; i < n; i++) {
			gcd = gcd(a[i], gcd);
		}
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			a[i] /= gcd;
			
			while(a[i] % 2 == 0) {
				a[i] /= 2;
				count++;
			}
			
			while(a[i] % 3 == 0) {
				a[i] /= 3;
				count++;
			}
			
			//2と3で割りまくってもGCDにならないなら等しくできない
			if(a[i] != 1) {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(count);
	}
	
	static int gcd(int a, int b){
    	int tmp;

    	while (a % b != 0)
    	{
    		tmp = b;
    		b = a % b;
    		a = tmp;
    	}
    	return b;
    }
}