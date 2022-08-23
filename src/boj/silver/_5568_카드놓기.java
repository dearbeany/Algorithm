package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
 * n장 중 k장 선택해 만들 수 있는 정수의 개수 
 * 단 이 풀이는 2<=K<=4 이기에 가능..
 * 통과만 했음 DFS로 다시 풀어볼 것 !!
 */
public class _5568_카드놓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 카드의 개수
		int K = Integer.parseInt(br.readLine()); // 선택 개수

		int[] arr = new int[N];

		// 카드에 적힌 숫자들 세팅
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Set<Integer> set = new HashSet<>(); // 숫자들을 넣을 셋

		switch (K) {
		case 2: // 숫자 2개 선택할 때
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 자기가 자기를 뽑으면 안 됨 즉, 같은 숫자를 2번 뽑는 경우 방지
					if (i == j) {
						continue;
					}
					String s = Integer.toString(arr[i]) + Integer.toString(arr[j]);
					set.add(Integer.parseInt(s));
				}
			}
			break;

		case 3: // 숫자 3개 선택할 때
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if (i == j || i == k || j == k) {
							continue;
						}
						String s = Integer.toString(arr[i]) + Integer.toString(arr[j]) + Integer.toString(arr[k]);
						set.add(Integer.parseInt(s));
					}
				}
			}
			break;

		case 4: // 숫자 4개 선택할 때
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						for (int l = 0; l < N; l++) {
							if (i == j || i == k || i == l || j == k || j == l || k == l) {
								continue;
							}
							String s = Integer.toString(arr[i]) + Integer.toString(arr[j]) + Integer.toString(arr[k])
									+ Integer.toString(arr[l]);
							set.add(Integer.parseInt(s));

						}
					}
				}

			}
			break;
		}

		System.out.println(set.size());

	}
}
