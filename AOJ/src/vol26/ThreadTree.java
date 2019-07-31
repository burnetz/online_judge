package vol26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class ThreadTree {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Submission array[] = new Submission[n];

		for(int i = 0; i < n; i++){
			int reply = Integer.parseInt(br.readLine());
			String message = br.readLine();

			Submission sub = new Submission(message);

			if(reply != 0){
				array[reply - 1].child.add(sub);
			}

			array[i] = sub;
		}

		printThread(array, array[0], 0);

	}

	//DFSでリプライを順次表示していく
	static void printThread(Submission[] array, Submission sub, int depth){
		//出力例の通りに出すには再帰の前にメッセージを出力する必要がある
		for(int i = 0; i < depth; i++){
			System.out.print('.');
		}
		System.out.println(sub.message);

		for(int i = 0; i < sub.child.size() ; i++){
			Submission tmp = sub.child.elementAt(i);

			printThread(array, tmp, depth + 1);
		}
	}

}

class Submission {
	Vector<Submission> child = new Vector<Submission>();
	String message;

	public Submission(String message) {
		this.message = message;
	}


}