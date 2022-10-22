package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 1~N장 카드 있을 때 
 * 맨 위 버리고, 그 다음 위는 가장 밑으로... 
 * 버리는 카드 순서대로 출력? 
 */
public class _2161_카드1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		while (q.size() > 1) {
			// 가장 맨 윗장 버리고
			sb.append(q.poll() + " "); // 버린 건 출력

			// 그 다음 윗장을 가장 밑으로 가게 하자
			q.add(q.poll());
		}
		System.out.println(sb.toString() + q.poll());
	}
}
