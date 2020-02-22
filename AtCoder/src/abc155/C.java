package abc155;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] strArray = new String[n];
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		for(int i = 0; i < n; i++) {
			strArray[i] = br.readLine();
			if(!map.containsKey(strArray[i])) {
				map.put(strArray[i], 1);
			}
			else {
				map.put(strArray[i], map.get(strArray[i]) + 1);
			}
			
			pq.add(new Node(strArray[i], map.get(strArray[i])));
		}
		
		int maxCount = pq.peek().count;
		
		while(!pq.isEmpty() && maxCount == pq.peek().count) {
			System.out.println(pq.poll().str);
		}
	}	

}

class Node implements Comparable<Node>{
	String str;
	int count;
	
	Node(String str, int count){
		this.str = str;
		this.count = count;
	}
	
	//登場回数、文字列順
	@Override
	public int compareTo(Node node) {
		// TODO Auto-generated method stub
		return node.count == this.count ? this.str.compareTo(node.str) : node.count - this.count;
	}
	
}
