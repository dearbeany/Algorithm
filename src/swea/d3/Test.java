package swea.d3;

public class Test {
	public static void main(String[] args) {
		String s = "www.w3big.com";
//		char result = s.charAt(8);
//		System.out.println(result);
		for (int i = 0; i < s.length(); i++) {
			System.out.println(i + "번째: " + s.charAt(i));
		}
	}
}
