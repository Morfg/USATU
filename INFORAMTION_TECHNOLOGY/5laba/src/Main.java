import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//���������� �������
		System.out.println("������� ���������� �����");
		int ColStrok = sc.nextInt();//��������� ���-�� �����
		System.out.println("������� ����� �����");
		int ColDliny = sc.nextInt();//��������� ����� �����
		String[] StrokaTexta = new String[ColStrok];//���������� ����������� ������� ���� String
		int[][] TextInt = new int[ColStrok + 1][ColDliny];//���������� ���������� ������� ���� int
		int[][] CountInt = new int[ColStrok][ColStrok];//���������� ����������� ������� ���� int ��� �������� ��������
		int[][] CountInt2 = new int[ColStrok][ColStrok];//���������� ����������� ������� ���� int ��� �������� �������
		int h,g=-100, y = -100;

		ArrayList<Integer> MainList = new ArrayList<>();

		System.out.println("������� ���������� �����");
		int Colich = sc.nextInt();//��������� ���-�� �����
		System.out.println("������� ����� ��� ������");
		int MainChislo = sc.nextInt();//��������� �����, ������� ���������� �����
		Integer[][] MainMatrica = new Integer[Colich][Colich];//���������� ���������� ������� ���� int
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