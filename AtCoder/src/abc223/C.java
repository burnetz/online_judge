package abc223;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		Section[] sec = new Section[n];
		
		double timeSum = 0;
		int left = 0;
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			sec[i] = new Section(left, left + a, b);
			left = sec[i].right;
			timeSum += 1.0*a/b;
		}
		
		timeSum /= 2;
		double EPS = 0.000000001;
		for(int i = 0; i < n; i++) {
			if(timeSum < EPS) {
				System.out.println(sec[i].left);
				return;
			}
			else if(timeSum >= (double)sec[i].distance()/sec[i].speed) {
				timeSum -= (double)sec[i].distance()/sec[i].speed;
			}
			else {
				System.out.println(sec[i].left + timeSum * sec[i].speed);
				return;
			}
		}
	}
}

class Section {
	int left;
	int right;
	int speed;
	
	Section(int left, int right, int speed){
		this.left = left;
		this.right = right;
		this.speed = speed;
	}
	
	int distance() {
		return this.right - this.left;
	}
}