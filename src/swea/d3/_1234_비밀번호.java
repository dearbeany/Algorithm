package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1234_비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			List<Integer> sList = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 문자열의 개수
			String str = st.nextToken();

			for (int i = 0; i < str.length(); i++) {
				sList.add(str.charAt(i) - '0');
			}

			while (erase(sList) >= 0) {
				int idx = erase(sList); // idx, idx+1 번째 지워져야 하는데
				sList.remove(idx); // idx 먼저 지우면 idx+1이 갱신되어서 idx가 됨
				sList.remove(idx);
			}

			System.out.printf("#%d ", tc);
			for (Integer i : sList) {
				System.out.print(i);
			}
			System.out.println();

		}

	}

	public static int erase(List<Integer> sList) {
		int idx = -1;
		for (int i = 0; i < sList.size() - 1; i++) {
			if (sList.get(i) == sList.get(i + 1)) {
				idx = i;
			}
		}
		return idx;
	}

}
