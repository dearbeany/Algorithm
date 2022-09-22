
public class 분할정복_01_거듭제곱_반복 {
	public static void main(String[] args) {
		int C = 2;
		int N = 10;
		
		System.out.println(pow(C,N));
	}
	
	static int pow(int C, int N) {
		int result = 1;
		//개인취향
		for(int i = 1 ; i<=N; i++) {
//			result *= C;
			result = result * C;
		}
		
		return result;
	}
}
