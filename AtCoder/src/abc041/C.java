package abc041;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Student students[] = new Student[n];

		for(int i = 0; i < n; i++){
			students[i] = new Student(i + 1, sc.nextInt());
		}

		Arrays.sort(students);

		for(int i = 0; i < n; i++){
			System.out.println(students[i].id);
		}
	}
}

class Student implements Comparable<Student>{
	int height;
	int id;

	Student(int id, int height){
		this.id = id;
		this.height = height;
	}

	@Override
	public int compareTo(Student o) {
		// TODO 自動生成されたメソッド・スタブ
		return o.height - this.height;
	}


}