package boj.bronze;

/*
 * 핵심 아이디어
 * 
 * 1. 홀더의 수가 아닌, 홀더에 놓을 수 있는 '최대 사람의 수' 를 구해야 한다. 
 * 2. 홀더를 놓을 수 있는 자리의 개수는 모든 좌석이 일반석 S일 때, 좌석+1의 개수다.  
 * 3. 커플석을 일반석으로 바꾼 후, 만일 홀더의 수가 사람의 수를 초과한다면 
 * 4. 최대 사람 수를 출력한다. 
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2810_컵홀더 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfPeople = Integer.parseInt(br.readLine()); // 좌석의 수 == 사람의 수

		String str = br.readLine();

		str = str.replace("LL", "S"); // 커플석 사이엔 홀더X, 모두 일반석으로 변경
		int numOfHolder = str.length() + 1; // 홀더의 수

		if (numOfPeople < numOfHolder) { // 홀더의 수가 더 많으면
			// 즉, 홀더 놓을 수 있는 자리 4개인데 사람은 3명인 경우?
			System.out.println(numOfPeople); // 최대 사람의 수를 출력
		} else {
			// 즉, 홀더 놓을 수 있는 자리 3개뿐인데 사람은 4명인 경우?
			System.out.println(numOfHolder); // 홀더 수를 출력
		}

	}
}
