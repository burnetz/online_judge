package arc006;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		String tmpArray[] = str.split(" ");
		int n = Integer.parseInt(tmpArray[0]);
		int l = Integer.parseInt(tmpArray[1]);

		String[] lots = new String[l];
		for(int i = 0; i < l; i++){
			str = sc.nextLine();

			lots[i] = str;
		}

		str = sc.nextLine();
		int goal = 0;

		for(int i = 0; i < n; i++){
			if(str.charAt(i*2) == 'o'){
				goal = i;
				break;
			}
		}

		int pos = goal;
		for(int i = l - 1; i >= 0; i--){
			if(pos > 0 && lots[i].charAt(2*pos - 1) == '-'){
				pos--;
			}
			else if(pos < n - 1 && lots[i].charAt(2*pos + 1) == '-'){
				pos++;
			}
		}

		System.out.println(pos + 1);
	}
}