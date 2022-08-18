package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * N개의 수가 주어질 때 오름차순 정렬
 * 시간제한 2초 
 * 카운팅 정렬 사용하기 O(n+m)
 * 범위가 -1,000,000 ~ 1,000,000 이기 때문에
 * 음수를 없애주기 위해 입력 받을 때 +1,000,000을 해준다 
 */

public class _2751_수정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine()) + 1000000; // 음수 입력 방지
		}
		br.close();

		int[] counts = new int[2000001]; // 범위 -1,000,000 ~ 1,000,000이기에 최대크기 지정
		for (int a : arr) {
			counts[a]++;
		}

		for (int i = 1; i < counts.length; i++) {
			counts[i] += counts[i - 1];
		}

		int[] sorted = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			int idx = --counts[arr[i]];
			sorted[idx] = arr[i];
		}

		for (int s : sorted) {
			sb.append(s - 1000000).append("\n"); // 출력 시 입력 때 더했던 만큼 빼줌
		}
		System.out.println(sb);

	}
}
