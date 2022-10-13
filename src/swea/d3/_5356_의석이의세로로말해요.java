package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5356_의석이의세로로말해요 {
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			map = new char[5][15];

			for (int i = 0; i < 5; i++) {
				String str = br.readLine();
				for (int j = 0; j < 15; j++) {
					if (j >= str.length()) {
						map[i][j] = '*';
					} else {
						map[i][j] = str.charAt(j);
					}
				}
			}
//			print();

			System.out.print("#" + tc + " ");
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[j][i] == '*')
						continue;
					System.out.print(map[j][i]);
				}
			}
			System.out.println();
		}
	}

	public static void print() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
