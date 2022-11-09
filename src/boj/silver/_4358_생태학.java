package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class _4358_생태학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<String, Integer> map = new TreeMap<>(); // 나무 종류, 개수

		int total = 0;
//		String name = br.readLine(); // 나무 종이름
		String name;

		while ((name = br.readLine()) != null) {
			total++;
			int value = map.getOrDefault(name, -1); // name 있으면 키에 해당하는 값, 없으면 -1

			if (value == -1) {
				map.put(name, 1);
			} else {
				int newVal = map.get(name);
				map.put(name, newVal + 1);
			}

//			name = br.readLine();
//			if (name == null || name.length() == 0) {
//				break;
//			}
		}

		for (String key : map.keySet()) {
			double value = map.get(key);
			String ratio = String.format("%.4f", value / total * 100);
			System.out.println(key + " " + ratio);
		}

//		System.out.println(map);
//		System.out.println(total);
	}
}
