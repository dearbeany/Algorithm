package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1181_단어정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 단어의 개수

		// 길이가 짧은 것부터
		// 길이가 같으면 사전 순 정렬
		// 문자열 길이는 50이하

		List<String> list = new ArrayList<>();

		int maxLen = 0; // counts 배열 만들기 위해 문자열의 최대길이를 구함

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (!list.contains(str)) { // 리스트에 이미 존재하는 문자열이라면
				list.add(str); // 중복되는 원소는 저장하지 않음
			}
			if (maxLen < str.length()) { // 최대길이 구해오기
				maxLen = str.length();
			}
		}

		Collections.sort(list); // 사전 순 정렬을 위한 오름차순 정렬

		// 카운팅정렬의 아이디어를 가져와
		// 배열의 인덱스 = 문자열 길이, 값 = 단어의 개수
		int[] counts = new int[maxLen + 1];

		for (int i = 0; i < list.size(); i++) {
			counts[list.get(i).length()]++;
		}

		for (int i = 1; i < counts.length; i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i == list.get(j).length()) { // counts의 인덱스와 문자열의 길이 같으면
					bw.write(list.get(j) + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}

}
