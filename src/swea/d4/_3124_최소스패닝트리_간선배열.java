package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _3124_최소스패닝트리_간선배열 {
	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테케

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); // 정점의 개수
			int E = Integer.parseInt(st.nextToken()); // 간선의 개수

			int[][] edges = new int[E][3]; // 간선 배열
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				edges[i][0] = Integer.parseInt(st.nextToken()); // 시작 정점
				edges[i][1] = Integer.parseInt(st.nextToken()); // 도착 정점
				edges[i][2] = Integer.parseInt(st.nextToken()); // 가중치
			}

			// 가중치 기준 정렬
			Arrays.sort(edges, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});

			p = new int[V + 1];

			for (int i = 0; i < V + 1; i++) {
				p[i] = i; // makeSet
			}

			int minCost = 0, pick = 0;

			for (int i = 0; i < E; i++) {
				int px = findSet(edges[i][0]);
				int py = findSet(edges[i][1]);

				if (px != py) {
					union(px, py);
					minCost += edges[i][2];
					pick++;
				}

				if (pick == V - 1) {
					break;
				}
			}
			System.out.printf("#%d %d\n", tc, minCost);
		}
	}

	private static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

	private static int findSet(int x) {
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
}
