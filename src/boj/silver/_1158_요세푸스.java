package boj.silver;

/*
 * 요세푸스 문제: 제거되는 순서를 출력한다 
 * 1. N명 사람들을 큐에 다 넣는다. [1 2 3 4 5 6 7]
 * 2. 큐의 앞부터 poll한다. K번째가 아니면 큐에 다시 add하고, K번째인 경우 냅둠(여전히 삭제상태)
 * 3. K번째의 경우는 별도의 제거리스트에 추가한다.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1158_요세푸스 {
	public static void main(String[] args) throws IOException {
		// N명 K번째 제거 7 3

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()); // N명
		int K = Integer.parseInt(st.nextToken()); // K번째 삭제

		Queue<Integer> q = new LinkedList<>(); // 사람을 담을 큐

		for (int i = 1; i < N + 1; i++) {
			q.add(i);
		}

		List<Integer> deleteList = new ArrayList<>(); // 제거되는 요소를 순서대로 담은 리스트

		while (q.size() != 0) {
			for (int i = 1; i <= K; i++) {
				int peek = q.poll(); // 맨 첫 원소를 삭제

				if (i != K) {
					q.add(peek); // K번째 아니면 다시 넣음
				} else {
					deleteList.add(peek); // 큐에 다시 안 넣은 원소들은 K번째이므로 제거리스트에 추가
				}
			}
		}
		sb.append("<");
		for (Integer i : deleteList) {
			sb.append(i).append(", ");
		}
		sb.delete(sb.length() - 2, sb.length()).append(">");
		System.out.println(sb);

		/*
		 * System.out.print("<"); for (int i = 0; i < deleteList.size(); i++) {
		 * System.out.print(deleteList.get(i)); if (i != deleteList.size() - 1)
		 * System.out.print(", "); } System.out.print(">");
		 */

	}
}
