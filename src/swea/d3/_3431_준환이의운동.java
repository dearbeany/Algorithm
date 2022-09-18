package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3431_준환이의운동 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken()); // 테케

		for (int tc = 1; tc <= T; tc++) {
			// 1주일에 L분 이상 U분 이하 운동 해야함
			// X분 만큼 했을 때
			st = new StringTokenizer(br.readLine());

			int L = Integer.parseInt(st.nextToken()); // 최소 운동 제한시간
			int U = Integer.parseInt(st.nextToken()); // 최대 운동 제한시간
			int X = Integer.parseInt(st.nextToken()); // 현재 진행 시간

			int res = 0;
			// X < L : L-X
			// L <= X <= U : 0
			// U < X : -1

			if (X < L) {
				res = L - X;
			} else if (X <= U) {
				res = 0;
			} else {
				res = -1;
			}
			System.out.printf("#%d %d\n", tc, res);
		}
	}
}
