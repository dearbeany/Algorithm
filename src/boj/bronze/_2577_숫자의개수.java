package boj.bronze;
import java.util.Scanner;

public class _2577_숫자의개수 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int mul = a * b * c;

		String number = String.valueOf(mul);

		char[] digit = number.toCharArray();

		int zero = 0, one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0, ten = 0;

		for (int i = 0; i < digit.length; i++) {
			switch (digit[i] - 48) {
			case 0: zero++;
				break;
			case 1: one++;
				break;
			case 2: two++;
				break;
			case 3: three++;
				break;
			case 4: four++;
				break;
			case 5: five++;
				break;
			case 6: six++;
				break;
			case 7: seven++;
				break;
			case 8: eight++;
				break;
			case 9: nine++;
				break;
			}
		}
		System.out.println(zero);
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
		System.out.println(four);
		System.out.println(five);
		System.out.println(six);
		System.out.println(seven);
		System.out.println(eight);
		System.out.println(nine);
	}
}
