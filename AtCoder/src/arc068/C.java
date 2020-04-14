package arc068;

import java.io.IOException;
import java.util.Scanner;

public class C {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		long x = sc.nextLong();
		
		//5と6をひたすら繰り返すのが最高効率
		long result = (x/11)*2;
		x %= 11;
		
		result += (int)Math.ceil(x / 6.);
		System.out.println(result);
	}

}
