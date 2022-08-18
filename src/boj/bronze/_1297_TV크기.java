package boj.bronze;
import java.util.Scanner;

/*
 * 대각선 길이, 높이 너비 비율 주어질 때실제 높이와 너비의 길이?
 * 
 */
public class _1297_TV크기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int D = sc.nextInt(); // 대각선 길이
		int H = sc.nextInt(); // 높이 비율
		int W = sc.nextInt(); // 너비 비율 
		
		double out = Math.sqrt( Math.pow(D,2) / (Math.pow(H, 2) + Math.pow(W, 2) ));
		System.out.print((int)Math.floor(out*H) + " ");
		System.out.println((int)Math.floor(out*W));

	}

}
