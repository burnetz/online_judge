package abc225;

import java.util.Scanner;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();
		
		Train[] trains = new Train[n];
		for(int i = 0; i < n; i++) {
			trains[i] = new Train(i + 1);
		}
		
		//出力がボトルネックになるのでStringBufferを使う必要があるが
		//それ以外は素直な実装でOK
		//逆にunion-findは分離があったり先頭車両を探す必要があるので向かない。
		for(int i = 0; i < q; i++) {
			int mode = sc.nextInt();
			
			switch(mode) {
			case 1:
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				
				trains[x].next = y;
				trains[y].prev = x;
				break;
			case 2:
				x = sc.nextInt() - 1;
				y = sc.nextInt() - 1;
				
				trains[x].next = -1;
				trains[y].prev = -1;
				break;
			default:	
				x = sc.nextInt() - 1;
				
				Train tmpTrain = trains[x];
				while(tmpTrain.prev != -1) {
					tmpTrain = trains[tmpTrain.prev];
				}
				
				Vector<Integer> vec = new Vector<Integer>();
				while(true) {
					vec.add(tmpTrain.id);
					
					if(tmpTrain.next == -1) {
						break;
					}
					else {
						tmpTrain = trains[tmpTrain.next];
					}
				}
				StringBuffer sb = new StringBuffer();
				sb.append(vec.size() + " ");
				for(int j = 0; j < vec.size(); j++) {
					sb.append(vec.get(j));
					if(j < vec.size() - 1) {
						sb.append(" ");
					}
				}
				
				System.out.println(sb);
			}
		}
	}

}

class Train {
	int id;
	int prev = -1;
	int next = -1;
	
	Train(int id){
		this.id = id;
	}
}