package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1244_스위치켜고끄기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int numOfSwitch = Integer.parseInt(br.readLine()); // 스위치개수
		int[] switches = new int[numOfSwitch];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numOfSwitch; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		int numOfStudents = Integer.parseInt(br.readLine()); // 학생수

		for (int t = 0; t < numOfStudents; t++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken()); // 성별
			int num = Integer.parseInt(st.nextToken()); // 받은 수

			switch (gender) {
			case 1: // 남학생
				for (int j = 0; j < numOfSwitch; j++) {
					if ((j + 1) % num == 0) { // 스위치번호가 num 배수면
						switches[j] = (switches[j] == 1) ? 0 : 1; // 스위치 상태변경
					}
				}
				break;

			// num-1+i < numOfSwitch
			// num-1-i >= 0
			case 2: // 여학생
				// 좌우가 대칭이면서 가장 많은 스위치 포함하는 구간 찾아서
				int idx = num - 1; // num번의 스위치는 배열에서 (num-1)번째 인덱스임
				for (int i = 1; (idx - i >= 0 && idx + i < numOfSwitch); i++) {
					if (switches[idx - i] != switches[idx + i]) { // 좌우 다르면
						break;
					} else { // 좌우 같으면
						switches[idx - i] = (switches[idx - i] == 1) ? 0 : 1; // 좌 스위치 상태변경
						switches[idx + i] = switches[idx - i]; // 좌 == 우 맞춰줌
					}
				}
				switches[idx] = (switches[idx] == 1) ? 0 : 1; // 가운데
				break;
			}

		}
		for (int i = 0; i < switches.length; i++) {
			System.out.print(switches[i] + " ");
			if ((i + 1) % 20 == 0) // 한줄에 20개씩 출력, 20번스위치(인덱스19)에서 개행해야
				System.out.println();
		}

	}

}
