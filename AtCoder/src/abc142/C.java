package abc142;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class C {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		String[] tmpArray = br.readLine().split(" ");
		
		Student[] students = new Student[n];
		for(int i = 0; i < n; i++) {
			students[i] = new Student(i + 1, Integer.parseInt(tmpArray[i]));
		}
		
		Arrays.sort(students);
		
		for(int i = 0; i < n; i++) {
			System.out.print(students[i].id);
			
			if(i != n - 1) {
				System.out.print(" ");
			}
		}
		
		System.out.println();
	}

}

class Student implements Comparable<Student> {
	int id;
	int time;
	
	Student(int id, int time) {
		this.id = id;
		this.time = time;
	}

	@Override
	public int compareTo(Student s) {
		// TODO Auto-generated method stub
		return this.time - s.time;
	}
	
	
}