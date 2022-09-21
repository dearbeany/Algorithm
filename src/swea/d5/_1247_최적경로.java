package swea.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1247_최적경로 {
	static class Node {
		int x;
		int y;
		int id;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		Node(int x, int y, int id) {
			this.x = x;
			this.y = y;
			this.id = id;
		}

	}

	static int N; // 고객의 수
	static int minDis; // 최단 경로의 이동거리
	static int x, y; // x좌표 y좌표
	static List<Node> clist; // 고객의 위치를 담는 리스트
	static int[] res; // 고객 사이의 거리를 담는 배열
	static boolean[] visited;
	static Node company, home;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테케

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 고객 수
			st = new StringTokenizer(br.readLine());

			// 회사 좌표 생성
			company = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			// 집 좌표 생성
			home = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			// 고객의 위치 생성
			clist = new ArrayList<>();
			res = new int[N];
			visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				Node client = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
				clist.add(client);
			}
			minDis = Integer.MAX_VALUE;
			perm(0);

			// 고객들을 순열로 나열하고 그 때마다
			// 회사 - 고객1 + 고객n- 집 + 고객끼리의 이동거리를 계산한다
			System.out.printf("#%d %d\n", tc, minDis);
		}
	}

	static void perm(int idx) {
		if (idx == N) {
			int dis = 0;
			for (int i = 0; i < N - 1; i++) {
				// 고객끼리의 거리 구하기
				int x1 = clist.get(i).x;
				int x2 = clist.get(i + 1).x;
				int y1 = clist.get(i).y;
				int y2 = clist.get(i + 1).y;

				dis += Math.abs(x1 - x2) + Math.abs(y1 - y2);

				// 회사 - 직원1, 직원n - 집 거리 더해줘야함
				dis += Math.abs(company.x - clist.get(0).x) + Math.abs(company.y - clist.get(0).y);
				dis += Math.abs(home.x - clist.get(N - 1).x) + Math.abs(home.y - clist.get(N - 1).y);
			}
			if (minDis > dis) {
				minDis = dis;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}
			res[i] = clist.get(i).id;
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}

}
