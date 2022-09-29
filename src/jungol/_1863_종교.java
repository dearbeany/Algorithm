package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 입력쌍에 대하여 union을 한다
 * 2. 결과적으로 p에는 대표자의 인덱스만이 남는다
 * 3. set을 사용하여 개수를 카운트 하면 종교의 가지수가 출력됨 
 */

public class _1863_종교 {

	static int[] p, rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 학생의 수
		int m = Integer.parseInt(st.nextToken()); // 쌍의 수

		rank = new int[n + 1]; // 트리 깊이
		p = new int[n + 1]; // 부모, 즉 대표자 배열
		for (int i = 1; i < n + 1; i++) {
			p[i] = i; // makeSet
		}
		// 무향 그래프다. 1,2 나 2,1이나 연결된 건 같다.
		// 대표가 다르면 +1 해준다

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}

//		System.out.println(Arrays.toString(p));
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (p[i] == i) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static void union(int a, int b) {
//		p[findSet(y)] = findSet(x); <- 이 예제에선 이것만으로도 통과했음 

		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (rank[aRoot] < rank[bRoot]) {
			p[aRoot] = bRoot;
		} else {
			p[bRoot] = aRoot;
			if (rank[aRoot] == rank[bRoot]) {
				rank[aRoot]++;
			}
		}
	}

	private static int findSet(int x) {
//		if (x != p[x]) {
//			p[x] = findSet(p[x]);
//		}
//		return p[x];
		if (x == p[x]) {
			return x;
		}
		return p[x] = findSet(p[x]);
	}

	static String input = "10 9\r\n" + "1 2\r\n" + "1 3\r\n" + "1 4\r\n" + "1 5\r\n" + "1 6\r\n" + "1 7\r\n" + "1 8\r\n"
			+ "1 9\r\n" + "1 10";
}
