package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 중위순회 :Left - Root - Right
 * S O F T W A R E
 */
public class _1231_중위순회_재귀 {

	static int N;
	static String[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int T = 10; // 테스트케이스

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 노드의 수

			arr = new String[N + 1]; // 인덱스 0번은 버리기 때문에 배열의 크기 N+1로 설정

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				arr[idx] = st.nextToken(); // 노드번호를 배열의 인덱스로 이용
			}

//			System.out.println(Arrays.toString(arr));
//			[null, W, F, R, O, T, A, E, S]

			System.out.print("#" + tc + " ");
			inorder(1); // 중위순회
			System.out.println();

		}
	}

	public static void inorder(int idx) {
		if (idx > N) // 인덱스가 배열의 크기 넘으면
			return;
		inorder(2 * idx); // left
		System.out.print(arr[idx]); // root
		inorder(2 * idx + 1); // right
	}

}
