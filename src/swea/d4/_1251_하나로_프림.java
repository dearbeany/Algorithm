package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1251_하나로_프림 {
	static class Node implements Comparable<Node> {
		int s, e;
		double w;

		Node(int s, int e, double w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			if (this.w > o.w) {
				return 1;
			} else if (this.w < o.w) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	static int V; // 섬 개수(정점)
	static int[][] island;
	static double tax;
	static boolean[] visited;
	static Double[] dist;
	static List<Node>[] adjList;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// minCost = 환경 부담세율(E) * 해저터널길이(L)^2

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st, st2;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			V = Integer.parseInt(br.readLine()); // 섬의 개수

			island = new int[V][2]; // 0 : x, 1: y

			st = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < V; i++) {
				island[i][0] = Integer.parseInt(st.nextToken());
				island[i][1] = Integer.parseInt(st2.nextToken());
			}

			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++) {
				adjList[i] = new ArrayList<>();
			}

			dist = new Double[V];
			Arrays.fill(dist, Double.MAX_VALUE);

			tax = Double.parseDouble(br.readLine()); // 환경부담세율

			// 가중치를 구해보자
			for (int i = 0; i < V - 1; i++) {
				for (int j = i; j < V; j++) {
					int distX = Math.abs(island[i][0] - island[j][0]);
					int distY = Math.abs(island[i][1] - island[j][1]);
					double w = Math.pow(distX, 2) + Math.pow(distY, 2);

					adjList[i].add(new Node(i, j, w));
					adjList[j].add(new Node(j, i, w));
				}
			}

			prim(0);

			double minCost = 0; // 최소비용
			for (int i = 0; i < V; i++) {
				minCost += tax * dist[i];
			}
			System.out.println("#" + tc + " " + Math.round(minCost));
		}

	}

	private static void prim(int st) {
		visited = new boolean[V];
		pq = new PriorityQueue<>();
		pq.addAll(adjList[st]);
		dist[st] = (double) 0;
		visited[st] = true;

		int pick = 1;
		while (pick < V) {
			Node n = pq.poll();

			if (!visited[n.e] && dist[n.e] > n.w) {
				dist[n.e] = n.w;
				visited[n.e] = true;
				pq.addAll(adjList[n.e]);
				pick++;
			}
		}
	}
}
