package abc196;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		long n = Long.parseLong(str);

		long count = 0;
		for(int i = 1; i <= 1000000; i++){
			long num = Long.parseLong(i + ""  + i);

			if(num <= n){
				count++;
			}
			else{
				break;
			}
		}

		System.out.println(count);
	}
}
