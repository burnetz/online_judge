package abc186;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int count = 0;

		for(int i = 1; i <= n; i++){
			if(Integer.toOctalString(i).indexOf('7') == -1 && Integer.toString(i).indexOf('7') == -1){
				count++;
			}
		}

		System.out.println(count);
	}

}
