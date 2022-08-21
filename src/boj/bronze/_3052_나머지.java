package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3052_나머지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[42]; // 42로 나누면 나머지는 0~41까지 나옴
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			int rem = n % 42;
			arr[rem] = 1;
		}

		int cnt = 0;
		for (int r : arr) {
			if (r == 1)
				cnt++;
		}

		System.out.println(cnt);
	}
}
