package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1929_소수구하기 {

	static int[] a = new int[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// M이상 N이하의 범위에서 증가하는 순서대로 순서를 출력한다
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		// 인덱스에 따른 값 세팅
		for (int i = 2; i <= N; i++) {
			a[i] = i;
		}

		// 2부터 시작해서 특정 숫자의 배수를 지워나간다
		for (int i = 2; i <= N; i++) {
			if (a[i] == 0) { // 이미 지웠으면
				continue;
			}

			// 아직 안 지웠으면
			// 특정 숫자의 배수부터 출발하여 가능한 모든 숫자를 다 지워준다
			for (int j = i + i; j <= N; j += i) {
				a[j] = 0;
			}
		}

		// 남은 숫자들을 출력한다
		for (int i = M; i <= N; i++) {
			if (a[i] != 0) {
				bw.write(a[i] + "\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
