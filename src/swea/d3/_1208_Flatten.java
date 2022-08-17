package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 평탄화 작업을 위해 
 * 덤프(높-> 낮 옮기는 작업)의 횟수와상자의 높이들이 주어질 때
 * 최고점과 최저점의 차이?
 * 
 */
public class _1208_Flatten {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;

		int[] box = new int[100];

		for (int tc = 1; tc <= T; tc++) {
			int res = 0;
			int dumpNum = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}

			int maxVal = 0, minVal = 101; // 상자 높이 1~100
			int maxIdx = 0, minIdx = 0;

			for (int i = 0; i < dumpNum; i++) {

				for (int j = 0; j < 100; j++) {
					if (maxVal <= box[j]) {
						maxVal = box[j];
						maxIdx = j;
					}

				}
				for (int k = 0; k < 100; k++) {
					if (minVal >= box[k]) {
						minVal = box[k];
						minIdx = k;
					}
				}
				box[maxIdx]--;
				box[minIdx]++;

				maxVal = 0;
				minVal = 101;

			}

			for (int j = 0; j < 100; j++) {
				if (maxVal <= box[j]) {
					maxVal = box[j];
					maxIdx = j;
				}

			}
			for (int k = 0; k < 100; k++) {
				if (minVal >= box[k]) {
					minVal = box[k];
					minIdx = k;
				}
			}
			res = maxVal - minVal;
			System.out.printf("#%d %d\n", tc, res);
			res = 0;
		}
	}
}
