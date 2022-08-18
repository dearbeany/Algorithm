package boj.bronze;

/*
 * 1. 도화지를 모두 0으로 세팅한 후
 * 2. 입력받은 좌표에 대하여 길이 10만큼 1로 만든다
 * 3. 도화지배열을 탐색하면서 1인 요소를 카운트하면 넓이 
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int[][] paper = new int[100][100];

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 도화지에 입력받은 좌표에 대하여
			// 길이 10인 사각형에 한해 1로 채우기
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					paper[i][j] = 1;
				}
			}
		}
		int cnt = 0; // 1인 개수

		// 도화지를 탐색하면서 1인 개수를 카운트
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
