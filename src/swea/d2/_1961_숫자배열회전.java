package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1961_숫자배열회전 {

	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			arr = new int[N][N]; // 숫자 담긴 배열

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] oneRotArr = rotateArr(arr, N); // 90도는 1회전
			int[][] twoRotArr = rotateArr(oneRotArr, N); // 180도는 90도 회전한 배열을 다시 1회전
			int[][] threeRotArr = rotateArr(twoRotArr, N); // 270도는 180도를 회전한 배열을 다시 1회전

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append("\n");

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(oneRotArr[i][j]);
				}
				sb.append(" "); // 출력 시 회전한 배열 사이 공백
				for (int j = 0; j < N; j++) {
					sb.append(twoRotArr[i][j]);
				}
				sb.append(" ");
				for (int j = 0; j < N; j++) {
					sb.append(threeRotArr[i][j]);
				}
				sb.append("\n"); // 다음 행 출력을 위한 개행
			}
			System.out.print(sb.toString());

		}
	}

	// 90도로 회전하는 함수
	private static int[][] rotateArr(int[][] arr, int N) {
		int[][] tmp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = arr[N - 1 - j][i];
			}
		}
		return tmp;
	}
}
