package tenka12012qualc;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String input = sc.next();

		char[] mark = {'S','H','D','C'};

		PriorityQueue<Result> pq = new PriorityQueue<Result>();
		//4種類のロイヤルストレートフラッシュ全てを試しても十分間に合う。
		for(int i = 0; i < 4; i++){
			StringBuffer sb = new StringBuffer();

			int index = 0;
			//文字数とターン数は必ずしも一致しない（10のせい）ので別にカウントしておく必要がある
			int turn = 0;
			int hand = 0;
			boolean success = false;
			while(index < input.length()){
				//基本的にはマーク1文字数字1文字のペア。
				//例外として10があるが、そもそも1という数字があり得ない（正しくはA）なので判別は容易
				char tmpMark = input.charAt(index);
				index++;
				String tmpNumber = input.substring(index, index + 1);
				index++;
				if(tmpNumber.equals("1")){
					tmpNumber = "10";
					index++;
				}

				if(tmpMark != mark[i] || (!tmpNumber.equals("10") && !tmpNumber.equals("J") && !tmpNumber.equals("Q") && !tmpNumber.equals("K") && !tmpNumber.equals("A"))){
					sb.append(tmpMark);
					sb.append(tmpNumber);
				}
				else{
					hand++;
				}

				turn++;

				if(hand == 5){
					success = true;
					break;
				}
			}

			if(success){
				pq.add(new Result(sb.toString(), turn));
			}
		}

		String minimum = pq.peek().trash;

		if(minimum.length() == 0){
			System.out.println(0);
		}
		else{
			System.out.println(minimum);
		}
	}

}

class Result implements Comparable<Result>{
	String trash;
	int turn;

	Result(String trash, int turn){
		this.trash = trash;
		this.turn = turn;
	}

	@Override
	public int compareTo(Result r) {
		return this.turn - r.turn;
	}
}