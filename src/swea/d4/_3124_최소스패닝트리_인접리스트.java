package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3124_최소스패닝트리_인접리스트 {
	static class Edge implements Comparable<Edge> {
		int s, e, w;

		Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", w=" + w + "]";
		}

	}

	static Edge[] eList;
	static int V, E;
	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테케

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점의 개수
			E = Integer.parseInt(st.nextToken()); // 간선의 개수

			eList = new Edge[E];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;
				int w = Integer.parseInt(st.nextToken());
				eList[i] = new Edge(s, e, w);
			}

//			for (Edge e : eList) {
//				System.out.println(e);
//			}

			Arrays.sort(eList);

			p = new int[V];
			for (int i = 0; i < V; i++) {
				p[i] = i; // makeSet
			}

			long minCost = 0;
			int pick = 0;

			for (Edge edge : eList) {
				if (union(edge.s, edge.e)) {
					minCost += edge.w;
					pick++;
				}
				if (pick == V - 1) {
					break;
				}
			}
			sb.append("#").append(tc).append(" ").append(minCost).append("\n");
		} // end of for
		System.out.println(sb);
	} // end of main

	private static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (px == py) {
			return false;
		}
		p[py] = px;
		return true;
	}

	private static int findSet(int x) {
		if (x == p[x]) {
			return x;
		}
		return p[x] = findSet(p[x]);
	}
}
