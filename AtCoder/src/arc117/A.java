package arc117;

import java.util.Scanner;
import java.util.Vector;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		Vector<Integer> vec = new Vector<Integer>();
		int sum = 0;

		if(a >= b){
			for(int i = 1; i <= a ; i++){
				vec.add(i);
				sum += i;
			}

			for(int j = 1; j <= b - 1; j++){
				vec.add(-j);
				sum -= j;
			}
			vec.add(-sum);
		}
		else {
			for(int i = 1; i <= b ; i++){
				vec.add(-i);
				sum -= i;
			}

			for(int j = 1; j <= a - 1; j++){
				vec.add(j);
				sum += j;
			}
			vec.add(-sum);
		}

		for(int i = 0; i < vec.size(); i++){
			if(i >= 1){
				System.out.print(" ");
			}
			System.out.print(vec.get(i));
		}

		System.out.println();
	}
}