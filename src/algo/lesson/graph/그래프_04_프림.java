package algo.lesson.graph;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 프림 알고리즘 -> '정점' 선택해 MST 만들어 가기 
 * (1) 임의 정점 하나 선택
 * - 아무거나 선택해도 되는 이유? 결과적으로 모든 정점을 선택하기 때문 
 * (2) 선택 정점과 인접 정점들 중 최소비용 간선인 정점을 선택 
 * (3) 모든 정점 선택할 때까지 (1),(2) 반복 
 */

public class 그래프_04_프림 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // V : 정점의 개수 정점은 0번부터 시작한다
		int E = sc.nextInt(); // E : 간선의 개수

		// 간선의 정보를 저장한다
		// 인접행렬을 사용한다
		int[][] adjArr = new int[V][V];

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt(); // 시작 정점
			int ed = sc.nextInt(); // 도착 정점
			int w = sc.nextInt(); // 가중치

			adjArr[st][ed] = w;
			adjArr[ed][st] = w;
		}

		boolean[] visited = new boolean[V]; // 정점을 방문했는지
		int[] p = new int[V]; // 정점이 어디서 왔는지 즉, 부모를 저장
		int[] keys = new int[V]; // 정점에 연결된 간선 중 최소 가중치

		// keys 들을 무한대의 값으로 갱신해준다
		Arrays.fill(keys, Integer.MAX_VALUE);

		// 임의 정점을 선택해서 돌린다. 0번부터 시작한다
		p[0] = -1; // 0번이 시작점이다
		keys[0] = 0; // 모든 정점의 key들은 무한대이므로 시작정점의 key는 0으로 초기화 해둠

		int minCost = 0; // 최소값, 인덱스, MST 최소비용의 합

		// 프림 만들기
		// for는 V개수만큼 돌던 (V-1)개까지 돌던 차이 없음
		for (int i = 0; i < V - 1; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;

			// 아직 안 뽑힌 정점들 중 가장 작은 값을 뽑는다
			for (int j = 0; j < V; j++) {
				if (!visited[j] && keys[j] < min) {
					min = keys[j];
					idx = j;
				}
			} // 이 for문이 끝나면 idx엔 이번에 선택한 정점이 들어있다
			visited[idx] = true; // idx번째 정점을 선택했다

			// 선택한 정점과 연결된 간선들을 갱신할 수 있으면 갱신하자
			for (int j = 0; j < V; j++) {
				// 방문하지 않았고 && 간선이 있으면 갱신
				// 단, 방문한 친구는 이미 최소값이기에 갱신이 일어나지 않는다 (사실 방문은 체크 안해도 됨)
				if (!visited[j] && adjArr[idx][j] != 0 && keys[j] > adjArr[idx][j]) {
					keys[j] = adjArr[idx][j];
					p[j] = idx;
				}
			}
		} // 프림 만들기

		for (int i = 0; i < V; i++) {
			minCost += keys[i];
		}

		System.out.println(minCost);
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
