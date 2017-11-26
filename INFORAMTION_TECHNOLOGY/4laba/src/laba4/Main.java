package laba4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//объявление сканера
		System.out.println("Введите количество строк");
		int ColStrok = sc.nextInt();//сканируем кол-во строк
		System.out.println("Введите длину слова");
		int ColDliny = sc.nextInt();//сканируем длину слова
		String[] StrokaTexta = new String[ColStrok];//объявление одномерного массива типа String
		int[][] TextInt = new int[ColStrok + 1][ColDliny];//объявление двумерного массива типа int
		int[][] CountInt = new int[ColStrok][ColStrok];//объявление одномерного массива типа int для счетчика различий
		int[][] CountInt2 = new int[ColStrok][ColStrok];//объявление одномерного массива типа int для счетчика сходств
		int i, j,h,g=-100, y = -100;

		char[] CharStroka;
		for (i = 0; i < ColStrok; i++) {
			System.out.println("Введите слово");
			StrokaTexta[i] = sc.next();//вводимая строка записывается в эту переменную
			if (StrokaTexta[i].length() > ColDliny || StrokaTexta[i].length() < ColDliny) {//проверка совпадает ли длина слова
				System.out.println("ошибка,неправильная длина слова");
				int wait = sc.nextInt();
			}
			CharStroka = StrokaTexta[i].toCharArray();//String->Char
			for (j = 0; j < ColDliny; j++) {
				TextInt[i][j] = Character.getNumericValue(CharStroka[j]);//Char->Int посимвольно
			}
		}
		for (h = 0; h < ColStrok; h++) {
		for (i = 0; i < ColStrok; i++) {
			for (j = 0; j < ColDliny; j++) {
				if (i==h) {//Проверка чтобы массив не сравнимался с "пустым массивом"(последним)
					//System.out.println("ERROR: ========Сработала зашита от сравнения одинаковых строк========");
					break;
				}

				if (TextInt[h][j] != TextInt[i][j]) {//Проверка на различия
					CountInt[h][i] += 1;
					System.out.println("LOG:        Различие в     " + (h+1) + " строке " + " со строкой "+(i+1)+ " в символе "+ (j + 1) );//Детектирует о нахождении различия
				} else {
					CountInt2[h][i] += 1;
					System.out.println("LOG:        Различий нет в " + (h+1) + " строке " + " со строкой "+(i+1)+ " в символе "+ (j + 1) );//Детектирует о нахождении сходства
				}
			}


		
		if (CountInt[h][i] > y) {//ведётся счётчик различий
			y = CountInt[h][i];
		}
		if (CountInt2[h][i] > g){//ведётся счётчик сходств
			g = CountInt2[h][i];
		}
		}
		}
		System.out.println("Максимально различий было:" + y);
		System.out.println("Максиамально сходств было:" + g);
	}
}
