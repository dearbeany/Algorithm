package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _15721_번데기 {

	static Queue<Integer> q = new LinkedList<>();
	static int A, T, sign;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		A = Integer.parseInt(br.readLine()); // 게임 참여인원수
		T = Integer.parseInt(br.readLine()); // 구하고자 하는 T번째
		sign = Integer.parseInt(br.readLine()); // 뻔이면 0 데기면 1

		int res = 0;

		// A명이 게임할 때 sign을 T번째에 외치는 사람이
		// 원탁에서 몇번째인지?

	}

	public static void addQueue() {
		// (n=1)0101 0011
		// (n=2) 0101 0011 0101 000111
		// (n=3)0101 0011 0101 000111 0101 00001111

	}
}
