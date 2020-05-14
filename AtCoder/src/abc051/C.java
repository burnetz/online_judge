package abc051;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sx = sc.nextInt();
		int sy = sc.nextInt();
		int tx = sc.nextInt();
		int ty = sc.nextInt();

		StringBuffer command = new StringBuffer();

		//長方形の内側ルートは最大2パターンが限界
		//あとはギリギリ外回りをするしかない

		//move 1
		for(int i = 0; i < ty - sy ; i++){
			command.append("U");
		}
		for(int i = 0; i < tx - sx ; i++){
			command.append("R");
		}
		//move2
		for(int i = 0; i < ty - sy ; i++){
			command.append("D");
		}
		for(int i = 0; i < tx - sx ; i++){
			command.append("L");
		}

		//move3
		command.append("L");
		for(int i = 0; i < ty - sy + 1 ; i++){
			command.append("U");
		}
		for(int i = 0; i < tx - sx + 1; i++){
			command.append("R");
		}
		command.append("D");

		//move4
		command.append("R");
		for(int i = 0; i < ty - sy + 1; i++){
			command.append("D");
		}
		for(int i = 0; i < tx - sx + 1; i++){
			command.append("L");
		}
		command.append("U");

		System.out.println(command);
    }
}