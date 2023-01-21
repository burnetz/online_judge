package digitalarts2012;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String[] strArray = sc.nextLine().split(" ");
		int n = sc.nextInt();
		String[] patternArray = new String[n];

		for(int i = 0; i < n; i++){
			//*が任意のアルファベット小文字1文字とマッチするような正規表現を作っておく
			patternArray[i] = sc.next().replaceAll("\\*", "[a-z]");
		}

		//nも文字数も問題ないので普通にループを回して大丈夫
		for(int i = 0; i < strArray.length; i++){
			for(int j = 0; j < n; j++){
				if(strArray[i].matches(patternArray[j])){
					StringBuffer sb = new StringBuffer();
					//事前に文字数ごとに作っておいたほうが効率は良いかも
					for(int k = 0; k < strArray[i].length(); k++){
						sb.append("*");
					}

					strArray[i] = sb.toString();
					break;
				}
			}
		}

		for(int i = 0; i < strArray.length; i++){
			if(i != 0){
				System.out.print(" ");
			}
			System.out.print(strArray[i]);
		}
		System.out.println();
	}

}
