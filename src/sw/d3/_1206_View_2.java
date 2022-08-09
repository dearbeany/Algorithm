package sw.d3;

/*
 * (i-2)번째부터 (i+2)번째까지 총 다섯 개의 건물의 높이값 중에서
 * i가 제일 큰 max일 때, 이 값에서 
 * 두 번째로 큰 최댓값을 뺀 차이값이
 * 조망권을 가진 세대의 수임
 */
import java.util.Scanner;

public class _1206_View_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) { // 10개의 테스트케이스 루프
			int N = sc.nextInt();
			int[] bgs = new int[N];

			int cnt = 0; // 조망권 가진 세대의 수

			for (int i = 0; i < N; i++) {
				bgs[i] = sc.nextInt(); // 입력 받기
			}

			// 모든 건물의 위치를 검사하면서 (단, 양 끝 두 칸씩 0,1,N-1,N-2제외)
			for (int i = 2; i < N - 2; i++) {

				int max = 0; // 양 끝 두 칸씩 총 4칸 중 가장 큰 값

				// 왼쪽 두칸, 오른쪽 두칸 탐색
				for (int j = i - 2; j <= i + 2; j++) {
					// 현재 탐색하고 있는높이(가운데)는 넘어감
					if (i == j) {
						continue;
					} else {
						// 왼쪽 두칸, 오른쪽 두칸 중 최댓값 찾기 (단,여기서 최댓값은 가운데 i번째를 제외한 최댓값임)
						// max = Math.max(max, bgs[j]);
						if (bgs[j] > max) {
							max = bgs[j];
						}
					}
				}
				if (bgs[i] > max) {
					// 가운데 높이가 찾은 최댓값 높이 보다 크다면
					cnt += bgs[i] - max;
				}
			} // end of bgs
			System.out.println("#" + tc + " " + cnt);
		} // end of tc
	} // end of main

} // end of class
