package sw.d1;

import java.util.Scanner;

public class _2070_큰놈작은놈같은놈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <=T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.print("#" + tc);
			if(a > b) {
				System.out.println(" >");
			}
			else if(a == b) {
				System.out.println(" =");
			}
			else {
				System.out.println(" <");

			}
		}
	}

}
