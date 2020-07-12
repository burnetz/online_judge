package agc039;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();
		int k = sc.nextInt();
		boolean oneChar = true;
		for(int i = 1; i < str.length; i++){
			if(str[i - 1] != str[i]){
				oneChar = false;
				break;
			}
		}

		//文字が1種類のときはここで済ませておく
		if(oneChar){
			System.out.println((long)str.length*k/2);
			return;
		}

		int firstSeq = 0;
		int lastSeq = 0;
		int tmpCount = 0;
		int changeCount = 0;
		//同じ文字がn文字続いた場所があれば、そこで必要な置き換えは[n/2]
		for(int i = 0; i < str.length; i++){
			tmpCount++;

			if(i == str.length - 1 || str[i] != str[i + 1]){
				changeCount += tmpCount/2;

				lastSeq = tmpCount;
				if(firstSeq == 0){
					firstSeq = tmpCount;
				}

				tmpCount = 0;
			}
		}

		long result = (long)changeCount*k;

		//最初の文字と最後の文字が同じときは別の処理が必要
		//最初にa文字、最後にb文字連続していたとして
		//結合部の最適解は[a/2]+[b/2]ではなく[(a+b)/2]であるため。
		if(str[0] == str[str.length - 1]){
			result = result - (long)(firstSeq/2 + lastSeq/2 - (firstSeq + lastSeq)/2)*(k - 1);
		}

		System.out.println(result);
	}

}
