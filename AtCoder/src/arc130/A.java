package arc130;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[] str = sc.next().toCharArray();
		
		long result = 0;
		
		for(int i = 0; i < n - 1; i++) {
			if(str[i] != str[i + 1]) {
				continue;
			}
			
			int j = i + 1;
			while(j < n && str[i] == str[j]) {
				j++;
			}
			
			long seqLen = j - i;
			result += seqLen*(seqLen - 1)/2;
			
			i = j - 1;
		}
		
		System.out.println(result);
	}
}