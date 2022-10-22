package algo.lesson.그래프;
import java.util.Scanner;

public class 그래프_02_인접행렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 정점의 개수를 입력받는다 시작정점이 0번인지 1번인지
		int E = sc.nextInt();

		int[][] adjArr = new int[V + 1][V + 1]; // 정점이 1번부터 시작할 때 인덱스를 조정하지 않아도 돼서 유리함

		// 간선 입력
		for (int i = 0; i < E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			adjArr[start][end] = 1; // 유향 그래프라면 이것만 작성
			adjArr[end][start] = 1; // 무향 그래프일 경우 이도 같이 작성해줘야 한다
		}
		// 인접행렬 단점 : 간선의 수 작으면 배열로 선언한 공간들이 낭비된다
		// -> 인접리스트의 등장
	}
}
