package swea.d3;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class _8500_극장좌석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int people = sc.nextInt();
			int[] gap = new int[people];

			for (int i = 0; i < people; i++) {
				gap[i] = sc.nextInt();
			}
			Arrays.sort(gap);

			int chair = gap[people - 1] + people;
			for (int i : gap) {
				chair += i;
			}
			System.out.printf("#%d %d\n", tc, chair);
		}
	}
}
