package javacuong;

import java.util.Scanner;

class Vehicle {
	String numberSign;
	String color;
	String source;

	Vehicle() {
		numberSign = "";
		color = "";
		source = "";
	}

	Vehicle(String numberSign, String color, String source) {
		this.numberSign = numberSign;
		this.color = color;
		this.source = source;
	}

	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(" number sign: ");
		numberSign = scanner.nextLine();
		System.out.print(" color: ");
		color = scanner.nextLine();
		System.out.print(" source: ");
		source = scanner.nextLine();
	}

	void output() {
		System.out.println("Number Sign: " + numberSign);
		System.out.println("Color: " + color);
		System.out.println("Source: " + source);
	}

	double cash() {
		return 0.0;
	}
}

class Car extends Vehicle {
	String manufacturer;
	double pwv;
	double pwov;

	Car() {
		super();
		manufacturer = " ";
		pwv = 0.0;
		pwov = 0.0;
	}

	Car(String numberSign, String color, String source, String manufacturer, double priceWithVAT,
			double priceWithoutVAT) {
		super(numberSign, color, source);
		this.manufacturer = manufacturer;
		this.pwv = pwv;
		this.pwov = pwov;
	}

	void input() {
		super.input();
		Scanner scanner = new Scanner(System.in);
		System.out.print(" manufacturer: ");
		manufacturer = scanner.nextLine();
		System.out.print(" price without VAT: ");
		pwov = scanner.nextDouble();
	}

	double cash() {
		if (pwov <= 2000) {
			pwv = pwov + pwov * 10 / 100;
		} else {
			pwv = pwov + pwov * 15 / 100;
		}
		return pwv;
	}
}

class CarList {
	Car[] cars;
	int size;

	CarList() {
		cars = new Car[10];
		size = 0;
	}

	void inputCar() {
		Scanner scanner = new Scanner(System.in);
		while (size < 10) {
			Car car = new Car();
			car.input();
			cars[size] = car;
			size++;

		}
	}

	void outputCar() {
		for (int i = 0; i < size; i++) {
			cars[i].output();
			System.out.println("Giá có VAT: " + cars[i].cash());
		}
	}

	void sort() {
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (cars[j].cash() > cars[j + 1].cash()) {
					Car temp = cars[j];
					cars[j] = cars[j + 1];
					cars[j + 1] = temp;
				}
			}
		}
	}

	double sumOfCash() {
		double sum = 0;
		for (int i = 0; i < size; i++) {
			sum += cars[i].cash();
		}
		return sum;
	}

	void maxCash() {
		Car max = cars[0];
		int maxIndex = -1;

		for (int i = 0; i < size; i++) {
			if (cars[i].pwov > max.pwov) {
				max = cars[i];
				maxIndex = i;
			}
		}

		if (maxIndex != -1) {
			cars[maxIndex].output();
		}
	}

	void searchByName(String manufacturerName) {
		boolean found = false;
		for (int i = 0; i < size; i++) {
			if (cars[i].manufacturer.equalsIgnoreCase(manufacturerName)) {
				cars[i].output();
				found = true;
			}
		}

		if (!found) {
			System.out.println("không tìm thấy: " + manufacturerName);
		}
	}
}

public class kethua {

	public static void main(String[] args) {
		CarList carList = new CarList();
		carList.inputCar();
		carList.sort();
		System.out.println("Sắp xếp theo giá có VAT:");
		carList.outputCar();
		System.out.println("tổng theo VAT: " + carList.sumOfCash());
		System.out.println("Xe có giá cao nhất chưa VAT:");
		carList.maxCash();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập tên nhà sản xuất cần tìm: ");
		String manufacturerName = scanner.nextLine();
		System.out.println("xe của nhà sản xuất: " + manufacturerName);
		carList.searchByName(manufacturerName);
	}
}
