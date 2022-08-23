package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13717_포켓몬GO {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 포켓몬 종류 수
		int max = 0, sum = 0;
		String name = null; // 최종 포켓몬 이름

		for (int i = 0; i < N; i++) {
			String pname = br.readLine(); // 포켓몬 이름

			st = new StringTokenizer(br.readLine());
			int needNum = Integer.parseInt(st.nextToken()); // 필요한 사탕 수
			int haveNum = Integer.parseInt(st.nextToken()); // 가진 사탕의 수

			int cnt = 0; // 각 포켓몬이 진화한 마리 수

			while (haveNum >= needNum) { // 가진 게 필요한 것 보다 많아야 루프
				haveNum -= needNum; // 진화를 위해 필요한 캔디 수만큼 활용
				cnt++; // 진화한 포켓몬 한 마리 추가
				haveNum += 2; // 진화 후 2개의 사탕 보상
			}

			// cnt가 가장 큰 포켓몬을 찾기
			if (cnt > max) {
				max = cnt;
				name = pname;
			}

			sum += cnt; // 모든 포켓몬들이 진화한 총 마리 수
		}
		System.out.println(sum);
		System.out.println(name);
	}
}
