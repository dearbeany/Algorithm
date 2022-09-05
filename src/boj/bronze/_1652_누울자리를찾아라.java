package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1652_누울자리를찾아라 {

	static char[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 배열의 크기

		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				// 짐(X)은 0, 누울 수 있는 자리(.)는 1
				arr[i][j] = str.charAt(j);
			}
		}

		int garo = 0; // 가로로 누울 수 있는 자리의 개수
		int sero = 0; // 세로로 누울 수 있는 자리의 개수

		for (int i = 0; i < N; i++) {
			int cnt1 = 0, cnt2 = 0;
			for (int j = 0; j < N; j++) {
				// 가로로 누울 수 있는 자리 카운트
				// 행방향 탐색
				if (arr[i][j] == '.') { // 현재 위치에 짐 없으면
					cnt1++; // 우선 한 자리 확보
				}

				if (arr[i][j] == 'X' || j == N - 1) { // X 나오거나 마지막 인덱스 만나면
					if (cnt1 >= 2) { // 이제까지 cnt1이 2보다 크다면 누울 수 있으므로
						garo++; // 누울 수 있는 자리 개수 추가
					}
					cnt1 = 0; // X 만났으므로 누울 수 없음. 초기화
				}

				// 세로로 누울 수 있는 자리 카운트
				// 열방향 탐색
				if (arr[j][i] == '.') {
					cnt2++;
				}
				if (arr[j][i] == 'X' || j == N - 1) {
					if (cnt2 >= 2) {
						sero++;
					}
					cnt2 = 0;
				}
			}

		}
		bw.append(garo + " " + sero);
		bw.flush();
		bw.close();
	}
}
