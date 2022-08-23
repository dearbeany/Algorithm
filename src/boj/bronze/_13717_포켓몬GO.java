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

		String[] names = new String[N];

		for (int i = 0; i < N; i++) {
			names[i] = br.readLine(); // 포켓몬 이름

			st = new StringTokenizer(br.readLine());
			int needNum = Integer.parseInt(st.nextToken()); // 필요한 사탕 수
			int haveNum = Integer.parseInt(st.nextToken()); // 가진 사탕의 수

			int cnt = 0; // 진화시킬 수 있는 총 마리 수

			while (haveNum >= needNum) { // 가진 게 필요한 것 보다 많으면
				haveNum -= needNum;
				cnt++; // 진화한 포켓몬 한 마리 추가
				haveNum += 2; // 진화 후 2개의 사탕 보상
			}
			int idx = 0;
			if (cnt > max) {
				max = cnt;
			}
			// cnt가 가장큰 포켓몬을 찾아서 maxIdx에 넣어주기

			sum += cnt;
		}
		System.out.println(sum);
		System.out.println(names[i]);
	}
}
