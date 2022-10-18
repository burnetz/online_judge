package abc273;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		
		int currentY = sc.nextInt();
		int currentX = sc.nextInt();
		
		int n = sc.nextInt();
		
		//vector内のインデックスと行・列番号をマッピングするためのマップ
		HashMap<Integer, Integer> mapR = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> mapC = new HashMap<Integer, Integer>();
		
		//H,Wが大きいので全ての行・列の情報を保存することはできないので
		//壁が存在する行・列（高々n）の情報だけ保存する。
		//TreeSetとして保持しておけば最寄りの壁の座標の取得は容易
		Vector<TreeSet<Integer>> vecR = new Vector<TreeSet<Integer>>();
		Vector<TreeSet<Integer>> vecC = new Vector<TreeSet<Integer>>();
 		for(int i = 0; i < n; i++) {
			int tmpR = sc.nextInt();
			int tmpC = sc.nextInt();
			
			if(!mapR.containsKey(tmpR)) {
				mapR.put(tmpR, vecR.size());
				vecR.add(new TreeSet<Integer>());
			}
			vecR.get(mapR.get(tmpR)).add(tmpC);
			
			if(!mapC.containsKey(tmpC)) {
				mapC.put(tmpC, vecC.size());
				vecC.add(new TreeSet<Integer>());
			}
			vecC.get(mapC.get(tmpC)).add(tmpR);
		}
 		
 		
 		int q = sc.nextInt();
 		
 		for(int i = 0; i < q; i++) {
 			String command = sc.next();
 			int length = sc.nextInt();
 			
 			if(command.equals("U")) {
 				//まず盤面の外に出ないようにする
 				int tmpY = Math.max(1, currentY - length);
 				
 				//その列に壁がある場合
 				if(mapC.get(currentX) != null) {
	 				Object tmpInt = vecC.get(mapC.get(currentX)).lower(currentY);
	 				//壁が移動距離よりも近いとこにあるならその手前で止まる
	 				if(tmpInt != null) {
	 					tmpY = Math.max(tmpY, (int)tmpInt + 1);
	 				}
 				} 				
 				currentY = tmpY;
 			}
 			if(command.equals("D")) {
 				int tmpY = Math.min(h, currentY + length);
 				
 				if(mapC.get(currentX) != null) {
	 				Object tmpInt = vecC.get(mapC.get(currentX)).higher(currentY);
	 				if(tmpInt != null) {
	 					tmpY = Math.min(tmpY, (int)tmpInt - 1);
	 				}
 				}
 				currentY = tmpY;
 			}
 			if(command.equals("L")) {
 				int tmpX = Math.max(1, currentX - length);
 
 				if(mapR.get(currentY) != null) {
	 				Object tmpInt = vecR.get(mapR.get(currentY)).lower(currentX);
	 				if(tmpInt != null) {
	 					tmpX = Math.max(tmpX, (int)tmpInt + 1);
	 				}
 				} 				
 				currentX = tmpX;
 			}
 			if(command.equals("R")) {
 				int tmpX = Math.min(w, currentX + length);
 				if(mapR.get(currentY) != null) {
	 				Object tmpInt = vecR.get(mapR.get(currentY)).higher(currentX);
	 				if(tmpInt != null) {
	 					tmpX = Math.min(tmpX, (int)tmpInt - 1);
	 				}
 				} 				
 				currentX = tmpX;
 			}
 			
 			System.out.println(currentY + " " + currentX);
 		}
 		
	}
}