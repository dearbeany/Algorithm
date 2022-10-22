package algo.lesson.분할정복;
import java.util.Arrays;

public class 분할정복_06_MergeSort {
	static int[] sortedArr;

	public static void main(String[] args) {
		int[] arr = { 77, 32, 37, 17, 22, 8, 13, 42, 26 };
		sortedArr = new int[arr.length];

		System.out.println("정렬전: " + Arrays.toString(arr));
		mergeSort(arr, 0, arr.length-1);
		System.out.println("정렬후: " + Arrays.toString(arr));
	}

	// arr : 내가 정렬하고자 하는 배열 / left ,right 경계,위치
	public static void mergeSort(int[] arr, int left, int right) {
		// 개취
//		if(left >= right) return;
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid); // 왼쪽 절반 분할
			mergeSort(arr, mid + 1, right); // 오른쪽 절반 분할
			merge(arr, left, mid, right); // 분할된 집합 병합
		}
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		int L = left; // 왼쪽 구간 시작 인덱스
		int R = mid + 1; // 오른쪽 구간 시작 인덱스
		int idx = left; // 정렬된 원소 저장할 위치

		// 서로 구간의 값이 남아있는경우 비교하면서 집어넣기
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R])
				sortedArr[idx++] = arr[L++]; // 값들을 넣고 증가시킨다.
			else
				sortedArr[idx++] = arr[R++];
		}

		// 왼쪽구간이 남았다면
		if (L <= mid) {
			for (int i = L; i <= mid; i++)
				sortedArr[idx++] = arr[i];
		}
		// 오른쪽구간이 남았다면
		else {
			for (int i = R; i <= right; i++)
				sortedArr[idx++] = arr[i];
		}

		// 정렬한 임시배열을 원 배열에 저장한다.
		for (int i = left; i <= right; i++)
			arr[i] = sortedArr[i];

		System.out.println(Arrays.toString(arr));

	}
}
