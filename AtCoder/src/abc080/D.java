package abc080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String[] tmpArray = input.split(" ");
		int n = Integer.parseInt(tmpArray[0]);
		int c = Integer.parseInt(tmpArray[1]);

		Program[] programs = new Program[n];
		for(int i = 0; i < n; i++){
			tmpArray = br.readLine().split(" ");
			programs[i] = new Program(Integer.parseInt(tmpArray[0]),
					Integer.parseInt(tmpArray[1]), Integer.parseInt(tmpArray[2]));
		}

		Arrays.sort(programs);

		//31以上の同時録画はありえない
		Program[] recorder = new Program[c + 1];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < c; j++){
				if(recorder[j] == null){
					recorder[j] = programs[i];
					break;
				}

				else if(recorder[j].channel == programs[i].channel
						&& programs[i].start >= recorder[j].end){
					recorder[j] = programs[i];
					break;
				}
				else if((double)programs[i].start >= recorder[j].end + 0.5){
					recorder[j] = programs[i];
					break;
				}
			}
		}

		//結局いくつ使ったか
		for(int i = 0; i <= c; i++){
			if(recorder[i] == null){
				System.out.println(i);
				break;
			}
		}
	}

}

class Program implements Comparable<Program>{
	int start;
	int end;
	int channel;

	public Program(int s, int e, int c){
		start = s;
		end = e;
		channel = c;
	}

	public int compareTo(Program p) {
		return this.start - p.start;
	}
}