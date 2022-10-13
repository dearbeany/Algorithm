package swea.d3;

import java.util.Scanner;

public class _15612_체스판위룩2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int cnt = 0;
			boolean[][] visited = new boolean[2][8]; // 0행이 행, 1행이 열
			String ans = "yes";
			for (int i = 0; i < 8; i++) {
				String line = sc.next();

				for (int j = 0; j < line.length(); j++) {
					if (line.charAt(j) == 'O') {
						if (visited[0][i] || visited[1][j]) {
							ans = "no";
							break;
						}
						cnt++;
						visited[0][i] = visited[1][j] = true;
					}
				}
			}
			if (cnt != 8)
				ans = "no";
			System.out.println("#" + tc + " " + ans);
		}
	}
}
