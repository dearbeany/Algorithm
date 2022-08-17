package boj;
import java.util.Scanner;

public class _2577_숫자의개수_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int mul = a * b * c;

		String number = String.valueOf(mul); // int -> String 

		for (int i = 0; i < 10; i++) { // 0~9까지 숫자 카운트  
			int cnt = 0; // 각 수마다 몇 번 쓰였는지 

			for (int j = 0; j < number.length(); j++) { // 곱한 결과인 숫자의 길이만큼 루프 
				if ((number.charAt(j) - 48) == i) { // 각 자리의 숫자가 0~9와 같을 때마다 
					cnt++; // 카운트 
				}
			}
			System.out.println(cnt);
		}
	}

}
