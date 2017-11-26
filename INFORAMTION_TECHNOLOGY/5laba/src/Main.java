import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//объ€вление сканера
		System.out.println("¬ведите количество строк");
		int ColStrok = sc.nextInt();//сканируем кол-во строк
		System.out.println("¬ведите длину слова");
		int ColDliny = sc.nextInt();//сканируем длину слова
		String[] StrokaTexta = new String[ColStrok];//объ€вление одномерного массива типа String
		int[][] TextInt = new int[ColStrok + 1][ColDliny];//объ€вление двумерного массива типа int
		int[][] CountInt = new int[ColStrok][ColStrok];//объ€вление одномерного массива типа int дл€ счетчика различий
		int[][] CountInt2 = new int[ColStrok][ColStrok];//объ€вление одномерного массива типа int дл€ счетчика сходств
		int h,g=-100, y = -100;

		ArrayList<Integer> MainList = new ArrayList<>();

		System.out.println("¬ведите количество строк");
		int Colich = sc.nextInt();//сканируем кол-во строк
		System.out.println("¬ведите число дл€ поиска");
		int MainChislo = sc.nextInt();//сканируем число, которое необходимо найти
		Integer[][] MainMatrica = new Integer[Colich][Colich];//объ€вление двумерного массива типа int
		int Sredniy=(int)(Colich/2);
		System.out.println(Sredniy);
		int[] MassivChisel = new int[Colich];
		int i, j,NumStr;
		for (i=0;i<Colich;i++) {
			MainList.add(i);
		}
		Collections.shuffle(MainList);
		System.out.println(MainList);
		
		for (i=0;i<Colich;i++) {
			for (j=0;j<Colich;j++) {
				if (Sredniy!=j) {
					System.out.print('_');
				}else {
			MainMatrica[i][Sredniy]= MainList.get(i);
			System.out.print(MainMatrica[i][Sredniy]);
		}}Sredniy=(int)(Sredniy/2);
			System.out.println();
		}
	}
}