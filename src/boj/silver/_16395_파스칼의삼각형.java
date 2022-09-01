package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _16395_파스칼의삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 1<=K<=N<=30 일 때, a(30,30)까지 저장해야하므로 크기는 31만큼
		int[][] pascal = new int[31][31];

		pascal[1][1] = 1; // 맨 위
		pascal[2][1] = 1; // 왼쪽 끝
		pascal[2][2] = 1; // 오른쪽 끝
		// .. 이처럼 삼각형 양쪽 끝은 1로 세팅

		for (int i = 3; i <= N; i++) {
			for (int j = 1; j < i + 1; j++) {

				// n번째 줄 k 번째 값일 때
				// (n, 1) = 1 (n, n) = 1
				if (j == 1 || i == j) {
					pascal[i][j] = 1;
				} else {
					pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
				}
			}
		}
		bw.write(pascal[N][K] + "\n");
		bw.flush();
		bw.close();
	}
}
