package abc260;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
				
		int p[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}
		
		int time[] = new int[n];
		
		//k=1は置いたカードがすぐに食べられる特殊な例
		if(k == 1) {
			for(int i = 0; i < n; i++) {
				time[p[i] - 1] = i + 1;
			}
			for(int i = 0; i < n; i++) {
				System.out.println(time[i]);
			}
			return;
		}

		Arrays.fill(time, -1);
		
		//ある数字よりも末尾が大きい範囲を取得できること、
		//任意のキューを高速に削除できること。
		//TreeSetなら両方満たせる
		TreeSet<MyQueue> set = new TreeSet<>();
		
		for(int i = 0; i < n; i++) {
			//セットが空またはセット内の全てのキューの末尾の数字が小さいときは新しくキューを挿入
			if(set.size() == 0 ||  p[i] > set.last().last()) {
				MyQueue tmpQue = new MyQueue(k);
				tmpQue.vec.add(p[i]);
				set.add(tmpQue);
			}
			//それ以外ならどこかのキューには追加することができる。
			else {
				MyQueue tmpQue = new MyQueue(1);
				tmpQue.vec.add(p[i]);
				SortedSet<MyQueue> view = set.tailSet(tmpQue);
				MyQueue minimum = view.first();
				minimum.vec.add(p[i]);
				
				set.remove(minimum);
				//正しくソートするために要素を加えたら改めて挿入
				if(minimum.vec.size() < k) {
					set.add(minimum);
				}
				//こちらは挿入せずにタイムスタンプを記録する分岐
				else {
					Vector<Integer> vec = minimum.vec;
					
					for(int j = 0; j < vec.size(); j++) {
						int tmp = vec.get(j);
						time[tmp - 1] = i + 1;
					}
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(time[i]);
		}
	}
}

class MyQueue implements Comparable<MyQueue> {
	Vector<Integer> vec;
	int cap;
	
	MyQueue(int cap){
		this.vec = new Vector<Integer>();
		this.cap = cap;
	}

	//比較の際には末尾にある要素しか見ない
	@Override
	public int compareTo(MyQueue q1) {
		// TODO Auto-generated method stub
		return this.vec.lastElement() - q1.vec.lastElement();
	}
	
	int last () {
		return vec.lastElement();
	}
}