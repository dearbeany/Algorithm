package swea.d4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _3124_최소스패닝트리_프림 {
	/*
	 * 최소 스패닝 트리 using Prim 1.인접 리스트를 활용 간선이 20만개로 희소 그래프라서... 인접배열 쓸 이유가? 2. pq를
	 * 쓰는건 다 똑같은데 그냥 계속 쌓아둘거야 비용과 3. 주의해야 될껀 뺐는데 이미 신장트리에 포함된거 일경우 무시하고 ㄱ
	 */
	static class Node {
		int vertex, weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}

	static class Vertex implements Comparable<Vertex> {
		int no, weight;

		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V, E;
	static boolean[] visited;
	static int[] minEdge;
	static PriorityQueue<Vertex> pq;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			Node[] adjList = new Node[V];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				int weight = Integer.parseInt(st.nextToken());
				
				adjList[from] = new Node(to, weight, adjList[from]);
				adjList[to] = new Node(from, weight, adjList[to]);
			}
			
			minEdge = new int[V];
			visited = new boolean[V];
			
			Arrays.fill(minEdge, Integer.MAX_VALUE);
			
			long result = 0;
			int cnt = 0;
			
			pq = new PriorityQueue<Vertex>();
			pq.offer(new Vertex(0, 0));
			
			while (true) {
				Vertex minVertex = pq.poll();
				
				if (visited[minVertex.no])
					continue;
				
				visited[minVertex.no] = true;
				result += minVertex.weight;
				
				if (++cnt == V)
					break;
				
				for (Node tmp = adjList[minVertex.no]; tmp != null; tmp = tmp.next) {
					if (!visited[tmp.vertex] && minEdge[tmp.vertex] > tmp.weight) {
						minEdge[tmp.vertex] = tmp.weight;
						pq.offer(new Vertex(tmp.vertex, minEdge[tmp.vertex]));
					}
				}
			}
			sb.append("#" + t + " " + result + "\n");
		}
		System.out.println(sb);
	}

}