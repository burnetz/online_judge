package arc110;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] str = sc.next().toCharArray();

		if(n == 1){
			if(str[0] == '0'){
				System.out.println((long)Math.pow(10, 10));
			}
			else {
				System.out.println((long)Math.pow(10, 10)*2);
			}
			return;
		}
		if(n == 2){
			if(str[0] == '1' && str[1] == '1'){
				System.out.println((long)Math.pow(10, 10));
			}
			else if(str[0] == '1' && str[1] == '0'){
				System.out.println((long)Math.pow(10, 10));
			}
			else if(str[0] == '0' && str[1] == '1'){
				System.out.println((long)Math.pow(10, 10) - 1);
			}
			else {
				System.out.println(0);
			}
			return;
		}

		//以下3文字以上であるという前提
		char[] three = new char[3];
		int one = 0;
		int zero = 0;
		//まずは検索文字列の最初の3文字が適切かチェック
		for(int i = 0; i < 3; i++){
			three[i] = str[i];
			if(three[i] == '0'){
				zero++;
			}
			else{
				one++;
			}
		}

		if(!(zero == 1 && one == 2)){
			System.out.println(0);
			return;
		}

		//適切な検索文字列であれば最初の3文字の繰り返し（半端なところで切れても良い）になっているはず
		for(int i = 3; i < n; i++){
			if(str[i] != three[i % 3]){
				System.out.println(0);
				return;
			}
		}

		int begin = 0;
		if(str[0] == '1' && str[1] == '1'){
			begin = 0;
		}
		else if(str[0] == '1' && str[1] == '0'){
			begin = 1;
		}
		else if(str[0] == '0' && str[1] == '1'){
			begin = 2;
		}

		//3k + begin + n <= 3*10^10
		long result = (long)((3*Math.pow(10, 10) - n - begin)/3) + 1;

		System.out.println(result);

	}
}