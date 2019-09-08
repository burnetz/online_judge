package abc140;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int b[] = new int[n - 1];

		String[] tmpArray = br.readLine().split(" ");
		for(int i = 0; i < n - 1; i++){
			b[i] = Integer.parseInt(tmpArray[i]);
		}

		//一番左と一番右はmaxの値をそのまま採用
		int result = b[n - 2] + b[0];

		//他は両maxのうち小さいほうを選ばないと矛盾する
		for(int i = 0; i < n - 2; i++){
			result += Math.min(b[i], b[i + 1]);
		}

		System.out.println(result);
	}

}
