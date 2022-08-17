package swea.d1;

import java.util.Scanner;

public class _2071_평균값구하기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 0; tc<T; tc++) {
			double sum = 0;
			for(int i = 0; i < 10; i++) {
				int n = sc.nextInt();
				sum += n;
			}
			double result = Math.round(sum/10);
			System.out.println("#" + (tc+1) +" " + (int)(result));
		}
		

	}

}
