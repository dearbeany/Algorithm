package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1230_암호문 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 암호문 길이

			List<Integer> list = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			int M = Integer.parseInt(br.readLine()); // 명령어 개수
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < M; i++) {
				char cmd = st.nextToken().charAt(0);

				switch (cmd) {
				case 'I':
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					for (int j = a; j < a + b; j++) {
						list.add(j, Integer.parseInt(st.nextToken()));
					}
					break;
				case 'D':
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					for (int j = a; j < a + b; j++) {
						list.remove(j);
					}
					break;
				case 'A':
					b = Integer.parseInt(st.nextToken());
					for (int j = 0; j < b; j++) {
						list.add(Integer.parseInt(st.nextToken()));
					}
					break;
				default:
					break;
				}
			}
			System.out.printf("#%d ", tc);
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();

		}
	}
}