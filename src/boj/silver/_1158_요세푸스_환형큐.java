package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1158_요세푸스_환형큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		// 환형큐
		/*
		 * int j = 0; for (int i = 0; i < N - 1; i++) { j = (j + 1 + K) % N; int
		 * deleteElement = arr[j]; arr[j] = arr[j + 1];
		 * 
		 * System.out.println(deleteElement); }
		 */

	}
}
