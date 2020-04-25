package arc011;

import java.util.Scanner;
import java.util.Vector;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Vector<String> vec = new Vector<String>();

		for(int i = 0; i < n; i++){
			String str = sc.next().toLowerCase();

			String num = "";
			for(int j = 0; j < str.length(); j++){
				char c = str.charAt(j);
				int add = -1;

				switch(c){
				case 'b':
				case 'c':
					add = 1;
					break;
				case 'd':
				case 'w':
					add = 2;
					break;
				case 't':
				case 'j':
					add = 3;
					break;
				case 'f':
				case 'q':
					add = 4;
					break;
				case 'l':
				case 'v':
					add = 5;
					break;
				case 's':
				case 'x':
					add = 6;
					break;
				case 'p':
				case 'm':
					add = 7;
					break;
				case 'h':
				case 'k':
					add = 8;
					break;
				case 'n':
				case 'g':
					add = 9;
					break;
				case 'z':
				case 'r':
					add = 0;
					break;

				}

				if(add >= 0){
					num += add;
				}
			}

			if(!num.equals("")){
				vec.add(num);
			}
		}

		for(int i = 0; i < vec.size(); i++){
			if(i != 0){
				System.out.print(" ");
			}
			System.out.print(vec.get(i));
		}

		System.out.println();

	}
}
