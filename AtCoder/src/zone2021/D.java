package zone2021;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		//同じことを普通のStringでやるとTLE
		StringBuffer result1 = new StringBuffer();
		StringBuffer result2 = new StringBuffer();
		
		boolean toRight = true;
		
		//実際に反転はしない。右に追加するか左に追加するかを考える
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == 'R') {
				toRight = !toRight;
			}
			else if(toRight) {
				result1.append(c);
			}
			else {
				result2.append(c);
			}
		}
		if(result2.length() > 0) {
			result2.reverse();
		}
		
		String result;
		if(toRight) {
			result = result2.toString() + result1.toString();
		}
		else {
			StringBuffer sb = new StringBuffer(result2.toString() + result1.toString());
			result = sb.reverse().toString();
		}
		
		ArrayList<Character> resultList = new ArrayList<Character>();
		//正規表現による置換はおそらく間に合わない。
		//別の文字列に移し替えて末尾が被ったら2文字削除という流れならO(N)
		for(int i = 0; i < result.length(); i++) {
			char tmp = result.charAt(i);
			
			if(resultList.size() > 0 && resultList.get(resultList.size() - 1) == tmp) {
				resultList.remove(resultList.size() - 1);
			}
			else {
				resultList.add(tmp);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		Iterator<Character> it = resultList.iterator();
		
		while(it.hasNext()) {
			sb.append(it.next());
		}
		System.out.println(sb);
	}

}
