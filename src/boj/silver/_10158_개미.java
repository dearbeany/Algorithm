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

		// x를 2w만큼 이동하면 다시 제자리로 돌아옴
		// 현재위치 x에 t만큼 이동한 다음 제자리로 오는 만큼 나눌때 나머지가 최종거리
		x = (x + t) % 2 * w;
		y = (y + t) % 2 * h;

		if (x >= w) {
			System.out.println();
		}

	}
}