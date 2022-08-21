package boj.bronze;

/*
 * 핵심 아이디어
 * 1. 9명의 키 중 7명 키의 합이 100이 될 때까지 7개의 원소를 골라주어야 한다.
 * 2. 이중 for문을 사용하여 제외할 2명의 키를 sum에서 빼주면서 100이면 break
 * 3. 제외할 원소 i,j번째 원소를 0으로 만든 후 오름차순 정렬하여 출력 순서를 지정해준다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2309_일곱난쟁이 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[9];
		int sum = 0;

		// 아홉 난쟁이 키를 받음
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}

		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - arr[i] - arr[j] == 100) { // i, j번째 원소를 제외했더니 100이 됐다
					arr[i] = 0; // i번째 원소 0으로 만듦
					arr[j] = 0; // j번째 원소 0으로 만듦

					Arrays.sort(arr); // 오름차순 정렬 시키면 i, j번째값은 0이기에 맨 앞, 그 다음에 위치함
					for (int k = 2; k < 9; k++) { // 따라서 2번째부터 마지막원소까지 출력한다
						System.out.println(arr[k]);
					}
					return; // break쓰면 오류!!
				}
			}
		}

	}
}
