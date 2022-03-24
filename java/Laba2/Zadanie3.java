package Nikitina3;
import java.util.Scanner;//для ввода данных
import java.util.Random;
import java.util.ArrayList;
public class Zadanie3 {
	public static void main(String[] args) {
		ArrayList <Integer> vec = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		System.out.println("Введите параметры матрицы n и m соответсвенно:");
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] matr = new int [n][m];

		//ограничение рандомных чисел
		int min = 0;
		int max = 100;
		
		// заполнение матрицы
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        matr[i][j]=new Random().nextInt(max - min);
		    }
		}
		
		//вывод матрицы
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        System.out.print(matr[i][j] + "\t");
		    }
		    System.out.println();
		}
		
		//нахождение минимального числа и добавление его в вектор
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
