import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_03_간선배열 {
	static class Edge {
		int start, end;

		public Edge(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		// 2가지 방법으로 사용 가능
		Edge[] edges = new Edge[E];
		List<Edge> edges2 = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			edges[i] = new Edge(start, end);
		}

	}

}
