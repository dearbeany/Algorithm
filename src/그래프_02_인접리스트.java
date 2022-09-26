import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_02_인접리스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 정점의 개수를 입력받는다 시작정점이 0번인지 1번인지
		int E = sc.nextInt();

		List<Integer>[] adjList = new ArrayList[V + 1];

		for (int i = 0; i < V + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 간선 입력
		for (int i = 0; i < E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			adjList[start].add(end);
			adjList[end].add(start);
		}
		// 인접행렬 단점 : 간선의 수 작으면 배열로 선언한 공간들이 낭비된다
		// -> 인접리스트의 등장
	}
}
