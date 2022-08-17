package boj;
import java.util.Scanner;

public class _1297_TV크기_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int D = sc.nextInt(); // 대각선 길이
		int H = sc.nextInt(); // 높이 비율
		int W = sc.nextInt(); // 너비 비율

//		D^2 = (aH)^2 + (aW)^2
//			= a^2*H^2 + a^2*W^2
//			= a^2(H^2+W^2)
//		a^2 = D^2/(H^2+W^2)
		double a; // 비율에 곱할 배수

		a = Math.sqrt((Math.pow(D, 2) / (Math.pow(H, 2) + Math.pow(W, 2))));
		
		System.out.print((int)Math.floor(a*H) + " ");	// 높이
		System.out.print((int)Math.floor(a*W));	// 너비
		
		
	}
}