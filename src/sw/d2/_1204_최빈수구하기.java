package sw.d2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class _1204_최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 10개

		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt(); // 테스트케이스 번호

			// key = 입력받는 숫자, value = 빈도수가 저장됨
			Map<Integer, Integer> map = new HashMap<>();
			int findKey = 0;

			for (int i = 0; i < 1000; i++) {
				int n = sc.nextInt();
				if (map.get(n) == null) { // 입력받는 키인 n에 저장된 값이 없으면(즉 카운트된 값 value가 0이면)
					map.put(n, 1); // 처음에 카운트 +1
				} else { // 이미 map에 존재하는 값이면
					int val = map.get(n);
					map.put(n, ++val);
				}
			} // end of for 학생의 수

			int max = 0; // 가장 큰 빈도수

			// value에 저장된 카운트된 값 중 max 찾기
			Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Entry<Integer, Integer> entrySet = (Entry<Integer, Integer>) it.next();
				max = Math.max(entrySet.getValue(), max);
			}

			// 최빈수가 같은 경우 수가 여러 개일 때 ?
			// value에 해당하는 key값 찾기
			for (Integer key : map.keySet()) {
				int cnt = 0;
				if (map.get(key).equals(max)) {
					if (cnt == 0) {
						findKey = key;
						cnt++;
					} else {
						// 최빈수가 여러 개일 경우 가장 큰 점수인 key로 설정
						findKey = Math.max(findKey, key);
					}
				}

			}

			System.out.printf("#%d %d\n", tc, findKey);
		} // end of for tc
	}
}
