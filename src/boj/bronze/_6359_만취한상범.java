package boj.bronze;
import java.util.Scanner;

public class _6359_만취한상범 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			int n = sc.nextInt();	// 주어진 방의 개수 
			int cnt = 0; // 열린 방의 개수 
			
			// true = 열림 false = 닫힘 
			boolean[] door = new boolean[n]; // false 로 모두 초기화 
			
			for(int round = 1; round <= n; round++) {
				for(int i = 0; i < n; i++) {
					if((i+1) % round == 0) { // 배수면 
//						System.out.println("(" + (round+1) +"," + (i+1) + ")");
						door[i] =!(door[i]); // 열림 <-> 닫힘 현재값과 반대로 변경 
					}
				}
			}
			
			// 마지막 라운드 종료 후 열린 방의 개수 
			for(boolean b : door) {
				if(b == true) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
		
	}
}
