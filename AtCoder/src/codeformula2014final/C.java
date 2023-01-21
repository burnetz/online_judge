package codeformula2014final;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] str = sc.nextLine().toCharArray();
		
		Vector<String> users = new Vector<String>();
		
		for(int i = 0; i < str.length - 1; i++) {
			if(str[i] == '@' && str[i + 1] >= 'a' && str[i + 1] <= 'z') {
				String tmp = "";
				
				for(int j = i + 1; j < str.length; j++) {
					if(!(str[j] >= 'a' && str[j] <= 'z')){
						i = j - 1;
						break;
					}
					tmp += str[j];
				}
				if(tmp.length() >= 1 && !users.contains(tmp)) {
					users.add(tmp);
				}
			}
		}
		
		Collections.sort(users);
		
		for(int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}
	}
}
