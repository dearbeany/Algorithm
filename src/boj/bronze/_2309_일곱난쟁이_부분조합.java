package boj.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2309_일곱난쟁이_부분조합 {

	static int N = 9; // 아홉 난쟁이 중에서
	static int R = 7; // 일곱 난쟁이만 선택해야 함
	static int[] arr = new int[N];// 아홉난쟁이 키
	static int[] selected = new int[R]; // 선택한 난쟁이
	static int sum;
	static boolean check; // 정답이 여러 개인 경우 아무 거나 출력해야 하므로 하나 출력하기 위해 체크

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		comb(0, 0);
	}

	private static void comb(int idx, int sidx) {
		if (check) { // 정답이 여러 개인 경우 아무 거나 출력해야 하므로 하나 출력하면 리턴
			return;
		}
		if (sidx == R) { // 7명 고르면
			sum = 0;
			for (int i : selected) { // 7명 키의 합
				sum += i;
			}
			if (sum == 100) {
				Arrays.sort(selected); // 오름차순 정렬
				for (int i : selected) {
					System.out.println(i);
					check = true; // 출력했으므로
				}
			}
			return;
		}

		for (int i = idx; i <= N - R + sidx; i++) {
			selected[sidx] = arr[i];
			comb(i + 1, sidx + 1);
		}
	}
}
