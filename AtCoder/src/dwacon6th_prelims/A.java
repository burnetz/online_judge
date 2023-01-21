package dwacon6th_prelims;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] songs = new String[n];
		int t[] = new int[n];

		for(int i = 0; i < n; i++){
			songs[i] = sc.next();
			t[i] = sc.nextInt();
		}

		String x = sc.next();

		boolean awake = true;
		int total = 0;
		for(int i = 0; i < n; i++){
			if(awake){
				if( songs[i].equals(x)){
					awake = false;
				}
			}
			else {
				total += t[i];
			}
		}

		System.out.println(total);
	}

}
