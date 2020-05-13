package abc064;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String str = sc.next();

		int left = 0;
		int addTop = 0;
		for(int i = 0; i < n; i++){
			char c = str.charAt(i);

			if(c == '('){
				left++;
			}
			else {
				if(left == 0){
					addTop++;
				}
				else{
					left--;
				}
			}
		}

		for(int i = 0; i < addTop; i++){
			str = '(' + str;
		}

		for(int i = 0; i < left; i++){
			str += ')';
		}

		System.out.println(str);
	}

}

