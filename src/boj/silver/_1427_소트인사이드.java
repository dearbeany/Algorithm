package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 1. 자릿수를 따로 저장한 후 list에 저장
 * 2. 오름차순 정렬 후 뒤에서부터 출력 (내림차순 결과가 출력됨) 
 */
public class _1427_소트인사이드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 정렬하려고 하는 수

		List<Integer> list = new ArrayList<>(); // 자릿수를 저장하는 리스트

		while (N != 0) {
			list.add(N % 10); // 나머지 즉, 맨 끝 자릿수가 리스트에 하나씩 추가됨
			N /= 10; // 몫
		}
		Collections.sort(list); // 오름차순 정렬

		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i));
		}
	}
}
