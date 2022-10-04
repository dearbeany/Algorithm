
import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");

			// 신입 사원 수
			int N = sc.nextInt();
			int kMin = sc.nextInt();
			int kMax = sc.nextInt();

			// 점수 입력 받는 배열
			int[] score = new int[N];
			for (int i = 0; i < score.length; i++) {
				score[i] = sc.nextInt();
			}

			// 일단 오름차순 정렬
			Arrays.sort(score);

			// 불가능한지 안한지 판별하기 위한 도구
			boolean isOk = true;

			// 분반 기준 점수
			int T1 = 0;
			int T2 = 0;

			// T1 이 최소일 때 + T2 가 최대일 때 정한 다음
			T1 = score[kMin - 1] + 1;
			T2 = score[N - kMin];

			// 그 때 T1 < T2 가 아닌 경우 불가능
			if (T1 == T2) {
				isOk = false;
			}

			// 차이의 최솟값
			int minAns = Integer.MAX_VALUE;

			// 모든 T1 T2 경우의 수 찾기 (T1 < T2 되도록 설정해줌)
			for (int x = T1; x < T2; x++) {
				Loop1: for (int y = T2; y > x; y--) {
					int maxClass = Integer.MIN_VALUE;
					int minClass = Integer.MAX_VALUE;

					// 반마다 인원 수 세서 넣는다
					int[] classCnt = new int[3];
					for (int i = 0; i < N; i++) {
						if (score[i] < x) {
							classCnt[0]++;
						} else if (score[i] >= x && score[i] < y) {
							classCnt[1]++;
						} else {
							classCnt[2]++;
						}
					}

					// 최소, 최대 인원 조건 안맞는 경우
					for (int i = 0; i < classCnt.length; i++) {
						if (classCnt[i] < kMin || classCnt[i] > kMax) {
							continue Loop1;
						}
					}

					// A B C 반 중 최대 최소 찾기
					for (int i = 0; i < classCnt.length; i++) {
						maxClass = Math.max(maxClass, classCnt[i]);
						minClass = Math.min(minClass, classCnt[i]);
					}

					// 정답 찾기
					minAns = Math.min(minAns, (maxClass - minClass));
				}
			}

			// 반배정에 다 실패했을 때
			if (minAns == Integer.MAX_VALUE) {
				isOk = false;
			}

			// 반배정 성공 실패 판별
			if (isOk == true) {
				System.out.println(minAns);
			} else {
				System.out.println(-1);
			}
		}
	}
}

//5
//5 1 4
//3 5 5 4 5
//6 2 6
//5 3 3 5 5 1
//7 1 6
//3 3 5 2 5 1 2
//8 1 7
//3 1 1 2 2 5 3 5
//10 1 6
//4 4 2 4 5 2 5 3 5 5