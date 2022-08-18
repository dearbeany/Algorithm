package boj.bronze;
import java.util.Scanner;

/*
 * N을 F로 나누어 떨어지게 해야할 때,
 * N의 맨 뒤 두 자리를 바꾼다. 단, 가능하면 작게 만든다.
 */
public class _1075_나누기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 428392
		int F = sc.nextInt(); // 17

		int tmp = (N / 100) * 100; // 입력받은 N의 맨 뒤 두자리를 00으로 만듦
		// 428300

		while (true) {
			if (tmp % F == 0) { // tmp가 F로 나눠 떨어지면
				// 428315 % 17 == 0

				int output = tmp % 100; // 맨 마지막 두 자리
				if (output >= 10) {
					System.out.println(output);
				} else { // 한자리면 앞애 0을 추가해서 출력
					System.out.println("0" + output);
				}
				break; // 찾으면 break 
			}
			tmp += 1; // tmp 1씩 증가시키면서 F에 나눠 떨어지는 tmp 를 찾음 
		}

	}

}
