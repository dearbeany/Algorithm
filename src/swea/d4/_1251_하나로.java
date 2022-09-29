package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1251_하나로 {
	static class Node {
		int idx, dis;

		Node(int idx, int dis) {
			this.idx = idx;
			this.dis = dis;
		}
	}

	static int V; // 섬 개수
	static int[][] island;
	static double tax;
	static int[] p;
	static boolean[] visited;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// minCost = 환경 부담세율(E) * 해저터널길이(L)^2
		// 가중치를 따로 입력받지 않았다. 가중치는 정점 사이의 거리(해저터널의 길이)다

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			V = Integer.parseInt(br.readLine()); // 섬의 개수
			pq = new PriorityQueue<>();

			p = new int[V];
			visited = new boolean[V];

			for (int i = 0; i < V; i++) {
				p[i] = i; // makeSet
			}

			island = new int[V][2];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < V; i++) {
				island[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < V; i++) {
				island[i][1] = Integer.parseInt(st.nextToken());
			}

			tax = Double.parseDouble(br.readLine()); // 환경부담세율

			int dist[] = new int[V]; // 정점에 연결된 간선 중 최소 가중치
			Arrays.fill(dist, Integer.MAX_VALUE);

			p[0] = -1;
			dist[0] = 0;

			int minCost = 0;

			for (int i = 0; i < V; i++) {
				int min = Integer.MAX_VALUE;
				int idx = -1;

				for (int j = 0; j < V; j++) {
					if (!visited[j] && dist[j] < min) {
						min = dist[j];
						idx = j;
					}
				}
				visited[idx] = true;
				for (int j = 0; j < V; j++) {
					int len = (int) Math.sqrt(Math.pow(island[idx][0] - island[j][0], 2));
					if (!visited[j] && dist[V] != 0) {

					}
				}

//				if(!visited[j] && ) {
//					
//				}
			}
		}
	}

//	private static int isWeight(Node n1, Node n2) {
//		return (int) Math.sqrt((Math.pow(n1.x - n2.x, 2) + Math.pow(n1.y - n2.y, 2)));
//	}

}
