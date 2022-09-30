package algo.lesson.divideconquer;
import java.util.Arrays;

public class 분할정복_07_QuickSort_호어파티션 {
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
		int pivot = arr[left]; // 제일 왼쪽을 피폿이라고 했으니

		int L = left + 1, R = right; // 시작구간은 한칸 옆부터 끝까지
		int tmp;
		
		// 교차가 되는 순간 멈춰~~
		while (L <= R) {
			//L : pivot보다 큰값을 찾을 때까지 이동하겠다.
			//요기 앞에 조건을 빼면 왜인지는 모르겠는데 안됨 (저는 아는데 여러분들은 모를까봐 마[음의]숙[제]) {33,99,99};
			while(L<=R && arr[L] <= pivot) L++;
			//R : pivot보다 작거나 같은 값을 만나때 까지 이동하겠다.
			while(arr[R] > pivot) R--;
			
			//L과 R의 값을 서로 바꾼다.
			if(L<R) {
				tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		//pivot이 가리키는 값과 R이 가리키는 값을 바꾸어 pivot의 위치를 결정한다.
		tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		
		return R;
	}

}