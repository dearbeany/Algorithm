package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _6900_주혁이의복권당첨 {
	static class Winning {
		String number;
		int amount;

		Winning(String n, int a) {
			this.number = n;
			this.amount = a;
		}
	}

	static List<Winning> winList;
	static List<String> lottoList;
	static int n, m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 당첨번호 개수
			m = Integer.parseInt(st.nextToken()); // 주혁이가 산 복권번호 개수

			winList = new ArrayList<>(); // 당첨
			lottoList = new ArrayList<>(); // 복권

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				winList.add(new Winning(st.nextToken(), Integer.parseInt(st.nextToken())));
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				lottoList.add(st.nextToken());
			}

			int sum = 0; // 당첨금액 총합
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					// 복권번호가 당첨번호들을 다 돌면서
					boolean flag = isMatched(lottoList.get(i), winList.get(j).number);
					// 일치한다면 당첨번호 리스트에서 해당 당첨번호 삭제하고
					// 당첨금액 합하기
					if (flag) {
						sum += winList.get(j).amount;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}

	// 복권번호랑 당첨번호 일치하는지?
	// * 나오면 넘겨
	private static boolean isMatched(String lnum, String wnum) {
		for (int i = 0; i < 8; i++) {
			char c1 = lnum.charAt(i);
			char c2 = wnum.charAt(i);
			if (c2 != '*' && c1 != c2) {
				return false;
			}
		}
		return true;
	}

}
