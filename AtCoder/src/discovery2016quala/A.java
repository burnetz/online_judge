package discovery2016quala;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = "DiscoPresentsDiscoveryChannelProgrammingContest2016";

		int w = sc.nextInt();

		for(int i = 0; i < str.length(); i += w){
			System.out.println(str.substring(i, Math.min(i + w, str.length())));
		}
	}

}
