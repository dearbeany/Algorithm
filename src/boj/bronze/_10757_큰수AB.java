package boj.bronze;

import java.math.BigInteger;
import java.util.Scanner;

public class _10757_큰수AB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger a = new BigInteger(sc.next());
		BigInteger b = new BigInteger(sc.next());

		BigInteger res = a.add(b);
		System.out.println(res);
	}

}
