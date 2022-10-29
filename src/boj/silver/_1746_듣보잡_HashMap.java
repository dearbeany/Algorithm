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

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(br.readLine(), 1);
		}

		int cnt = 0;
		List<String> ans = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			String mStr = br.readLine();
			int value = map.getOrDefault(mStr, 2);
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
