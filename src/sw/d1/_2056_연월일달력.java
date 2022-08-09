package sw.d1;

import java.util.Scanner;

public class _2056_연월일달력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= T; i++) {
			String str = sc.nextLine();

			int year = Integer.parseInt(str.substring(0, 4));
			int month = Integer.parseInt(str.substring(4, 6));
			int day = Integer.parseInt(str.substring(6, 8));

			System.out.printf("#%d ", i);
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if (day < 1 || day > 31) {
					System.out.println(-1);
				} else {
					System.out.printf("%04d/%02d/%02d\n", year, month, day);
				}
				break;

			case 4:
			case 6:
			case 9:
			case 11:
				if (day < 1 || day > 30) {
					System.out.println(-1);
				} else {
					System.out.printf("%04d/%02d/%02d\n", year, month, day);
				}
				break;

			case 2:
				if (day < 1 || day > 28) {
					System.out.println(-1);
				} else {
					System.out.printf("%04d/%02d/%02d\n", year, month, day);
				}
				break;
			default:
				System.out.println(-1);
			}

		}
	}
}
