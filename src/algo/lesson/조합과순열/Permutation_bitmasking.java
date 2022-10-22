package algo.lesson.조합과순열;
import java.util.Arrays;

public class Permutation_bitmasking {
	static int[] nums;
	static int[] result;
	static int N;
	
	public static void main(String[] args) {
		nums = new int[] {1,2,3};
		N = nums.length;
		
		result = new int[N];
		
		perm(0, 0);
	}
	//idx : 내가 판단하는 위치
	//visited : 사용한 원소를 기록하기 위한 정수변수
	public static void perm(int idx, int visited) {
		//다른 표현?
//		if(visited == (1<<N)-1) //N! 일떄
		if(idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i = 0; i<N; i++) {
			//내가 현재 i번째 원소를 사용했는지 쳌
			if((visited & (1<<i)) != 0) continue;
			
			result[idx] = nums[i]; //해당 i번째 원소 저장
			perm(idx+1, visited | (1 << i));
		}
		
	}
}
