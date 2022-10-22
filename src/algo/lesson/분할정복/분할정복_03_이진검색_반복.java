package algo.lesson.분할정복;
public class 분할정복_03_이진검색_반복 {

	public static void main(String[] args) {
		int[] arr = { 8, 9, 17, 21, 23, 35, 88, 369 };
		
		System.out.println(binarySearch(arr, 19));
	}

	// boolean 반환 : 해당 찾고자 하는 숫자가 있는지 없는지 쳌
	// int 반환 : 해당 숫자가 있는 인덱스 반환
	static boolean binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			
//			int mid2 = left + (right-left)/2;
			
			if (arr[mid] == key)
				return true;
			//왼쪽구간을 탐색해야함
			else if (arr[mid] > key)
				right = mid - 1;
			//오른쪽구간을 탐색해야함
			else
				left = mid + 1;
		}

		return false;
	}
}