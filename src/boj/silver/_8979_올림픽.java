package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _8979_올림픽 {
	static class Country implements Comparable<Country> {
		int number; // 국가 번호
		int gold;
		int silver;
		int bronze;

		Country(int number, int gold, int silver, int bronze) {
			this.number = number;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		// A isHigherThan B
		// (this) isHigherThan (o)
		// A > B 이면 -1
		// A = B 이면 0
		// A < B 이면 1
		public int isHigherThan(Country o) {
			if (this.gold > o.gold) {
				return -1;
			} else if (this.gold < o.gold) {
				return 1;
			} else {
				if (this.silver > o.silver) {
					return -1;
				} else if (this.silver < o.silver) {
					return 1;
				} else {
					if (this.bronze > o.bronze) {
						return -1;
					} else if (this.bronze < o.bronze) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		}

		@Override
		public int compareTo(Country o) {
			if (this.gold > o.gold) {
				return -1;
			} else if (this.gold < o.gold) {
				return 1;
			} else {
				if (this.silver > o.silver) {
					return -1;
				} else if (this.silver < o.silver) {
					return 1;
				} else {
					if (this.bronze > o.bronze) {
						return -1;
					} else if (this.bronze < o.bronze) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		}

//		@Override
//		public String toString() {
//			return "Country [number=" + number + ", gold=" + gold + ", silver=" + silver + ", bronze=" + bronze + "]\n";
//		}

	}

	static List<Country> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 국가의 개수
		int K = Integer.parseInt(st.nextToken()); // 알고싶은 국가 번호

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken()); // 국가 넘버
			int gold = Integer.parseInt(st.nextToken()); // 금메달 개수
			int silver = Integer.parseInt(st.nextToken()); // 은메달 개수
			int bronze = Integer.parseInt(st.nextToken()); // 동메달 개수

			list.add(new Country(number, gold, silver, bronze));
		}

		Collections.sort(list); // 금-은-동 개수에 따라 정렬을 한다

		// 국가번호 K를 받았을 때 이 국가의 등수는
		// (나보다 잘한 국가의 개수 +1) 이다
		// 여기서, 나보다 잘한 국가만을 카운팅 해야하므로 만약 내가 동점인 다른 국가가 있을 때
		// 동점국가는 카운팅하면 안 된다!!

		// for문으로 리스트 돌면서 list.get(i).number 값이 K와 동일하고,
		// 이전원소가 더 메달수가 많다면 rank++
		int rank = 1;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).number == K) {
				break;
			} else if (list.get(i).number != K && (list.get(i).isHigherThan(getListByNumber(K)) == -1)) {
				rank++;
			}
		}
		bw.write(rank + "");
		bw.flush();
		bw.close();

	}

	// 국가 넘버를 받아서 국가 객체를 넘겨준다
	private static Country getListByNumber(int number) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).number == number) {
				return list.get(i);
			}
		}
		return null;
	}
}
