package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 시험장 N개 각각 따른 응시자수 
 * 총감독관 B명 담당, 부감독관 C명 담당할 때
 * 모든 응시자 케어 위해 필요한 최소 감독관 수?
 *  
 */
public class _13458_시험감독 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine()); // 시험장 개수
		int[] arr = new int[n]; // 응시자 수

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken()); // 총감독 담당가능 응시인원
		int c = Integer.parseInt(st.nextToken()); // 부감독 담당가능 응시인원

		long cnt = 0; // 필요 감독관 최소 수

		cnt += n; // 총감독 맡을 수 있는 인원 더해주고

		for (int i = 0; i < n; i++) { // 부감독 인원 계산하자
			arr[i] -= b; // 만약 음수 되면... 부감독관 노필요

			if (arr[i] <= 0)
				continue; // 응시인원 양수일 때만 부감독 필요

			cnt += arr[i] / c;
			if (arr[i] % c != 0) { // 나머지 0 아니면 더 있는 거니까
				cnt++;
			}
//			while (arr[i] > 0) {
//				arr[i] -= c;
//				cnt++;
//			}
		}
		bw.write(cnt + " ");
		bw.flush();
		bw.close();
	}
}
