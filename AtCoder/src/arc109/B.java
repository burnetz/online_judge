package arc109;

import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();

		//長さN+1の丸太から1,2,3,,,と切り出すのが最適
		//総和の公式から直接方程式を解くのは
		//Nが大きすぎてdoubleの精度でも誤差が出るので恐らく不可能
		//二部探索で解く
		long l = 0;
		//上限をNにするとオーバーフローで正しく計算できない
		//仮にNが10^18付近だとしても上限は10^9程度で十分
		long r = Integer.MAX_VALUE;

		while(r - l > 1){
			long mid = (l + r)/2;

			long sum = mid*(mid + 1)/2;

			if(sum <= n + 1){
				l = mid;
			}
			else{
				r = mid;
			}
		}

		System.out.println(n - l + 1);
	}
}