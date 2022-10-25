package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _1946_신입사원 {
	static class Rank implements Comparable<Rank> {
		int paper, interview; // 서류심사, 면접 성적

		Rank(int p, int i) {
			this.paper = p;
			this.interview = i;
		}

		@Override
		public int compareTo(Rank o) {
			return this.paper - o.paper;
		}

		@Override
		public String toString() {
			return "Score [paper=" + paper + ", interview=" + interview + "]";
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine()); // 면접자 수

			List<Rank> people = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				people.add(new Rank(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))); // 순위를 입력받자
			}

			Collections.sort(people); // 서류 기준으로 정렬하자

			// 1차 2차 둘 다 낮으면 떨어져....
			// 최대인원이 뽑혀야 하니깐 세볼까

			// (1위, 4위) 뽑히면 얘가 1등 -> 합격컷 4위: 그럼 다른 사람은 면접 4위보다 순위가 높아야(1,2,3) 뽑힘
			// (2위, 3위) 뽑히면 얘가 2등 -> 합격컷 3위: 다른 사람은 면접 1,2위여야 뽑힘
			// (3위, 2위) 뽑히면 얘가 3등 -> 합격컷 2위: 다른 사람은 1위여야
			// (4위, 1위) 뽑히면 얘가 4등 -> 합격컷 1위: 다른 사람은 X
			// (5위, 5위) 뽑히면 얘가 5등 -> 다른 사람은 1,2,3,4위여야하는데.. 1위보다 높은 등수 없어! 끝!

			Rank numberOne = people.get(0); // 서류 1등은 무조건 뽑히니까
			int pick = 1;
			int min = numberOne.interview; // 면접점수 합격컷

			for (int i = 1; i < n; i++) {
				Rank hubo = people.get(i);
				if (min > hubo.interview) { // 후보의 순위가 더 높으면(2등보다 1등이 높으면)
					pick++; // 그럼 뽑자
					min = hubo.interview; // 뽑았으니까 합격컷 더 올라갔음..
				}
			}
			System.out.println(pick);
		}
	}
}
