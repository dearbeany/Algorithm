package swea.d5;

public class _1247_최적경로_상태공간트리 {
	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, ans;
	static boolean[] visited;
	static Node[] arr;
	static Node com, home;

	public static void main(String[] args) {

	}

	static void solve(int idx, int dist, Node cur) {
		if (dist >= ans)
			return;

		if (idx == N) {
			dist += (Math.abs(cur.x - home.x) + Math.abs(cur.y - home.y));
			ans = Math.min(ans, dist);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			solve(idx + 1, dist + (Math.abs(cur.x - arr[i].x) + Math.abs(cur.y - arr[i].y)), arr[i]);
			visited[i] = false;
		}
	}

}
