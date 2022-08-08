package sw;

import java.util.Scanner;

public class _1206_View {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc<=10; tc++) {
			int N = sc.nextInt(); // 빌딩의 개수 
			int[] buildings = new int[N];
			
			// 빌딩 입력 받기 
			for(int i = 0; i<N; i++) {
				buildings[i] = sc.nextInt();
			}
			
			int cnt = 0; // 총 조망권 세대의 수 
			
			for(int i = 2; i < buildings.length-2; i++) {
				int max = Math.max(buildings[i-2], Math.max(buildings[i-1], Math.max(buildings[i+1], buildings[i+2])));
				
					if(buildings[i] - max > 0) {
						cnt += buildings[i] - max;
					}
					

			} // end of for building 
		System.out.println("#" + tc + " " + cnt);
		} // end of for testcase
	}
}
