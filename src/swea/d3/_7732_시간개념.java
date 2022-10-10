package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7732_시간개념 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1, st2;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st1 = new StringTokenizer(br.readLine(), ":");
			st2 = new StringTokenizer(br.readLine(), ":");

			String[] currTime = new String[3]; // 현재 시간
			String[] promTime = new String[3]; // 약속 시간

			for (int i = 0; i < 3; i++) {
				currTime[i] = st1.nextToken();
				promTime[i] = st2.nextToken();
			}
			int remainTime = 0; // 약속까지 남은 시간
			// 약속시간이 다음날인 경우
			// 현재시간 h 더 큼 || h같고 m 더큼 || h,m 같은데 s 더 큼

		}
	}

}
