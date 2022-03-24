package Nikitina3;
import java.util.Scanner;//dlya vvoda dannyx
import java.util.Random;
import java.util.ArrayList;
public class Zadanie3 {
	public static void main(String[] args) {
		ArrayList <Integer> vec = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		System.out.println("Vvedite parametry matricy n u m sootvetstveno:");
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] matr = new int [n][m];

		//ogran random chisel
		int min = 0;
		int max = 100;
		
		// zapolnenie matr
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        matr[i][j]=new Random().nextInt(max - min);
		    }
		}
		
		//vyvod matr
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        System.out.print(matr[i][j] + "\t");
		    }
		    System.out.println();
		}
		
		//naxogdenie min chisla u dobav ego v vector
		for (int j = 0; j<m;j++) {
			int x=matr[0][j];
			int h=1;
			for (int i=0;i<n;i++) {
				if (x>matr[i][j]) {
					h=i+1;
				}
			}
			vec.add(h);
		}
		
		System.out.println();
		for (int i:vec) {
			System.out.print(i + "\t");
		}
		
		
		
		
		
		in.close();
	}
}
