package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _8673_코딩토너먼트1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			int N = (int) Math.pow(2, k); // 참가자 수
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			int bored = 0; // 지루한 정도의 총합

			while (list.size() != 1) {
				for (int i = 0; i < list.size() - 1; i += 2) {
					bored += Math.abs(list.get(i) - list.get(i + 1));
				}
				for (int i = 0; i < list.size() - 1; i++) {
					if (list.get(i) >= list.get(i + 1)) {
						list.remove(i + 1);
					} else {
						list.remove(i);
					}
				}
			}

			System.out.printf("#%d %d\n", tc, bored);
		}
	}

}
