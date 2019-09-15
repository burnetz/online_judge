package abc141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int l = 0;
		int r = n + 2;

		String[] subRights = new String[n];
		for(int i = 0; i < n; i++){
			subRights[i] = str.substring(i);
		}

		//部分文字列の長さを決め打ちして2分探索で解を特定する
		while(r - l > 1){
			int mid = (l + r)/2;

			boolean hit = false;
			for(int i = 0; i <= n - 2*mid; i++){
				String subLeft = str.substring(i, i + mid);
				char[] leftArray = subLeft.toCharArray();
				char[] rightArray = subRights[i + mid].toCharArray();

				//普通にcontainsを使うと間に合わないのでラビンカープ法で探索
				if(RKSearcher.indexOf(leftArray, rightArray) >= 0){
					hit = true;
					break;
				}
			}

			if(hit){
				l = mid;
			}
			else {
				r = mid;
			}
		}

		System.out.println(l);
	}

}

//ラビンカープ法
class RKSearcher {
	//ハッシュ値によっては事故る。0を1個削るとWA
	private static final long q = 10000000007L;
	private static final int d = 64;

	public static int indexOf(char[] str1, char[] str2){
		int M = str1.length;
		int N = str2.length;
		long dM = 1;
		long h1 = 0;
		long h2 = 0;

		if(M == N){
			if(new String(str1).equals(new String(str2))){
				return 0;
			}
			else {
				return -1;
			}
		}

		else if (M > N){
			return -1;
		}

		for(int i = 1; i < M ; i++){
			dM = (d*dM)%q;
		}

		for(int i = 0; i < M; i++){
			h1 = (h1*d + index(str1[i])) % q;
			h2 = (h2*d + index(str2[i])) % q;
		}
		int i;
		for(i = 0; h1 != h2 ;i++){
			h2 = (h2 + d*q - index(str2[i])*dM) % q;
			if(i+M >= N){
				return -1;
			}
			h2 = (h2*d + index(str2[i+M])) % q;
			if (i > N-M){
				return -1;
			}
		}
		return i;
	}

	private static int index(char c){
		if(c >=  '0' && c <= '9'){
			return c - '0';
		}
		else if (c >= 'a' && c <= 'z'){
			return c - 'a' + 10;
		}
		else if (c >= 'A' && c <= 'Z'){
			return c - 'A' + 36;
		}
		else {
			return -1;
		}
	}
}

