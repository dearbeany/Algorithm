package boj.gold.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1197_최소스패닝트리_미통과 {
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

	static int V, E;
	static Edge[] eList;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		eList = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());

			eList[i] = new Edge(s, e, w);
		}

		Arrays.sort(eList); // 가중치 오름차순 정렬

		p = new int[V];
		for (int i = 0; i < V; i++) {
			p[i] = i; // makeSet
		}

		// 작은 간선부터 고르는데, 둘이 대표 같으면 패스
		// 다르면 disjoint 하므로 union한다

		int minCost = 0, pick = 0;
//		for (int i = 0; i < E; i++) {
//			int px = findSet(eList[i].s);
//			int py = findSet(eList[i].e);
//
//			if (px != py) {
//				union(px, py);
//				minCost += eList[i].w;
//				pick++;
//			}
//			if (pick != V - 1) {
//				break;
//			}
//		}
		for (Edge edge : eList) {
			if (edge.s != edge.e) {
				union(edge.s, edge.e);
				minCost += edge.w;
				pick++;
			}
			if (pick == V - 1) {
				break;
			}
		} // end of for
		System.out.println(minCost);
	}

	private static void union(int x, int y) {
//		p[y] = x;
		p[findSet(y)] = findSet(x);
	}

	private static int findSet(int x) {
		if (x == p[x]) {
			return x;
		}
		return p[x] = findSet(p[x]);
	}

}
