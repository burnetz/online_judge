package abc026;

import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Staff staff[] = new Staff[n];

		for(int i = 0; i < n; i++){
			staff[i] = new Staff(i + 1);
		}

		for(int i = 1; i < n; i++){
			staff[sc.nextInt() - 1].member.add(staff[i]);
		}

		System.out.println(staff[0].getSalary());
	}


}

class Staff {
	int id;
	Vector<Staff> member = new Vector<Staff>();

	Staff(int id){
		this.id = id;
	}

	int getSalary(){
		if(member.size() == 0){
			return 1;
		}

		int minS = Integer.MAX_VALUE;
		int maxS = 0;

		for(int i = 0; i < member.size(); i++){
			int tmp = member.get(i).getSalary();

			minS = Math.min(minS, tmp);
			maxS = Math.max(maxS, tmp);
		}
		return maxS + minS + 1;
	}
}