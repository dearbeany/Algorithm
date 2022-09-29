package boj.gold.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1197_최소스패닝트리_크루스칼 {
	static int V, E;
	static int[] parents;
	static Edge[] edgeList;

	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static void make() {
		parents = new int[V];

		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;

		stz = new StringTokenizer(br.readLine());
		V = Integer.parseInt(stz.nextToken());
		E = Integer.parseInt(stz.nextToken());
		edgeList = new Edge[E];

		for (int i = 0; i < E; i++) {
			stz = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stz.nextToken()) - 1;
			int end = Integer.parseInt(stz.nextToken()) - 1;
			int weight = Integer.parseInt(stz.nextToken());
			edgeList[i] = new Edge(start, end, weight);
		}

		Arrays.sort(edgeList);

		make();

		int cnt = 0;
		long result = 0;

		for (Edge edge : edgeList) {
			if (union(edge.start, edge.end)) {
				result += edge.weight;
				if (++cnt == V - 1)
					break;
			}
		}

		System.out.println(result);

	} // main
}
