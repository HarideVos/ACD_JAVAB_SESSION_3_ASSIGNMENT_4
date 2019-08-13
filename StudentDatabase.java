package threepointfour;

import java.util.Scanner;

class Student{
	private String name;
	private int phone;
	private int rollNumber;
	private String className;
	
	public Student (String name, int phone, int rollNumber, String className) {
		this.name = name;
		this.phone = phone;
		this.rollNumber = rollNumber;
		this.className = className;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

}

class StudentResultProcessing extends Student{
	String[] cijfers;
	
	public StudentResultProcessing (String name, int phone, int roll, String className, int[] cijfers) {
		super(name, phone, roll, className);
		this.cijfers = results(roll, cijfers);
	}
	
	String[] results (int roll, int[] cijfers) {
		String[] res = new String[cijfers.length];
		for (int i = 0; i < cijfers.length; i++) {
			if (cijfers[i] < 80) {
				res[i] = "fail";
			} else {
				res[i] = "pass";
			}
		}
		return res;
	}
	
	void display() {
		System.out.println("Student name: " + super.getName());
		System.out.println("Phone number: " + super.getPhone());
		System.out.println("Roll number: " + super.getRollNumber());
		System.out.println("Class: " + super.getClassName());
		System.out.println("Results:");
		
		for (int i = 0; i < cijfers.length; i++) {
			System.out.println("Subject " + (i+1) + ": " + cijfers[i]);
		}
	}
}

public class StudentDatabase {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		StudentResultProcessing[] students = new StudentResultProcessing[3];
		String name, className;
		int phone, roll;
		int [] cijfers = new int[3];
		for (int i = 0; i < students.length; i++) {
			System.out.print("Enter student name: ");
			name = sc.next();
			
			System.out.print("Enter student phone number: ");
			phone = sc.nextInt();
			System.out.print("Enter student roll number: ");
			roll = sc.nextInt();
			System.out.print("Enter student class name: ");
			className = sc.next();
			for(int j=0; j< 3; j++) {
				System.out.print("Enter student grade " + (j+1) + ": ");
				cijfers[j] = sc.nextInt();
			}
			students[i] = new StudentResultProcessing(name, phone, roll, className, cijfers);
			System.out.println();
		}
		sc.close();
		for(int i=0; i< students.length; i++) {
			students[i].display();
			System.out.println();
		}
	}
}