package Zadanie3;

public class Zadanie3 {
	public static void main(String[] args) {
		int n=args.length;
		if(n==2) {
		int a=Integer.parseInt(args[0]);
		int b=Integer.parseInt(args[1]);
		System.out.println("���������: "+args[0]+ ", "+ args[1]);
		System.out.println("����� ����������: "+(a+b));
		}
		else {
			System.out.println("�������� ���������� ����������");
		}
}}
