package abc260;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		
		ArrayList<Score> list = new ArrayList<Score>();
		
		int english[] = new int[n];;
		int math[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			math[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			english[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			list.add(new Score(i + 1, math[i], english[i]));
		}
		
		PriorityQueue<Score> pq = new PriorityQueue<>(new Comparator<Score>() {

			@Override
			public int compare(Score s1, Score s2) {
				// TODO Auto-generated method stub
				return s1.id - s2.id;
			}
		});
		
		Collections.sort(list, new Comparator<Score>() {

			@Override
			public int compare(Score s1, Score s2) {
				// TODO Auto-generated method stub
				return s2.math == s1.math ? s1.id - s2.id :
					s2.math - s1.math;
			}
		});

//		System.out.println("debug");
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		for(int i = 0; i < x; i++) {
			pq.add(list.remove(0));
		}
		
		Collections.sort(list, new Comparator<Score>() {

			@Override
			public int compare(Score s1, Score s2) {
				// TODO Auto-generated method stub
				return s2.english == s1.english ? s1.id - s2.id :
					s2.english - s1.english;
			}
		});
		
		for(int i = 0; i < y; i++) {
			pq.add(list.remove(0));
		}
		
		Collections.sort(list, new Comparator<Score>() {

			@Override
			public int compare(Score s1, Score s2) {
				// TODO Auto-generated method stub
				return s2.math + s2.english == s1.math + s1.english ? s1.id - s2.id :
					s2.math + s2.english - (s1.math + s1.english);
			}
		});
		
		for(int i = 0; i < z; i++) {
			pq.add(list.remove(0));
		}
		
		while(!pq.isEmpty()) {
			System.out.println(pq.remove().id);
		}
	}
}

class Score {
	int id;
	int math;
	int english;
	
	Score(int id, int math, int english){
		this.id = id;
		this.math = math;
		this.english = english;
	}
	
	public String toString() {
		return "id : " + id + " math : " + math + " english " + english;
	}
}