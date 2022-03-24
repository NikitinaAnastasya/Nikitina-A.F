package Nikitina1;
import java.util.Scanner;
public class Zadanie1 {
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
		int N = 10 ;
		int[] mass = new int [N] ;
		for (int i=0;i<N;i++) {
			mass[i] = in.nextInt();
		}
		for (int i:mass) {
			System.out.print(i + "\t");
		}
		in.close();
	}
}
