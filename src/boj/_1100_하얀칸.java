package boj;
import java.util.Scanner;

public class _1100_하얀칸 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = 0; // 흰 칸 위 말의 개수 
		
		for(int i = 0; i < 8; i++) {
			String str = sc.next();
			for(int j = 0; j < 8; j++) {
				// (i, j) i+j 값이 짝수일 때 흰 칸 
				// 말이 놓여져 있을 때 F 
				if((i+j) % 2 == 0 && str.charAt(j) == 'F') {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
		
/*
		char[][] chess = new char[8][8]; // 흰, 검 체스판 
	
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				// (i, j)가 둘 다 짝수 거나, 둘 다 홀수면 흰 white
				if(i % 2 == 0) { 
					if(j % 2 == 0) {
						chess[i][j] = 'W';
					}
					else {
						chess[i][j] = 'B';
					}
				} else {
					if(j % 2 == 0) {
						chess[i][j] = 'B';
					}
					else {
						chess[i][j] = 'W';
					}
				}
			}
		}
*/

		

	}

}
