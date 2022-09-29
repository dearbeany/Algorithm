package algo.lesson.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
 * 크루스칼 알고리즘 -> '간선' 선택해서 MST 찾기  
 * 
 * (1) 간선을 가중치 기준 오름차순 정렬
 * (2) 가중치 낮은 간선부터 선택
 * - 단, 사이클 형성여부 확인해 (findSet) 대표가 다를 경우(disjoint set)만 union
 * (3) 선택된 간선이 (V-1)개일 때까지 (2) 반복 
 *  
 */

public class 그래프_03_크루스칼_간선배열 {
	static int[] p; // 대표를 저장할 배열

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // V : 정점의 개수 정점은 0번부터 시작한다
		int E = sc.nextInt(); // E : 간선의 개수

		// 간선 배열로 그래프를 구현
		int[][] edges = new int[E][3];

		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt(); // 시작 정점
			edges[i][1] = sc.nextInt(); // 도착 정점
			edges[i][2] = sc.nextInt(); // 가중치
		}

		// 1. 크루스칼 만들기 위해 가중치를 기준으로 오름차순 정렬

		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2]; // [2]값이 가중치임
			}
		});
//		print(edges); // 가중치가 오름차순 정렬 됐는지 확인하자

		p = new int[V]; // 각 정점의 대표를 저장하는 배열

		// makeSet을 한다. 나 자신을 대표로 한다
		for (int i = 0; i < V; i++) {
			makeSet(i);
		}

		// 2. MST 만들기 위해 가중치 낮은 간선부터 (V-1)개까지 선택

		int minCost = 0; // 최소비용, 즉 가중치들의 합
		int pick = 0; // 선택된 간선의 개수

		for (int i = 0; i < E; i++) {
			// 선택한 간선이 사이클을 형성하는지 확인해야 한다
			// i번째 간선을 뽑아서 두 정점의 대표를 check
			// 대표가 같다면 pass
			// 대표가 다르면 둘은 disjoint한 집합이므로 union -> minCost 추가, pick++

			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);

			if (px != py) {
				union(px, py);
				minCost += edges[i][2];
				pick++;
			}

			if (pick == V - 1)
				break;

		}
		System.out.println(minCost);

	} // end of main

	private static void union(int x, int y) {
//		p[findSet(y)] = findSet(x);
		p[y] = x; // 이번 문제는 어차피 x, y를 대표값을 넣어주므로 해도됨.
	}

	// 원소 x의 대표를 가져온다
	private static int findSet(int x) {
//		if (x == p[x]) {
//			return x;
//		} else {
//			return findSet(p[x]);
//		}

		// Path compression이 적용됨
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

	// x를 대표자로 만든다
	private static void makeSet(int x) {
		p[x] = x; // 나 자신을 대표로 한다
	}

	// 간선배열을 프린트 해보기
	public static void print(int[][] edges) {
		for (int[] e : edges) {
			System.out.println(Arrays.toString(e));
		}
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
