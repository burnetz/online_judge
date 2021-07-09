package tenka12013qualb;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		Vector<String> vec = new Vector<String>();
		while(sc.hasNext()) {
			vec.add(sc.next());
		}
		
		Collections.sort(vec);
		
		System.out.println(vec.get(6));
	}

}
