package algo.lesson.comb;
import java.util.Arrays;

public class Permutation_visited {
	static int[] nums;
	static boolean[] visited; // 해당 원소를 사용했다면 쳌
	static int[] result; // 순열의 결과를 저장하기 위해서 사용
	static int N;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;

		result = new int[N];
		visited = new boolean[N];

		perm(0);
	}

	public static void perm(int idx) {
		// 기저조건
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		// 사용하지 않은 원소라면 사용하고 넘어가기
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue; // 사용했다면 넘어가
			result[idx] = nums[i];
			visited[i] = true; // 썼다.
			perm(idx + 1); // 내려가
			visited[i] = false; // 안썼다.

//			if(!visited[i]) {
//				//사용하지 않았았다면 작성하는 방식을 취하던지..
//			}
		}
	}
}