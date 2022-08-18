package boj.bronze;
import java.util.Scanner;

/*
 * 방의 개수 n 주어질 때, 몇 명의 학생들이 도주할 수 있는가? 
 */
public class _6359_만취한상범_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스의 개수

		int mul = 2;
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt(); // 방의 개수

			boolean[][] door = new boolean[n][n]; // 열면 true, 닫으면 0

			// 다 열린 상태(1)로 초기화
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					door[i][j] = true;
				}
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					while(mul * i < n) {
						
						if((mul * j) % i == 0) { // 배수면 
							door[i - 1][j - 1] = !(door[i - 2][j - 1]);
						}
						System.out.println("(" + i + "," + j + ")");
					}
				}
				mul++;
			}
//			for (int i = 2; i <= n; i++) {
//				for (int j = i; j <= n; j*=i) {
//					
//					if(j % i == 0) { // 배수면 
//						door[i - 1][j - 1] = !(door[i - 2][j - 1]);
//					}
//					System.out.println("(" + i + "," + j + ")");
//					
//					
//				}
//			}

			for (boolean[] arr : door) {
				for (boolean a : arr) {
					System.out.print(a + " ");
				}
				System.out.println();
			}
		}

	}

}
