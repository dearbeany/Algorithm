package boj.silver;

/*
 * (초기접근)
 * 1. int, long의 경우 자료형범위 초과 되므로 BigInteger 클래스를 이용한다.
 * 2. 구한 수를 문자열로 변환 후 반복문을 통해 0의 개수를 계산한다. 
 * 
 * 이 문제의 경우, 0 <= N <= 500
 * 1. 입력값이 최대 500으로, 즉 500!을 구해야 하므로 BigIntger 클래스 사용이 필수다. 
 * 2. 뒷자리가 0이 나오는 경우 => 소인수분해했을 때 2,5가 곱해진 경우다.
 * 3. 뒷자리가 0이 n개 있다 => 2,5가 n개씩 짝지어 존재한다. (2x5 = 10)
 * 4. 2는 5보다 작기에 팩토리얼과 같이 연속된 수 곱하게 되면, 모든 값들의 소인수분해는 2의 개수가 5의 개수 보다 많다.
 * 5. 즉, 5의 개수 따라 값이 변화한다. 5의 n승 따라 카운트 추가 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class _1676_팩토리얼0의개수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger N = new BigInteger(br.readLine());

		int cnt = 0; // 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수

		BigInteger num = fact(N); // N! 한 값

		// num을 뒤에서부터 탐색하며 0의 개수를 카운트 한다
		String snum = num.toString();

		for (int i = snum.length() - 1; i >= 0; i--) {
			if (snum.charAt(i) != '0') { // 0이 안 나오면 탈출
				break;
			}
			cnt++; // 0 나오면 카운트
		}
		System.out.println(cnt);
	}

	private static BigInteger fact(BigInteger n) {
		BigInteger one = new BigInteger("1");
		// 0! = 1
		// 1! = 1
		if (n.intValue() <= 1)
			return one;

		// fact(n) = n*fact(n-1)
		return fact(n.subtract(one)).multiply(n);
	}
}
