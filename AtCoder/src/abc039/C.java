package abc039;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		int faIndex = str.indexOf("WBWBWBW") % 12;

		String note = null;
		switch(faIndex){
		case 0:
			note = "Fa";
			break;
		case 1:
			note = "Mi";
			break;
		case 3:
			note = "Re";
			break;
		case 5:
			note = "Do";
			break;
		case 6:
			note = "Si";
			break;
		case 8:
			note = "La";
			break;
		case 10:
			note = "So";
		}

		System.out.println(note);
	}
}

