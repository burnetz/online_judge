package agc032;

import java.util.ArrayList;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < n; i++){
			list.add(sc.nextInt());

			//大きな数字が前の方にあるのはそもそも不可能
			if(list.get(i) > i + 1){
				System.out.println(-1);
				return;
			}
		}

		int result[] = new int[n];
		for(int i = 0; i < n; i++){
			//j番目の要素がjなら取り除く
			//候補が複数あるなら右側から先に取り除く
			for(int j = list.size() - 1; j >= 0; j--){
				if(list.get(j) == j + 1){
					result[i] = j + 1;
					list.remove(j);
					break;
				}
			}
		}

		for(int i = n - 1; i >= 0; i--){
			System.out.println(result[i]);
		}
	}
}
