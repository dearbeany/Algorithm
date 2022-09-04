package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _2621_카드게임 {
	static class Card implements Comparable<Card> {
		char color;
		int num;

		Card(char color, int num) {
			this.color = color;
			this.num = num;
		}

		@Override
		public int compareTo(Card o) {
			// TODO Auto-generated method stub
			return o.num - this.num; // 내림차순 정렬
		}

		@Override
		public String toString() {
			return "Card [color=" + color + ", num=" + num + "]";
		}

	}

	static List<Card> list = new ArrayList<>(); // 카드를 담는 리스트
	static int[] counts = new int[10]; // 인덱스 == 카드의 num. 같은 숫자의 개수를 담는 배열
	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		for (int i = 0; i < 5; i++) { // 카드는 총 5장 주어짐
			st = new StringTokenizer(br.readLine());
			char color = st.nextToken().charAt(0); // 카드 색상
			int num = Integer.parseInt(st.nextToken()); // 카드 점수

			counts[num]++;

			Card card = new Card(color, num);
			list.add(card);
		}
		Collections.sort(list); // 내림차순 정렬

		// 1. 색 모두 같음, 숫자 연속적 -> max숫자 + 900
		// 2. 숫자 4장 같음 -> 같은 점수 + 800
		// 3. 숫자 3장 같음, 숫자 2장 같음 -> 3장 숫자*10 + 2장 숫자 + 700
		// 4. 색 모두 같음 -> max숫자 + 600
		// 5. 숫자 연속적 -> max숫자 + 500
		// 6. 숫자 3장 같음 -> 같은 점수 + 400
		// 7. 숫자 2장 같음, 숫자 2장 같음 -> 같은 숫자 중 max * 10 + 남은 같은 숫자 + 300
		// 8. 숫자 2장 같음 -> 같은 숫자 + 200
		// 9. 모두 해당되지 X -> max숫자 + 100

		if (isSameColor()) {
			if (isContinuous()) {
				// (1)
				result = list.get(0).num + 900;
			} else {
				// (4)
				result = list.get(0).num + 600;
			}
		}

		if (isSameNumCount(4)) {
			// (2)
			result = list.get(2).num + 800; // 4장의 숫자가 같으므로 인덱스 처음과 마지막만 아니면 됨

		}
		if (isSameNumCount(3)) {
			int[] sameScore = new int[2];

			for (int i = 0; i < counts.length; i++) {
				if (counts[i] == 3) {
					sameScore[0] = i;
				}
				if (counts[i] == 2) {
					sameScore[1] = i;
				}
			}
			if (isSameNumCount(2)) {
				// (3) 숫자 3장 같음, 숫자 2장 같음 -> 3장 숫자*10 + 2장 숫자 + 700
				result = sameScore[0] * 10 + sameScore[1] + 700;
			} else {
				// (6) 숫자 3장 같음 -> 같은 숫자 + 400
				result = sameScore[0] + 400;

			}
		}
		if (isContinuous() && !isSameColor()) {
			// (5)
			result = list.get(0).num + 500;
		}

		if (isSameNumPerTwo()) {
			// (7) 숫자 2장 같음, 숫자 2장 같음 -> 같은 숫자 중 max * 10 + 남은 같은 숫자 + 300
			int[] sameScore = new int[2];
			int idx = 0;
			for (int i = 0; i < counts.length; i++) {
				if (counts[i] == 2) {
					sameScore[idx++] = i;
				}
			}
			Arrays.sort(sameScore);
			result = sameScore[1] * 10 + sameScore[0] + 300;
		}

		if (isSameNumCount(2) && !isSameNumCount(3) && !isSameNumPerTwo()) {
			// (8) 숫자 2장 같음 -> 같은 숫자 + 200
			for (int i = 0; i < counts.length; i++) {
				if (counts[i] == 2) {
					result = i;
					break;
				}
			}
			result += 200;
		}

		if (result == Integer.MIN_VALUE) {
			// (9)
			result = list.get(0).num + 100;
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();

	}

	// 5장의 카드가 색상이 모두 같은지
	private static boolean isSameColor() {
		for (int i = 0; i < list.size() - 1; i++) {
			int c1 = list.get(i).color - '0';
			int c2 = list.get(i + 1).color - '0';
			if (c1 != c2) { // 색상이 하나라도 다르면
				return false; // false 를 반환하면서 종료
			}
		}
		return true;
	}

	// 같은 숫자를 가진 카드가 num개수 만큼 있다
	private static boolean isSameNumCount(int num) {
		for (int n : counts) {
			if (n == num) {
				return true;
			}
		}
		return false;
	}

	// 같은 숫자를 가진 카드가 각각 2장씩 있다
	private static boolean isSameNumPerTwo() {
		int cnt = 0;

		for (int n : counts) {
			if (n == 2) {
				cnt++;
			}
		}
		// 둘 다 있어야
		return (cnt == 2) ? true : false;
	}

	// 5장의 카드의 숫자가 모두 연속적인지
	private static boolean isContinuous() {
		int cnt = 1;
		// counts의 배열을 돌면서 1을 발견했을 때 1이 연속적으로 5번 등장해야 한다
		for (int i = 0; i < counts.length - 1; i++) {
			if (counts[i] == 1 && counts[i + 1] == 1) {
				cnt++;
			}
		}
		if (cnt == 5) {
			return true;
		} else {
			return false;
		}
	}
}
