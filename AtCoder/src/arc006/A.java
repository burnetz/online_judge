package arc006;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		boolean e[] = new boolean[10];
		for(int i = 0; i < 6; i++){
			e[sc.nextInt()] = true;
		}

		int b = sc.nextInt();

		boolean l[] = new boolean[10];
		for(int i = 0; i < 6; i++){
			l[sc.nextInt()] = true;;
		}

		int same = 0;
		boolean bonus = false;

		for(int i = 0; i < 10; i++){
			if(e[i] && e[i] == l[i]){
				same++;
			}

			if(l[b]){
				bonus = true;
			}
		}


		int result = 0;
		if(same == 6){
			result = 1;
		}
		else if(same == 5){
			if(bonus){
				result = 2;
			}
			else {
				result = 3;
			}
		}
		else if(same == 4){
			result = 4;
		}
		else if(same == 3){
			result = 5;
		}

		System.out.println(result);
	}
}
