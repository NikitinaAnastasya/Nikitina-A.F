package Nikitina4;
import java.util.Scanner;
import java.util.Random;
public class Zadanie4 {
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
		System.out.print("Razmer matrix= ");
		int n = in.nextInt();
		int[][] matr = new int [n][n];
		int sum=0;
		int kol=0;
		//zapolnenie matr
		for (int i = 0;i<n;i++) {
			for(int j=0;j<n;j++) {
				matr[i][j]=new Random().nextInt(20)-10;
			}
		}
		//vyvod matr
		for (int i=0; i<n;i++) {
			for (int j=0;j<n;j++) {
				System.out.print(matr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		//naxogdenie pobochnoy diagonali
			for (int i=n-1,j=0;j<n;i--,j++) {
				if (matr[i][j]>0) {
					sum+=matr[i][j];
					kol+=1;
					System.out.print(matr[i][j] + "\t");
					}
				}
			System.out.println();
			System.out.print(sum/kol);
		in.close();
	}
}
