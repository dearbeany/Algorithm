package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 주의할 점
 * - BufferedWriter의 write()는 문자열만 작성가능하므로,
 *	 숫자를 작성하고 싶다면 toString()으로 문자를 변환해주어야 한다.
 * 
 */
public class _11047_동전0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 동전의 개수
		int K = Integer.parseInt(st.nextToken()); // 가치의 합

		List<Integer> list = new ArrayList<>(); // 동전의 가치가 담긴 리스트

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		int cnt = 0; // 필요한 동전의 개수

		for (int i = N - 1; i >= 0; i--) {
			if (list.get(i) <= K) { // 동전의 가치가 K보다 같거나 작다면
				cnt += K / list.get(i); // 동전의 개수는 K에서 가치를 나눈 몫 (K가 0보다 큰 동안 계속해서 동전가치만큼을 빼주기 때문)
				K = K % list.get(i); // K는 동전의 가치로 나눈 나머지임
			}
		}
		bw.write(Integer.toString(cnt));
//		bw.newLine(); 개행하는 법 

		bw.flush();
		bw.close();
	}
}
