package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _2930_힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테케

		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d ", tc);

			// 디폴트는 오름차순 (최대힙) -> 낮은 숫자가 우선순위 갖도록
			// 우선순위를 내림차순으로 지정해줌 -> 높은 숫자가 우선순위 갖도록
			PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

			int N = Integer.parseInt(br.readLine()); // 연산의 수
			int res = 0;

			for (int nc = 0; nc < N; nc++) {
				st = new StringTokenizer(br.readLine()); // 한 줄 입력
				int type = Integer.parseInt(st.nextToken()); // 연산 종류

				// 연산 1 힙에 삽입
				if (st.countTokens() == 1) {
					q.add(Integer.parseInt(st.nextToken()));
				}
				// 연산 2 최댓값 출력 후 해당 키값 삭제
				else {
					if (q.isEmpty()) {
						res = -1;
					} else {
						res = q.poll();
					}
					System.out.printf("%d ", res);
				}
			}
			System.out.println();
		} // end of for tc
	}

}
