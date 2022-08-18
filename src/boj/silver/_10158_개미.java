package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10158_개미 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken()); // 너비
		int h = Integer.parseInt(st.nextToken()); // 높이

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()); // 현재 x좌표
		int y = Integer.parseInt(st.nextToken()); // 현재 y좌표

		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken()); // t시간 후

		// 1사분면, 2사분면, 3사분면, 4사분면 이동
		int[] dx = { 1, -1, -1, 1 };
		int[] dy = { 1, 1, -1, -1 };

		/*
		 * for (int i = 0; i < t; i++) { int nx = x, ny = y; for (int j = 0; j < 4; j++)
		 * {
		 * 
		 * } }
		 */
	}
}
