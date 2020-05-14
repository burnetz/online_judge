package abc059;

import java.util.Formatter;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();

		int zero = 0;
		Formatter formatterA = new Formatter();
		a = formatterA.format("%0" + (102 - a.length()) + "d" + "%s", zero, a).toString();
		Formatter formatterB = new Formatter();
		b = formatterB.format("%0" + (102 - b.length()) + "d" + "%s", zero, b).toString();

		System.out.println(a.compareTo(b) > 0 ? "GREATER" :
			a.compareTo(b) < 0 ? "LESS" : "EQUAL");
    }
}