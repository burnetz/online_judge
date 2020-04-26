package arc005;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int count = 0;
		for(int i = 0; i < n; i++){
			String str = sc.next();
			if(str.equals("TAKAHASHIKUN") || str.equals("Takahashikun") || str.equals("takahashikun")
					|| str.equals("TAKAHASHIKUN.") || str.equals("Takahashikun.") || str.equals("takahashikun.")){
				count++;
			}
		}

		System.out.println(count);
	}
}
