import java.util.Arrays;

public class Permutation_swap {
	static int[] nums;
	static int N;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;

		perm(0);
	}

	// idx : 현재 판단하는 위치
	static void perm(int idx) {
		if (idx == N) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = idx; i < N; i++) {
			swap(i, idx);
			perm(idx + 1);
			swap(i, idx); /// 원상복구 하는 과정이 꼭필요함.
		}

	}

	// swap
	// 인자로 배열과 바꿀 인덱스를 2개를 넘기던지
	// static 하게 선언을 해놓았으니 인자 두개를 넘겨서 교환하던지
	static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
