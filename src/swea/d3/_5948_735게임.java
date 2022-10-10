package swea.d3;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _5948_735게임 {
	static int[] num;
	static int[] sel;
	static Set<Integer> sumSet;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			num = new int[7];
			sel = new int[3];

			for (int i = 0; i < 7; i++) {
				num[i] = sc.nextInt();
			}

			sumSet = new TreeSet<>(); // TreeSet은 오름차순 정렬을 보장
			comb(0, 0);

			// sumSet에서 5번째로 큰 수이기 때문에
			// 뒤에서부터 4개 지우면 됨
			for (int i = 1; i <= 4; i++) {
				sumSet.remove(((TreeSet<Integer>) sumSet).last());
			}

			System.out.printf("#%d %d\n", tc, ((TreeSet<Integer>) sumSet).last());

		}
	}

	private static void comb(int idx, int sidx) {
		if (sidx == 3) { // 3개 고르면 리턴
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += sel[i];
			}
			sumSet.add(sum);
			return;
		}
		if (idx == 7) { // 마지막 인덱스 오면 리턴
			return;
		}

		sel[sidx] = num[idx];
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
	}
}
