package arc007;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		CD[] cds = new CD[n + 1];
		for(int i = 0; i < n + 1; i++){
			cds[i] = new CD(i);
		}

		for(int i = 0; i < m; i++){
			int id = sc.nextInt();

			int index = 0;
			for(int j = 0; j < n + 1; j++){
				if(cds[j].id == id){
					index = j;
					break;
				}
			}

			CD tmp = cds[0];
			cds[0] = cds[index];
			cds[index] = tmp;

		}

		for(int k = 1; k < n + 1; k++){
			System.out.println(cds[k].id);
		}
	}

}

class CD {
	int id;

	CD(int id){
		this.id = id;
	}
}