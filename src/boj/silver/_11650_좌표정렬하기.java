package boj.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 2차원 평면 위의 점 N개가 주어진다. 
 * 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬
 * 
 * 1. x 오름차순 정렬 후 y 오름차순 정렬하자 
 */
public class _11650_좌표정렬하기 {
	static class Pos implements Comparable<Pos> {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return x + " " + y;
		}

		@Override
		public int compareTo(Pos o) {
			if (this.x > o.x) {
				return 1;
			} else if (this.x < o.x) {
				return -1;
			} else {
				if (this.y >= o.y) {
					return 1;
				} else {
					return -1;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		List<Pos> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(new Pos(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(list); // 정렬
		for (Pos p : list) {
			System.out.println(p);
		}
	}

}
