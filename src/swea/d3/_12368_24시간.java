package swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _12368_24시간 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken()); // 테케

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			// 0 <= A, B <= 23
			int A = Integer.parseInt(st.nextToken()); // 자정 0으로부터 지난 시간
			int B = Integer.parseInt(st.nextToken()); // A로부터 B시간 만큼 지난다

			// res = A + B 단, res가 24 이상이면?
			// 24면 0으로
			// 25면 1.. res-24 를 한다

			int res = A + B;
			if (res >= 24) {
				res -= 24;
			}
			bw.write("#" + tc + " " + res + "\n");
		}
		bw.flush();
		bw.close();
	}

}
