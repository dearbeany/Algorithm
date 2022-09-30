package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _5431_민석이의과제체크 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 수강생 수
			int k = Integer.parseInt(st.nextToken()); // 과제 제출한 사람

			List<Integer> list = new ArrayList<>(); // 수강생들을 담는 리스트
			for (int i = 1; i < n + 1; i++) {
				list.add(i); // 번호대로 추가해주므로 추후에 오름차순 정렬할 필요 없음
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < k; i++) {
				int num = Integer.parseInt(st.nextToken()); // 과제 한 애들은 없애기
				list.remove(Integer.valueOf(num)); // num과 같은 값을 리스트에서 삭제
			}

			System.out.print("#" + tc + " ");
			for (Integer i : list) {
				System.out.print(i + " "); // 과제 안 한 애들만 출력
			}
			System.out.println();
		}
	}
}
