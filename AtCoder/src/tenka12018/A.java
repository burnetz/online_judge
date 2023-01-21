package tenka12018;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		StringBuffer sb = new StringBuffer(sc.next());
		System.out.println(sb.length() == 2 ? sb : sb.reverse());
	}

}
