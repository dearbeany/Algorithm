import java.util.Arrays;

public class 분할정복_05_이진검색_API {

	public static void main(String[] args) {
		int[] arr = { 8, 9, 17, 21, 23, 35, 88, 369 };
		
		
		//맞았을때는 올바른 인덱스가 나오는것 같다.
		//다를때는 ???
		System.out.println(Arrays.binarySearch(arr, 10));
	}

}