package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 규칙 찾기
 * 2. 델타 사용 -> 우하좌상
 * - 맵 밖을 벗어나거나 map에 숫자가 채워져있으면 방향전환 하자
 * - 마지막 숫자를 찍는 순간 멈추도록 한다 
 */
public class _1954_달팽이숫자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

		}

	}

	public static void print(int[][] arr) {
		for (int[] aa : arr) {
			for (int a : aa) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}

}
