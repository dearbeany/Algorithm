package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17478_재귀함수가뭔가요 {

	static int N; // 재귀횟수

	static String start = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
	static String question = "\"재귀함수가 뭔가요?\"";
	static String[] answer = { "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"" };
	static String result = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
	static String end = "라고 답변하였지.";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		System.out.println(start);
		func(0);
	}

	private static void func(int n) {
		isPrint(n);
		System.out.println(question); // 재귀함수가 뭔가요?

		if (n == N) {
			isPrint(n);
			System.out.println(result);

			// 라고 답변하였지
			for (int i = n; i >= 0; i--) {
				isPrint(i);
				System.out.println(end);
			}
			return;
		}

		// 잘 들어보게 ...
		for (int i = 0; i < answer.length; i++) {
			isPrint(n);
			System.out.print(answer[i]);
		}
		System.out.println();
		func(n + 1);
	}

	private static void isPrint(int n) {
		for (int i = 0; i < n * 4; i++) {
			System.out.print("_");
		}
	}
}
