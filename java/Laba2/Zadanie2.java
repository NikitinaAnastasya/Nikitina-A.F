package Nikitina2;
import java.util.Scanner;
public class Zadanie2 {
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
		
	//размер матрицы
		System.out.print("n= ");
		int n = in.nextInt();
		int[] a = new int [n];
		int[] m = new int [n];
		int s=0;
	//ввод матрицы
		for (int i=0;i<n;i++) {
			a [i] = in.nextInt();
		}
	//перемещение положительных цифр
		for (int i=0;i<n;i++) {
			if (a [i]>0) {
				m[s]=a[i];
				s+=1;
			}
		}
	//вывод сокращенной матрицы
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
