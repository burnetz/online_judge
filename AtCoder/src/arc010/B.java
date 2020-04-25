package arc010;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int days[] = new int[366];
		int dpm[] = {31,29,31,30,31,30,31,31,30,31,30,31};

		days[0] = 6;
		for(int i = 1; i < days.length; i++){
			days[i] = (days[i - 1] + 1)%7;
		}

		for(int i = 0; i < n; i++){
			String[] date = sc.next().split("/");

			int m = Integer.parseInt(date[0]);
			int d = Integer.parseInt(date[1]);

			int index = d - 1;

			for(int j = 0; j < m - 1; j++){
				index += dpm[j];
			}
			//本来土日だった祝日
			if(days[index] >= 5){
				days[index] = 10;
			}
			else {
				days[index] = 7;
			}
		}

		for(int i = 0; i < days.length; i++){
			//前から順に振替休日の解決
			if(days[i] == 10 ){
				for(int j = i + 1; j < days.length; j++){
					if(days[j] <= 4){
						days[j] = 8;
						break;
					}
				}
			}
		}

		int result = 1;
		int tmp = 0;
		for(int i = 0; i < days.length ; i++){
			if(days[i] >= 5){
				tmp++;
			}
			else{
				tmp = 0;
			}

			result = Math.max(result, tmp);
		}

		System.out.println(result);
	}
}
