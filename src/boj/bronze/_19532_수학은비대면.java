package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19532_수학은비대면 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());

		// ax + by = c
		// dx + ey = f

		// x = (c - b * y) / a;
		// y = (f - d * x) / e;

		// 주어지는 숫자는 -999이상 999이하 범위에서 완전탐색을 한다

		for (int x = -999; x <= 999; x++) {
			for (int y = -999; y <= 999; y++) {
//				왜 이항해서 계산한 식은 틀릴까..?? => by zero 0으로 나누는 경우 오류 추정 
//				if ((x == (c - b * y) / a) && (y == (f - d * x) / e)) {
				if ((a * x + b * y == c) && (d * x + e * y == f)) {
					sb.append(x + " ");
					sb.append(y);
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
