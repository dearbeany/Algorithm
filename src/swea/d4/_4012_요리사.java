package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4012_요리사 {
	static int N, min;
	static int[][] syn;
	static boolean[] visited;
	static int[] groupA, groupB;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테케

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 식재료의 수
			syn = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					syn[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visited = new boolean[N];

			groupA = new int[N / 2];
			groupB = new int[N / 2];

			min = Integer.MAX_VALUE;

			comb(0, 0, 0);
			System.out.printf("#%d %d\n", tc, min);
		}
	}

	public static void comb(int idx, int aidx, int pick) {
		if (idx == N) {
			return;
		}

		if (pick == N / 2) {
			int bidx = 0;
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					groupB[bidx++] = i;
				}
			}
			min = Math.min(min, synergy());
			return;
		}

		visited[idx] = true;
		groupA[aidx++] = idx;
		comb(idx + 1, aidx, pick + 1);
		visited[idx] = false;
		aidx--;
		comb(idx + 1, aidx, pick);
	}

	public static int synergy() {
		int aSum = 0;
		int bSum = 0;

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				if (i != j) {
					aSum += syn[groupA[i]][groupA[j]];
					bSum += syn[groupB[i]][groupB[j]];
				}
			}
		}
		return Math.abs(aSum - bSum);
	}

}
