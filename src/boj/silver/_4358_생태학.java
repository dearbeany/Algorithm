package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class _4358_생태학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String name = null;

		Map<String, Integer> map = new TreeMap<>();

		while ((name = br.readLine()) != null) {
			// 아무것도 없으면 1 넣고
			// 이미 들어있으면 1 더해서 넣고

			if (map.containsKey(name)) {
				int value = map.get(name);
				map.put(name, ++value);
			} else {
				map.put(name, 1);
			}
		}
		System.out.println(map);
	}
}
