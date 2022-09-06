package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

interface deque {
	/*
	 * 정수를 덱의 앞에 넣는다
	 */
	boolean push_front(int num);

	/*
	 * 정수를 덱의 뒤에 넣는다
	 */

	boolean push_back();

	/*
	 * 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 덱에 들어있는 정수가 없는 경우 -1을 출력한다.
	 */
	int pop_front();

	/*
	 * 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 덱에 들어있는 정수가 없는 경우 -1을 출력한다.
	 */
	int pop_back();

	/*
	 * 덱에 들어있는 정수의 개수를 출력한다.
	 */
	int size();

	/*
	 * 덱이 비어있으면 1, 아니면 0을 출력한다.
	 */
	int empty();

	/*
	 * 덱의 가장 앞에 있는 정수를 출력한다. 덱에 들어있는 정수가 없는 경우 -1을 출력한다.
	 */
	int front();

	/*
	 * 덱의 가장 뒤에 있는 정수를 출력한다. 덱에 들어있는 정수가 없는 경우 -1을 출력한다.
	 */
	int back();
}

public class _10888_덱2 {
	static class Deque implements deque {

		@Override
		public boolean push_front(int num) {
			return false;
		}

		@Override
		public boolean push_back() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int pop_front() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int pop_back() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int empty() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int front() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int back() {
			// TODO Auto-generated method stub
			return 0;
		}

	}

//	public static Deque deque = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 명령의 수

	}
}
