package abc236;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Station stations[] = new Station[n];
		
		for(int i = 0; i < n; i++) {
			stations[i] = new Station(sc.next());
		}
		
		int current = 0;
		for(int i = 0; i < m; i++) {
			String name = sc.next();
			for(; current < n; current++) {
				if(stations[current].name.equals(name)) {
					stations[current].rapid = true;
					break;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(stations[i].rapid ? "Yes" : "No");
		}
	}
}

class Station {
	String name;
	boolean rapid = false;
	
	Station(String name){
		this.name = name;
	}
}