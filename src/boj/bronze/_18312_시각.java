package boj.bronze;

/*
 * String.format("%02d", 8 ) // 08
 * 0 : 채워질 문자 
 * 2 : 총 자릿수 
 * d : 십진수로 된 정수 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18312_시각 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 시각
		int K = Integer.parseInt(st.nextToken()); // 포함할 숫자

		// 00시 00분 00초 ~ N시 59분 59초 까지
		// K를 포함하는 시각의 개수 cnt
		int cnt = 0;

		int[] arr = new int[3]; // 시각을 담는 배열
		// h시 m분 s초
		// arr [0] = h
		// arr [1] = m
		// arr [2] = s
		String k = Integer.toString(K);

		for (int h = 0; h <= N; h++) {
			for (int m = 0; m < 60; m++) {
				for (int s = 0; s < 60; s++) {
					arr[0] = h;
					arr[1] = m;
					arr[2] = s;
					// 왜 이건 틀릴까 ??...
//					String tmp = Arrays.toString(arr);
					String tmp = String.format("%02d", arr[0]) + String.format("%02d", arr[1])
							+ String.format("%02d", arr[2]);
//					System.out.println(tmp);
					if (tmp.contains(k)) {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
