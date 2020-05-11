package abc090;

import java.io.IOException;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		int count = 0;
		for(int i = a; i <= b; i++){
			char str[] = Integer.toString(i).toCharArray();

			if(str[0] == str[4] && str[1] == str[3]){
				count++;
			}
		}

		System.out.println(count);
	}
}
