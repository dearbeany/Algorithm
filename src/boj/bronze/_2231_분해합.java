package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2231_분해합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// M의 분해합이 N이면, M은 N의 생성자
		// N의 가장 작은 생성자?

		// 216 = 198 + 1 + 9 + 8
		// N = M + (M의 자릿수의 합)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 분해합

		for (int m = 0; m < N; m++) {
			int sum = 0;
			int M = m; // 자릿수의 합 구하기 위한 변수
			sum += m;

			// 자릿수의 합 구하기
			while (M > 0) {
				sum += M % 10;
				M /= 10;
			}

			if (N == sum) {
				bw.write(m + "");
				break;
			}
			if (m == (N - 1)) {
				bw.write(0 + "");
			}
		}

		bw.flush();
		bw.close();
	}

}
