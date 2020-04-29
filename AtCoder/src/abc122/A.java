package abc122;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char table[] = new char[128];
		table['A'] = 'T';
		table['T'] = 'A';
		table['G'] = 'C';
		table['C'] = 'G';

		System.out.println(table[sc.next().charAt(0)]);
	}

}
