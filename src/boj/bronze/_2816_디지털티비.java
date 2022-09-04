package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2816_디지털티비 {

	static int N; // 채널의 개수
	static String[] channels; // 채널들을 담는 배열
	static int arrow; // 화살표 위치

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine()); // 채널의 개수

		channels = new String[N];

		for (int i = 0; i < N; i++) {
			channels[i] = br.readLine();
		}

		// 버튼1. 화살표 한 칸 아래로. 즉, i++
		// 버튼2. 화살표 한 칸 위로. 즉, i--
		// 버튼3. 현재 화살표가 가리키는 채널을 한 칸 아래로. 즉 swap(c[i], c[i+1])
		// 버튼4. 현재 화살표가 가리키는 채널을 한 칸 위로. 즉 swap(c[i], c[i-1])

		// (1) 처음 KBS1의 위치를 찾아서 화살표가 가리키게 한다
		// (2) KBS1이 맨 앞으로 올 때까지 swap
		// (3) 다음 KBS2 위치를 찾아 화살표값 갱신
		// (4) KBS2가 두 번째로 올 때까지 swap

		arrow = 0; // 처음엔 첫 번째값을 가리키고 있다. 인덱스와 동일

		// (1) 화살표가 KBS1을 가리키도록 한다
		for (int i = 0; i < N; i++) {
			if (channels[i].equals("KBS1")) {
				break;
			} else {
				arrow++;
				bw.append("1"); // 버튼1
			}
		}

		// (2) KBS1이 맨 앞 올 때까지 swap
		while (!channels[0].equals("KBS1")) {
			swap(arrow, arrow - 1);
			bw.append("4"); // 버튼4
		}

		// (3) 화살표가 KBS2를 가리키도록 한다
		for (int i = 0; i < N; i++) {
			if (channels[i].equals("KBS2")) {
				break;
			} else {
				arrow++;
				bw.append("1"); // 버튼1
			}
		}

		// (4) KBS2이 두번째 올 때까지 swap
		while (!channels[1].equals("KBS2")) {
			swap(arrow, arrow - 1);
			bw.append("4"); // 버튼4
		}

//		System.out.println(Arrays.toString(channels));
		bw.toString();
		bw.flush();
		bw.close();
	}

	private static void swap(int a, int b) {
		// 채널 a와 b의 위치를 바꾼다
		String tmp = channels[a];
		channels[a] = channels[b];
		channels[b] = tmp;
		// 화살표는 b를 가리키고 있다
		arrow = b;
	}

}
