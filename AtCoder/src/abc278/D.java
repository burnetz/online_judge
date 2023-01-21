package abc278;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		Node[] nodes = new Node[n];
		
		for(int i = 0; i < n; i++) {
			nodes[i] = new Node(sc.nextInt(), -1);
		}
		
		int q = sc.nextInt();
		//最後に全要素書き換えをおこなったときの値とタイミング
		int all = -1;
		int allSetTime = -2;
		
		for(int i = 0; i < q; i++) {
			int mode = sc.nextInt();
			int value;
			
			switch (mode) {
			case 1: 
				value = sc.nextInt();
				all = value;
				allSetTime = i;
				break;
				//以下、i番目の要素の最終更新に応じて処理が変わる
			case 2:
				int index = sc.nextInt() - 1;
				value = sc.nextInt();
				if(nodes[index].time > allSetTime) {
					nodes[index].value += value;
				}
				else {
					nodes[index].value = all + value;
				}
				nodes[index].time = i;
				break;
			default:
				index = sc.nextInt() - 1;
				if(nodes[index].time > allSetTime) {
					System.out.println(nodes[index].value);
				}
				else {
					System.out.println(all);
				}
			}
		}
	}
}

//現在の値と最後に書き換えが発生したタイミングを保存する
class Node {
	long value;
	int time;
	
	Node (int value, int time){
		this.value = value;
		this.time = time;
	}
}