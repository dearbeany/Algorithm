package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11720_숫자의합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String str = br.readLine();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += str.charAt(i) - '0';
		}
		System.out.println(sum);
	}
}
