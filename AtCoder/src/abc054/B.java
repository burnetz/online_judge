package abc054;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		String image[] = new String[n];
		for(int i = 0; i < n; i++){
			image[i] = sc.next();
		}

		String template[] = new String[m];
		for(int i = 0; i < m; i++){
			template[i] = sc.next();
		}

		for(int i = 0; i < n - m + 1 ; i++){
			for(int j = 0; j < n - m + 1; j++){
				boolean same = true;
				for(int k = 0; k < m; k++){
					if(!template[k].equals(image[i + k].substring(j, j + m))){
						same = false;
						break;
					}
				}

				if(same){
					System.out.println("Yes");
					return;
				}
			}
		}

		System.out.println("No");

    }
}