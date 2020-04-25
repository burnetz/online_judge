package arc009;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char converter[] = new char[10];

		for(int i = 0; i < 10; i++){
			converter[sc.nextInt()] = (char)(i + '0');
		}
		int n = sc.nextInt();
		ACNum numbers[] = new ACNum[n];

		for(int i = 0; i < n; i++){
			String original = sc.next();
			char[] str = original.toCharArray();

			for(int j = 0; j < str.length; j++){
				str[j] = converter[str[j] - '0'];
			}


			numbers[i] = new ACNum(Integer.parseInt(original), Integer.parseInt(new String(str)));
		}

		Arrays.sort(numbers);

		for(int i = 0; i < n; i++){
			System.out.println(numbers[i].original);
		}
	}
}

class ACNum implements Comparable<ACNum>{
	int original;
	int converted;

	ACNum(int n1, int n2){
		original = n1;
		converted = n2;
	}
	@Override
	public int compareTo(ACNum num) {
		// TODO 自動生成されたメソッド・スタブ
		return this.converted - num.converted;
	}
}