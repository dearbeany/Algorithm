package boj.silver;

import java.util.Arrays;
import java.util.Scanner;

public class _7568_덩치 {
	static class Person {
		int w, h, r; // 몸무게, 키, 순위

		public Person(int w, int h, int r) {
			super();
			this.w = w;
			this.h = h;
			this.r = r;
		}

		@Override
		public String toString() {
			return "Person [w=" + w + ", h=" + h + ", r=" + r + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 전체 사람의 수

		Person[] plist = new Person[n];
		for (int i = 0; i < n; i++) {
			plist[i] = new Person(sc.nextInt(), sc.nextInt(), 0);
		}

		System.out.println(Arrays.toString(plist));

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				if (isBigger(plist[i], plist[j])) {
					plist[i].r++;
				}
			}
		}
		System.out.println(Arrays.toString(plist));
	}

	private static boolean isBigger(Person p1, Person p2) {
		if (p1.w > p2.w && p1.h > p2.h) {
			return true;
		} else {
			return false;
		}
	}
}
