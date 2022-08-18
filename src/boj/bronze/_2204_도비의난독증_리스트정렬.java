package boj.bronze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _2204_도비의난독증_리스트정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n;

		do {
			n = sc.nextInt();
			sc.nextLine();

			String[] str = new String[n];

			for (int i = 0; i < n; i++) {
				str[i] = sc.nextLine();
			}

			List<String> list1 = new ArrayList<String>(); // 원본 리스트
			List<String> list2 = new ArrayList<String>(); // 소문자 리스트

			for (String s : str) {
				list1.add(s);
				list2.add(s.toLowerCase()); // 사전 순 정렬을 위해 모두 소문자로 만들어줌
			}

			Collections.sort(list2);

			for (int i = 0; i < n; i++) {
				if (list1.get(i).toLowerCase().equals(list2.get(0))) {
					System.out.println(list1.get(i));
				}
			}

		} while (n != 0); // 0을 입력하면 종료
	}
}
