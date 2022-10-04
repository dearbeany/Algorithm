package swea.d3;

import java.util.Scanner;

public class _6485_삼성시의버스노선 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt(); // 노선의 개수

			int[] busStop = new int[5001]; // 각 버정에 몇 개 노선?
			for (int i = 0; i < N; i++) {
				int st = sc.nextInt(); // 1
				int ed = sc.nextInt(); // 3

				for (int j = st; j <= ed; j++) {
					busStop[j]++;
				}
			}

			int P = sc.nextInt(); // 확인하고 싶은 버스 정류장의 수
			for (int i = 0; i < P; i++) {
				int c = sc.nextInt();
				sb.append(busStop[c]).append(" ");
			}
			System.out.println(sb.toString());
		}
	}

}
