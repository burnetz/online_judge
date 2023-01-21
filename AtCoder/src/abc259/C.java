package abc259;

import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.next();
		String str2 = sc.next();
		
		Vector<Element> vec1 = new Vector<Element>();
		Vector<Element> vec2 = new Vector<Element>();
		
		compress(str1, vec1);
		compress(str2, vec2);
		
		//圧縮した結果が異なる場合は論外
		if(vec1.size() != vec2.size()) {
			System.out.println("No");
			return;
		}
		
		for(int i = 0; i < vec1.size(); i++) {
			Element el1 = vec1.get(i);
			Element el2 = vec2.get(i);
			
			//圧縮情報の文字が一致しない場合は不可。
			//最初の文字列の圧縮情報の方が連続で使っている文字が多いなら不可。
			//最初の文字列で1文字しかない箇所は伸ばせない。
			if(el1.c != el2.c || el1.count > el2.count || (el1.count == 1 && el2.count >= 2)) {
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
	}
	
	//どの文字が何連続というように情報を圧縮する
	static void compress(String str, Vector<Element> vec) {
		for(int i = 0; i < str.length(); i++) {
			char tmpC = str.charAt(i);
			
			if(vec.isEmpty() || vec.lastElement().c != tmpC) {
				vec.add(new Element(tmpC));
			}
			else {
				vec.lastElement().count++;
			}
		}
	}
}

class Element {
	char c;
	int count;
	
	Element(char c){
		this.c = c;
		count = 1;
	}
}