package boj;

/*
 * 1. 시계방향, 반시계방향 거리(== 둘레-시계방향거리)를 가로, 세로의 길이를 이용하여 구한다.
 * 2. 원점으로부터의 시계방향 거리는 distances에 담는다. 
 * 3. 사각형을 수평선으로 핀다고 생각하여 푼다.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2564_경비원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 블록 가로의 길이
		int M = Integer.parseInt(st.nextToken()); // 블록 세로의 길이
		int len = 2 * (N + M); // 둘레

		int storeNum = Integer.parseInt(br.readLine()); // 상점의 개수
		int[] distances = new int[storeNum + 1]; // 원점을 기준으로 거리, 동근이 위치까지 크기+1

		// 상점 및 동근의 위치
		for (int i = 0; i < storeNum + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken()); // 방향
			int pos = Integer.parseInt(st.nextToken()); // 경계로부터의 거리

			switch (dir) {

			case 1: // 북 1, 왼쪽으로부터의 거리
				distances[i] = pos;
				break;
			case 2: // 남 2, 왼쪽으로부터의 거리
				distances[i] = N + M + N - pos;
				break;
			case 3: // 서 3, 위로부터의 거리
				distances[i] = 2 * (N + M) - pos;
				break;
			case 4: // 동 4, 위로부터의 거리
				distances[i] = N + pos;
				break;
			}
		}
		int clock = 0; // 시계방향 거리
		int clockWise = 0; // 시계반대방향 거리
		int min = 0;

		for (int i = 0; i < storeNum; i++) {
			clock = Math.abs(distances[i] - distances[storeNum]); // 시계방향거리
			clockWise = len - clock; // 둘레에서 시계방향거리 빼기

			min += Math.min(clock, clockWise);
		}
		System.out.println(min);

	}

}
