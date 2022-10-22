package algo.lesson.분할정복;
import java.util.Arrays;

public class 분할정복_08_QuickSort_로무토파티션 {
	public static void main(String[] args) {
		int[] arr = { 77, 32, 37, 17, 22, 8, 13, 42, 26 };

		quickSort(arr, 0, arr.length - 1);

		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot - 1);
			quickSort(arr, pivot + 1, right);
		}
	}

	// 호어파티션을 쓰겠다.
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = left - 1; // i : pivot 보다 작은 값들의 경계

		for (int j = left; j < right; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		//pivot을 자기 위치로 보내기 위해서 swap
		swap(arr, i+1, right);
		return i+1;
	}

	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

}