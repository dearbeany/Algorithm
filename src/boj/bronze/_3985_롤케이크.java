package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _3985_롤케이크 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int L = Integer.parseInt(br.readLine()); // 롤케이크의 길이
		int N = Integer.parseInt(br.readLine()); // 방청객의 수

		int[] cake = new int[L + 1]; // 롤케이크
		int[] counts = new int[N + 1]; // 방청객 수 카운트를 위한 배열

		int hopeMax = 0, max = 0; // 가장 많은 조각 받을 거라 기대한 방청객 번호
		int actualMax = 0; // 실제로 가장 많은 조각 받은 방청객 번호

		// 방청객 수만큼 받고싶은 롤케이크 조각의 시작, 끝 수를 입력 받음
		for (int nc = 1; nc <= N; nc++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); // 시작조각
			int end = Integer.parseInt(st.nextToken()); // 끝조각

			if (end - start > max) {
				max = end - start;
				hopeMax = nc;
			}
			for (int i = 1; i < cake.length; i++) { // 1번째 조각부터 시작
				for (int j = start; j <= end; j++) {
					if (cake[j] != 0) { // 이미 방청객 번호 채워져 있으면
						continue; // 그냥 넘김
					}
					cake[j] = nc; // 기대하는 조각에 방청객 번호 씀
				}
			}

		}
		for (int i = 0; i < cake.length; i++) { // 롤케익 배열은 1조각부터 시작하므로 인덱스 0엔 아무값 X
			if (cake[i] == 0) {
				continue;
			} else {
				counts[cake[i]]++; // counts의 인덱스 == 방청객의 번호
			}
		}

		int maxIdx = 0;
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] > actualMax) {
				actualMax = counts[i];
				maxIdx = i;
			}
		}
		System.out.println(hopeMax);
		System.out.println(maxIdx);

	}
}
