
public class 분할정복_02_거듭제곱_재귀 {
	
	public static void main(String[] args) {
		int C = 2;
		int N = 20;
		
		
		System.out.println(pow2(C,N));
	}
	
	
	static int pow2(int C,  int N) {
		//기저 조건
		if(N == 1) return C;
		
		int result;
		//유도 조건
		//짝수일때
		if(N%2 == 0) {
			result = pow2(C, N/2);
			return result*result;
		}
		else {
			result = pow2(C, (N-1)/2);
			return result*result*C;
		}
	}
	static int pow(int C,  int N) {
		//기저 조건
		if(N == 1) return C;
		
		//유도 조건
		//짝수일때
		if(N%2 == 0)
			return pow(C, N/2) * pow(C, N/2);
		//홀수일때
		else
			return pow(C, (N-1)/2) * pow(C, (N-1)/2) * C;
	
	}
}
