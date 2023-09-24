package javacuong;
import java.util.Scanner;
abstract class Hoadon{
	int SoHD;
	int Thang;
	double Sotien;
	//pthuc truu tuong
	abstract void Nhap();
	//phuong thưc truu tương
	abstract void Tinhtien();
}
class HDonGTGT extends Hoadon{
	int SoDauKy, SoCuoiKy;
	double DONGIA=600;
	void Nhap() {
		Scanner objSc=new Scanner(System.in);
		System.out.println("Nhap so hoa don:");
		SoHD=objSc.nextInt();
		System.out.println("Nhap so thang:");
		Thang=objSc.nextInt();
		System.out.println("Nhap so chu dien dau ky:");
		SoDauKy=objSc.nextInt();
		System.out.println("Nhap so chu dien cuoi ky:");
		SoCuoiKy=objSc.nextInt();
		if(SoCuoiKy<=SoDauKy) {
			System.out.println("So dien cuoi ky phai lon hon dau ky:");
			System.exit(0);
		}
	}
	void Tinhtien() {
		double tien;
		if((SoCuoiKy-SoDauKy)>70) {
			tien=(SoCuoiKy-SoDauKy)*DONGIA*1.5;
		}else {
			tien=(SoCuoiKy-SoDauKy)*DONGIA;
		}
	 Sotien=tien;
	}
}
class DSHoaDon{
	HDonGTGT[] dsHD=new HDonGTGT[10];
	void NhapHoaDon() {
		Scanner objSc=new Scanner(System.in);
		for(int i=0;i<10;i++) {
			System.out.println("Nhap thong tin hoa don:");
			dsHD[i]=new HDonGTGT();
			dsHD[i].Nhap();
			dsHD[i].Tinhtien();
		}
	}
void TimHoaDon() {
	double maxSotien=dsHD[0].Sotien;
	int index=0;
	for(int i=0;i<10;i++) {
		if(dsHD[i].Sotien>maxSotien) {
			maxSotien=dsHD[i].Sotien;
			index=i;
		}
	}
	System.out.println("Hoa don cos SOtien cao nhat");
	System.out.println("So Hoa Don:"+dsHD[index].SoHD);
	System.out.println("Thang:"+dsHD[index].Thang);
	System.out.println("SO tien:"+dsHD[index].Sotien);
}
void Tongtien() {
	double sum=0;
	for(int i=1;i<10;i++) {
		sum+=dsHD[i].Sotien;
	}
	System.out.println("Tong tien 10 hoa don la: "+sum);
}
void display() {
	System.out.println("===Danh sach hoa don tien dien:===");
	for(int i=0;i<10;i++) {
		System.out.println("Hoa don thu: "+(i+1)+":");	
		System.out.println("So hoa don: "+dsHD[i].SoHD);
		System.out.println("Thang: "+dsHD[i].Thang);
		System.out.println("So hoa don: "+dsHD[i].Sotien);
		}
	
	}
}
public class abstractclass {
	public static void main(String[] args) {
		DSHoaDon dshd=new DSHoaDon();
		dshd.NhapHoaDon();
		dshd.TimHoaDon();
		dshd.Tongtien();
		dshd.display();
	}
}
