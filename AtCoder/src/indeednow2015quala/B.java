package indeednow2015quala;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] master = "indeednow".toCharArray();
		Arrays.sort(master);

		int n = sc.nextInt();

		for(int i = 0; i < n; i++){
			char[] s = sc.next().toCharArray();
			Arrays.sort(s);

			if(new String(s).equals(new String(master))){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
	}

}
