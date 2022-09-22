public class 분할정복_04_이진검색_재귀 {

	public static void main(String[] args) {
		int[] arr = { 8, 9, 17, 21, 23, 35, 88, 369 };
		
		System.out.println(binarySearch(arr, 21, 0, arr.length-1));
	}

	// boolean 반환 : 해당 찾고자 하는 숫자가 있는지 없는지 쳌
	// int 반환 : 해당 숫자가 있는 인덱스 반환
	static boolean binarySearch(int[] arr, int key, int left, int right) {
		if(left> right) return false; //못찾았어
		
		int mid = (left+right)/2;
		
		if(arr[mid] == key) return true;
		else if(arr[mid] > key)
			return binarySearch(arr, key, left, mid-1);
		else
			return binarySearch(arr, key, mid+1, right);
	}
}