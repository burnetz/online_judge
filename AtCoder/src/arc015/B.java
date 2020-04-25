package arc015;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int category[] = new int[6];

		for(int i = 0; i < n; i++){
			double ht = sc.nextDouble();
			double lt = sc.nextDouble();

			if(ht >= 35){
				category[0]++;
			}
			else if(ht >= 30){
				category[1]++;
			}
			else if(ht >= 25){
				category[2]++;
			}

			if(lt >= 25){
				category[3]++;
			}

			if(lt < 0){
				if(ht >= 0){
					category[4]++;
				}
				else {
					category[5]++;
				}
			}
		}


		for(int i = 0; i < 6; i++){
			System.out.print(category[i]);
			if(i < 5){
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}
