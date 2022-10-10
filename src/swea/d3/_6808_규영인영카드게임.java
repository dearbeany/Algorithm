package swea.d3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _6808_규영인영카드게임 {
	static int[] gyu, iny, res; // 규영, 인영, 인영이 카드 순열로 저장해논 거
	static boolean[] visited; // 인영이 원소 사용했으면 방문
	static int win, lose;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			gyu = new int[9]; // 규영의 카드 배열
			for (int i = 0; i < 9; i++) {
				gyu[i] = sc.nextInt();
			}

			List<Integer> inList = new ArrayList<>(); // 인영이 카드 리스트
			for (int i = 1; i <= 18; i++) {
				inList.add(i);
			}

			for (int i = 0; i < 9; i++) {
				if (inList.contains(gyu[i])) {
					inList.remove(Integer.valueOf(gyu[i]));
				}
			}

			iny = new int[9]; // 인영이 카드 배열
			for (int i = 0; i < 9; i++) {
				iny[i] = inList.get(i);
			}

			res = new int[9];
			visited = new boolean[9];

			win = 0; // 규영 이긴 횟수
			lose = 0; // 규영 진 횟수
			perm(0); // 인영이 카드 어떻게 내는지 0번부터 순열조합 해보자

			System.out.printf("#%d %d %d\n", tc, win, lose);
		}
	}

	private static void perm(int idx) {
		if (idx == 9) { // 인영 다 골라써
			int gyuScore = 0, inyScore = 0;

			for (int i = 0; i < 9; i++) {
				if (gyu[i] > res[i]) { // 규영이 카드가 더 높으면
					gyuScore += gyu[i] + res[i]; // 규영이 두 카드 합만큼 점수 얻음
				} else { // 인영이 카드 더 높으면
					inyScore += gyu[i] + res[i]; // 인영이가 점수 가져가
				}
			}

			if (gyuScore > inyScore) { // 규영 총점 더 높으면
				win++; // 규영 이긴 횟수 +1
			}

			if (gyuScore < inyScore) { // 인영 총점 더 높으면
				lose++; // 규영 진 횟수 + 1
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				res[idx] = iny[i];
				visited[i] = true;
				perm(idx + 1);
				visited[i] = false;
			}
		}
	}
}
