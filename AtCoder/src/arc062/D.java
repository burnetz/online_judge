package arc062;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		char[] input = sc.next().toCharArray();

		int result = 0;
		int p = 0;
		int g = 1;
		//パーを出せるときには出せば良い
		//今損をしてまで後にパーを温存する利点が無いため
		for(int i = 1; i < input.length; i++){
			if(input[i] == 'g'){
				if(p + 1 <= g){
					result++;
					p++;
				}
				else {
					g++;
				}
			}
			else {
				if(p + 1 <= g){
					p++;
				}
				else {
					g++;
					result--;
				}
			}

		}

		System.out.println(result);
	}

}
