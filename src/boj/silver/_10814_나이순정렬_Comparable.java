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

/*
 * 1. 나이 순 정렬은 
 * - (1) Comparable를 implements, age를 기준으로 compareTo()를 오버라이드
 * - (2) Collections.sort()의 두번째 인자인 Comparator의 compare()를 오버라이드
 * 2. 입력 순 = 가입 순이기에, 입력한 순서대로 리스트에 추가한다. 
 */

public class _10814_나이순정렬_Comparable {
	static class Member implements Comparable<Member> {
		int age;
		String name;

		Member(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Member o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}

		@Override
		public String toString() {
			return age + " " + name + "\n";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 나이는 오름차순
		// 나이 같으면 먼저 가입(= 입력)한 순
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 회원 수

		List<Member> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			Member member = new Member(age, name);
			list.add(member);
		}
		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
//			bw.write(list.get(i).age + " " + list.get(i).name + "\n");
			System.out.print(list.get(i).toString());
		}
		bw.flush();
		bw.close();
	}
}
