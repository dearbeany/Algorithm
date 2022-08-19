package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			Integer.parseInt(br.readLine()); // 테스트케이스 번호 tc

			st = new StringTokenizer(br.readLine());
			Queue<Integer> q = new LinkedList<>();

			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}

			boolean flag = false; // while문을 빠져 나오기위한 플래그
			int peek = 0; // 현재 위치 맨 앞이나, 삭제되며 -i된 값이 뒤로 삽입될 것임

			while (true) {
				for (int i = 1; i <= 5; i++) {
					peek = q.peek() - i; // 맨 앞 원소를 k씩 뺀다
					if (peek <= 0) { // 숫자가 0 이하면
						peek = 0; // 0으로 유지
						flag = true; // 프로그램 종료
					} else {
						q.remove(); // 맨 앞 원소 삭제
						q.add(peek); // k만큼 뺀 원소 맨 뒤로 삽입
					}
				} // 사이클

				if (flag) { // 프로그램 종료 시
					q.remove(); // 첫 원소 삭제
					q.add(peek); // 0을 추가
					break;
				}

			}

			System.out.print("#" + tc + " ");
			while (!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}
}