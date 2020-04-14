package arc070;

import java.io.IOException;
import java.util.Scanner;

public class C {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		//最短何手でx以上になるかを考える
		//結果的にiオーバーしたならi秒のときに休めばよいため
		System.out.println((long)Math.ceil((-1 + Math.sqrt(1 + 8.0*x))/2));
	}

}
