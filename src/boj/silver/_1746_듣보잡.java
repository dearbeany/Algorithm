package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * 듣지 못한 사람 N
 * 보지 못한 사람 M
 * 듣지 못한 && 보지 못한 사람 수, 이름 출력하기 
 * ArraysList contains를 쓰니 시간초과 났다.. set을 쓰자 
 */
public class _1746_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 듣지 못한
		int m = Integer.parseInt(st.nextToken()); // 보지 못한

		Set<String> nSet = new HashSet<>();
		for (int i = 0; i < n; i++) {
			nSet.add(br.readLine());
		}

		int cnt = 0; // 듣보잡 수
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			String mStr = br.readLine(); // 보지 못한 사람
			if (nSet.contains(mStr)) {
				cnt++;
				ans.add(mStr);
			}
		}

		Collections.sort(ans); // 사전 순 출력
		System.out.println(cnt);
		for (String s : ans) {
			System.out.println(s);
		}
	}
}
