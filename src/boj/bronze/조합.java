package boj.bronze;

import java.util.Arrays;

public class 조합 {
	static String[] 토핑 = { "상추", "패티", "치즈", "토마토" };
	static int N = 4;
	static int R = 2; // R개 뽑을 거야

	static String[] sel = new String[R]; // 뽑아서 임시로 저장한 친구

	public static void main(String[] args) {
		combination(0, 0);
	}

	// idx : 토핑 해당 위치의 재료를 어떻게 할지.
	// sidx : 뽑은 재료의 위치
	static void combination(int idx, int sidx) {
		if (sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = idx; i <= N - R + sidx; i++) {
			sel[sidx] = 토핑[i];
			combination(i + 1, sidx + 1);
		}
	}
}