package javacuong;

import java.util.Scanner;

class Employee {
	int ID;
	String name;
	double salary;
	Employee() {
		this.ID = 0;
		name = "";
		salary = 0;
	}
	Employee(int ID, String name, double salary) {
		this.ID = ID;
		this.name = name;
		this.salary = salary;
	}
	double calculateSalary() {
		salary = salary * 2 + 100;
		return salary;
	}
	void input() {
		Scanner objSc = new Scanner(System.in);

		System.out.print("Enter ID: ");
		this.ID = objSc.nextInt();
		objSc.nextLine();
		System.out.print("Enter name: ");
		this.name = objSc.nextLine();

		System.out.print("Enter salary: ");
		this.salary = objSc.nextDouble();
	}

	void output() {
		System.out.println(" ID: " + this.ID + "name:" + this.name + " salary: " + this.calculateSalary());

	}

}
public class constructor {

	public static void main(String[] args) {
		Employee objE = new Employee();
		objE.input();
		objE.output();
	}
}
