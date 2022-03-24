package Nikitina2;
import java.util.Scanner;
public class Zadanie2 {
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
		
	//razmer matr
		System.out.print("n= ");
		int n = in.nextInt();
		int[] a = new int [n];
		int[] m = new int [n];
		int s=0;
	//vvod matr
		for (int i=0;i<n;i++) {
			a [i] = in.nextInt();
		}
	//peremechenie pologitelnyx chisel
		for (int i=0;i<n;i++) {
			if (a [i]>0) {
				m[s]=a[i];
				s+=1;
			}
		}
	//vyvod cokr matr
		int[] b = new int [s];
		for (int i=0;i<s;i++) {
			b[i]=m[i]/3;
		}
		for (int i=0;i<n;i++) {
			System.out.print(a[i]);
		}
		System.out.println();
		for (int i=0;i<s;i++) {
			System.out.print(b[i]);
		}
	in.close();
	}
}
