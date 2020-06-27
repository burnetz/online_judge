package agc003;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		//絶対値が0でもペアは作れるので前から順にカードを選ぶのが最適
		long pair = 0;
		for(int i = 0; i < n; i++){
			pair += a[i]/2;

			//余ったカードは次に送って良い
			//ただしi + 1にもともとカードがない場合は余りを送ってもペアが作れないので送る意味がない
			if(i != n - 1 && a[i]%2 == 1 && a[i + 1] != 0){
				a[i + 1]++;
			}
		}

		System.out.println(pair);
	}

}
