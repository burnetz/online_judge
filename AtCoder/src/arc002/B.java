package arc002;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String[] tmpArray = sc.next().split("/");

		//月が0オリジンなのでそこだけは調整
		GregorianCalendar cal = new GregorianCalendar(Integer.parseInt(tmpArray[0]),
				Integer.parseInt(tmpArray[1]) - 1, Integer.parseInt(tmpArray[2]));

		while(true){
			int y = cal.get(GregorianCalendar.YEAR);
			int m = cal.get(GregorianCalendar.MONTH) + 1;
			int d = cal.get(GregorianCalendar.DATE);

			if(y%m == 0 && y/m%d == 0){
				System.out.printf("%04d/%02d/%02d\n", y, m, d);
				return;
			}
			else {
				cal.add(GregorianCalendar.DATE, 1);
			}

		}
	}
}

