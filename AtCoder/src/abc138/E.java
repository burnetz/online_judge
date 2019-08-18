package abc138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		String t = br.readLine();

		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();

		//2000個ごとに分割する感じ
		final int DIVID = 2000;
		boolean[][] charExists = new boolean[26][200000/DIVID];

		for(int i = 0; i < sArray.length; i++){
			charExists[sArray[i] - 'a'][i/DIVID] = true;
		}

		int i = 0;
		long result = 0;
		while(i < t.length()){
			boolean hit = false;

			for(int k = 0; k < charExists[0].length ; k++){
				//分割した区間内に該当のアルファベットがない場合はスキップする
				//その際、そもそも文字列の長さを超える場合などは深く考えたくないので
				//下のfor文に任せる
				if((k + 2)*DIVID < sArray.length &&  !charExists[tArray[i] - 'a'][k]){
					result += DIVID;
					continue;
				}
				//分割した区間内を詳細に探索
				for(int j = k * DIVID; j < s.length() && j < (k + 1) * DIVID ; j++){
					result++;

					if(sArray[j] == tArray[i]){
						hit = true;
						i++;
						if(i == t.length()){
							break;
						}
					}
				}

				if(i == t.length()){
					break;
				}
			}
			//1週しても当該文字が見つからなかったら何度やってもできない
			if(!hit){
				System.out.println(-1);
				return;
			}
		}
		System.out.println(result);
	}

}
