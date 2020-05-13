package abc066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer> right = new ArrayList<Integer>();
		ArrayList<Integer> left = new ArrayList<Integer>();

		String[] tmpArray = br.readLine().split(" ");
		//最初は右半分に
		right.add(Integer.parseInt(tmpArray[0]));
		//あとは交互に追加
		for(int i = 1; i < n; i++){
			if(i % 2 == 1){
				right.add(Integer.parseInt(tmpArray[i]));
			}
			else {
				left.add(Integer.parseInt(tmpArray[i]));
			}
		}

		//入力の個数によってどちらから出力するかが変わる
		if(n % 2 == 0){
			for(int i = right.size() - 1; i >= 0 ; i--){
				System.out.print(right.get(i));
				if(i != 0){
					System.out.print(" ");
				}
			}

			if(left.size() > 0){
				System.out.print(" ");
			}

			for(int i = 0; i < left.size(); i++){
				System.out.print(left.get(i));
				if(i != left.size() - 1){
					System.out.print(" ");
				}
			}

			System.out.println();
		}
		else {
			for(int i = left.size() - 1; i >= 0 ; i--){
				System.out.print(left.get(i));
				if(i != 0){
					System.out.print(" ");
				}
			}

			if(right.size() > 0 && left.size() != 0){
				System.out.print(" ");
			}

			for(int i = 0; i < right.size(); i++){
				System.out.print(right.get(i));
				if(i != right.size() - 1){
					System.out.print(" ");
				}
			}

			System.out.println();
		}
	}

}