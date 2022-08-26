package swea.d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1959_두개의숫자열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 숫자열 A 개수
			int M = Integer.parseInt(st.nextToken()); // 숫자열 B 개수

			int[] arrA = new int[N];
			int[] arrB = new int[M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arrA[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				arrB[i] = Integer.parseInt(st.nextToken());
			}

			int minLen = Math.min(N, M);

			int[] mulArr = new int[minLen];
			int maxSum = 0;

			for (int i = 0; i <= Math.abs(M - N); i++) {
				mulArr[i] = arrA[i] * arrB[i];
			}

		}
	}
}
