package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2231_분해합2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// M의 분해합이 N이면, M은 N의 생성자
		// N의 가장 작은 생성자?

		// 216 = 198 + 1 + 9 + 8

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 분해합
		int M = 1;

		// N = M + (M의 자릿수의 합)
		// M을 1씩 늘려가면서 분해합을 검색

		while (N != M + digitSum(M)) {
			M++;
		}
		bw.write(M + "");
		bw.flush();
		bw.close();
	}

	// M의 자릿수 구하는 메소드
	private static int digitSum(int M) {
		int sum = 0;
		while (M > 0) {
			sum += M % 10;
			M /= 10;
		}
		return sum;
	}
}
