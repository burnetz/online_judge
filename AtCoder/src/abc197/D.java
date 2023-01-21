package abc197;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		double x0 = sc.nextInt();
		double y0 = sc.nextInt();
		double xo = sc.nextInt();
		double yo = sc.nextInt();
		
		double centerX = (x0 + xo)/2.0;
		double centerY = (y0 + yo)/2.0;

		//平行移動->回転->平行移動（逆）で計算できる
		x0 -= centerX;
		xo -= centerX;
		y0 -= centerY;
		yo -= centerY;
		
		double theta = 2*Math.PI/n;
		double x1 = x0*Math.cos(theta) - y0*Math.sin(theta) + centerX;
		double y1 = x0*Math.sin(theta) + y0*Math.cos(theta) + centerY;
		
		System.out.println(x1 + " " + y1);
	}

}
