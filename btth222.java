package javacuong;

import java.util.Scanner;
import java.io.IOException;

abstract class Phuongtien{
	int numberofwheels;
	int speed;
	String color;
	double distance;
	Phuongtien(){
		this.numberofwheels = 0;
		this.speed = 0;
		this.color = "";
		this.distance = 0;
	}
	Phuongtien(int numberofwheels,int speed,String color,double distance){
		this.numberofwheels = numberofwheels;
		this.speed = speed;
		this.color = color;
		this.distance = distance;
	}
	void input() {
		Scanner objSc = new Scanner(System.in);
		System.out.print("Enter numberofwheels :");
		numberofwheels = objSc.nextInt();
		System.out.print("Enter speed :");
		speed = objSc.nextInt();
		objSc.nextLine();
		System.out.print("Enter color :");
		color = objSc.nextLine();
		System.out.print("Enter distance :");
		distance = objSc.nextDouble();
	}
	abstract void display();
	double timetomove() {
		return distance/speed;
	}
}
class Oto extends Phuongtien{
	double gasvolume;
	Oto(){
		this.gasvolume = 0;
	}
	Oto(int numberofwheels,int speed,String color,double distance,double gasvolume){
		super(numberofwheels,speed,color,distance);
		this.gasvolume = gasvolume;
	}
	void input() {
		super.input();
		Scanner objSc = new Scanner(System.in);
		System.out.print("Enter gas volume : ");
		gasvolume = objSc.nextDouble();
	}
	double calulateDistancePerGas() {
		return distance/gasvolume;
	}
	void display() {
		System.out.println("This car have  : "+numberofwheels+" Wheels , Color : "+color
				+" take : "+timetomove()+" hours to move the distance : "+distance
				+" with speed "+speed+"km/h and gas volume is : "+gasvolume);
	}
}
class Bicyle extends Phuongtien{
	boolean electrical;
	Bicyle(){
		this.electrical = false;
	}
	Bicyle(int numberofwheels,int speed,String color,double distance,boolean electrical){
		super(numberofwheels,speed,color,distance);
		this.electrical = electrical;;
	}
	void input() {
		super.input();
		Scanner objSc = new Scanner(System.in);
		System.out.print("Enter electrical or no electrical : ");
		electrical = objSc.nextBoolean();
	}
	String needToRecharge() {
		return (electrical&&(distance>60))?"Need to recharge bateries":"Do'n nees to recharge";
	}
	void display() {
		if(electrical) {
			System.out.println("This is electrical bicyle ");
		}else {
			System.out.println("This bicyle have  : "+numberofwheels+" Wheels , Color : "+color
					+" take : "+timetomove()+" hours to move the distance : "+distance
					+" with speed "+speed+"km/h and "+needToRecharge());
		}
	}
}

class Vehiclelist{
	Phuongtien[] PT = new Phuongtien[100];
	int n=0;
	int chon,loai;
	void inputlist() throws IOException{
		do {
			Scanner objSc = new Scanner(System.in);
			System.out.print("O to(1) hay Xe dap(0)");
			loai = objSc.nextInt();
			if(loai==1) {
				PT[n] = new Oto();
			} else {
				PT[n] = new Bicyle();
			}
			PT[n++].input();
			System.out.print("Tiep tuc (1/0)");
			chon = objSc.nextInt();
			if((n==100)||(chon==0)) {
				break;
			}
		} while (true);
	}
	Phuongtien Vehiclefastest() {
		Phuongtien tmp=PT[0];
		for(int i=0;i<n;i++) {
			if(tmp.speed<PT[i].speed) {
				tmp=PT[i];
			}
		}
		return tmp;
	}
	void outputlist() {
		for(int i=0;i<n;i++) {
			PT[i].display();
		}
	}
}
public class btth222 {

	public static void main(String[] args) throws IOException {
		Vehiclelist DS = new Vehiclelist();
		DS.inputlist();
		DS.outputlist();
        System.out.println("Information vehicle have speed fastest !");
        DS.Vehiclefastest().display();
	}

}

