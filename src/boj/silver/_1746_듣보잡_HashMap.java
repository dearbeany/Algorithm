package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * Key : 사람이름 
 * Value : Map에 들어간 횟수 (듣지못함 =1 보지못함 =2)
 *
 * getOrDefault(Object key, V defaultValue)
 * : key 가 맵에 있으면 Value를 반환, 없으면 defaultValue 반환 
 * 
 */
public class _1746_듣보잡_HashMap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 듣지 못함
		int m = Integer.parseInt(st.nextToken()); // 보지 못함

		Map<String, Integer> map = new HashMap<>(); // 듣지 못한 사람 1넣고
		for (int i = 0; i < n; i++) {
			map.put(br.readLine(), 1);
		}

		int cnt = 0; // 듣보잡 수
		List<String> ans = new ArrayList<>(); // 듣보잡 리스트

		for (int i = 0; i < m; i++) {
			String mStr = br.readLine(); // 보지 못한 사람
			int value = map.getOrDefault(mStr, 2); // 보지못한 사람이 맵에 있으면(즉 듣지도 못했음, 듣보잡) 1, 없으면 2를 반환
			if (value == 1) {
				cnt++;
				ans.add(mStr);
			}
		}

		Collections.sort(ans);
		System.out.println(cnt);
		for (String s : ans) {
			System.out.println(s);
		}
	}
}
