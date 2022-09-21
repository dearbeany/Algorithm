package swea.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1247_최적경로2 {
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
	static int[] res; // 고객 사이의 거리를 담는 배열
	static boolean[] visited;
	static Node company, home;
	static Node[] clist; // 고객의 위치를 담는 리스트

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
			clist = new Node[N];
			res = new int[N];
			visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				clist[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);

			}
			minDis = Integer.MAX_VALUE;
			perm(0, company);

			// 고객들을 순열로 나열하고 그 때마다
			// 회사 - 고객1 + 고객n- 집 + 고객끼리의 이동거리를 계산한다
			System.out.printf("#%d %d\n", tc, minDis);
		}
	}

	static void perm(int idx, Node cur) {
		if (idx == N) {
			int dis = 0;
			for (int i = 0; i < N - 1; i++) {
				// 고객끼리의 거리 구하기
				dis += getDist(clist[i].x, clist[i + 1].x) + getDist(clist[i].y, clist[i + 1].y);

				// 회사 - 직원1, 직원n - 집 거리 더해줘야함
				dis += Math.abs(home.x - clist[N - 1].x) + Math.abs(home.y - clist[N - 1].y);
			}
			minDis = Math.min(minDis, dis);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			perm(idx + 1, clist[idx]);
			visited[i] = false;
		}
	}

	static int getDist(int x, int y) {
		return Math.abs(x - y);
	}

}
