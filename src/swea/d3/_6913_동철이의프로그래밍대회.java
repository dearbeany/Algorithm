package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _6913_동철이의프로그래밍대회 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 사람의 수
			int m = Integer.parseInt(st.nextToken()); // 문제의 수

			int[][] arr = new int[n][m]; // 대회의 결과?
			int[][] entrant = new int[n][2]; // 몇 번 참가자, 푼 문제 개수

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

					if (arr[i][j] == 1) { // 문제 풀었으면
						entrant[i][1] += arr[i][j]; // 푼 문제 개수 모두 더해서 저장
					}
				}
			}

			for (int i = 0; i < n; i++) {
				entrant[i][0] = i + 1; // 몇번 참가자
			}

			// 푼 문제의 개수를 기준으로 내림차순 정렬
			// 정렬결과 맨 첫 인덱스에는 1등한 사람의 번호, 1등이 푼 문제개수가 저장된다
			Arrays.sort(entrant, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[1] - o1[1];
				}
			});

			int maxSolve = entrant[0][1]; // 1등이 푼 문제 수
			int winner = 0; // 1등한 사람의 숫자

			for (int i = 0; i < n; i++) {
				if (entrant[i][1] == maxSolve) { // 1등이 푼 문제 개수와 같으면
					winner++; // 동점자이므로 1등 추가
				}
			}
			System.out.printf("#%d %d %d\n", tc, winner, maxSolve);
		}

	}
}
