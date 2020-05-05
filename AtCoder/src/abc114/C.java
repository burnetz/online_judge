package abc114;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for(int i = 1; i <= 9; i++){
			dfs(0, i);
		}

		int count = 0;
		while(!pq.isEmpty()){
			if(pq.poll() <= n){
				count++;
			}
			else {
				break;
			}
		}

		System.out.println(count);


	}

	static int digits[] = new int[10];
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

	//3,5,7だけで構成された数はn桁以下なら4^nよりは少ないので
	//全部生成しても十分間に合う
	static void dfs(int depth, int n){
		String tmp = "";

		if(depth == n){
			int appear[] = new int[10];
			for(int i = 0; i < n; i++){
				tmp += (char)(digits[i] + '0');
				appear[digits[i]]++;
			}
			//3,5,7を1回以上含むかはここでチェックしても間に合う
			if(appear[3]*appear[5]*appear[7] != 0){
				pq.add(Integer.parseInt(tmp));
			}

			return;
		}

		int pattern[] = {3,5,7};

		for(int i = 0; i < pattern.length; i++){
			digits[depth] = pattern[i];
			dfs(depth + 1, n);
		}
	}
}
