package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11315_오목판정 {
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케

		for (int tc = 1; tc <= T; tc++) { // 4
			int N = Integer.parseInt(br.readLine()); // 오목판 크기 5
			String res = "NO";

			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = (str.charAt(j) == 'o') ? 1 : 0;
				}
			}

			// 오목 탐색
			// 가로 직선 : 좌(0,-1) 우(0,1) 이동
			// 한 행에 1이 연속으로 5개 나와야 함 
			
			
			
			// 세로 직선: 상(-1,0) 하(1,0) 이동
			// 한 열에 1이 연속으로 5개 나와야 함 

		}

		for (int[] ar : arr) {
			for (int a : ar) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}
}
