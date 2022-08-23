package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _9093_단어뒤집기_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			String[] wordList = br.readLine().split(" ");

			for (String s : wordList) {
				StringBuilder sb = new StringBuilder(s);
				bw.write(sb.reverse().append(' ').toString());
			}
			bw.newLine();
		}
		br.close();
		bw.flush();
		bw.close();

	}
}
