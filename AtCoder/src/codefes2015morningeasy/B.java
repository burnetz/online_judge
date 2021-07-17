package codefes2015morningeasy;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] str = sc.next().toCharArray();
		int count = 0;
		
		if(n % 2 == 1){
			System.out.println(-1);
			return;
		}
		for(int i = 0; i < n/2; i++){
			if(str[i] != str[i + n/2]){
				count++;
			}
		}
		
		System.out.println(count);
	}

}
