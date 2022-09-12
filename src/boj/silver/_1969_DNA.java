package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1969_DNA {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // DNA의 수
		int M = Integer.parseInt(st.nextToken()); // 문자열의 길이

		// 각 유전자를 카운트하는 배열
		// 입력받은 유전자 문자열의 문자가 몇 번 등장하는지?
		int[] A = new int[M + 1];
		int[] T = new int[M + 1];
		int[] G = new int[M + 1];
		int[] C = new int[M + 1];

		List<String> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			list.add(str);

			// 0번째는 무시한다
			for (int j = 0; j < M; j++) {
				switch (str.charAt(j)) {
				case 'A':
					A[j + 1]++;
					break;
				case 'T':
					T[j + 1]++;
					break;
				case 'G':
					G[j + 1]++;
					break;
				case 'C':
					C[j + 1]++;
					break;
				}
			}
		}
//		System.out.println(Arrays.toString(A));
//		System.out.println(Arrays.toString(T));
//		System.out.println(Arrays.toString(G));
//		System.out.println(Arrays.toString(C));

		// 각 배열 에서 가장 큰 카운트 값을 가진 문자로 유전자를 구성한다
		int[] tmp = new int[4]; // 각 ATGC 중 최대 카운트값을 가진 유전자를 알기 위한 배열
		char[] resDNA = new char[M + 1]; // H.D 가장 작은 DNA
		int max = 0;

//5 8
//TATGATAC
//TAAGCTAC
//AAAGATCC
//TGAGATAC
//TAAGATGT
//		
//5 8
//GATGATAC
//GAAGCTAC
//AAAGATCC
//CGAGATAC
//CAAGATGT

//5 8
//GCTGATAC
//GCAGCTAC
//ATAGATCC
//CGAGATAC
//CTAGATGT
//CCAGATAC

		// A C G T
		for (int i = 1; i < M + 1; i++) {
			// DNA 가 여러개 인 경우.. 사전 순으로 정렬해야 한다
			// 따라서 유전자 ACGT를 tmp에 사전 순으로 넣어준다
			tmp[0] = A[i];
			tmp[1] = C[i];
			tmp[2] = G[i];
			tmp[3] = T[i];
//			System.out.println(Arrays.toString(tmp));

			max = Math.max(tmp[0], Math.max(tmp[1], Math.max(tmp[2], tmp[3])));

			if (max == tmp[0]) {
				resDNA[i] = 'A';
			} else if (max == tmp[1]) {
				resDNA[i] = 'C';
			} else if (max == tmp[2]) {
				resDNA[i] = 'G';
			} else {
				resDNA[i] = 'T';
			}

		} // end of for

		String res = String.valueOf(resDNA);
		System.out.println(res);
		int minSum = 0; // H.D의 합

		for (int i = 0; i < N; i++) {
			// 입력받은 문자열이 담긴 리스트 전체를 탐색하면서
			// 하나라도 다르면 합+1
			for (int j = 0; j < M; j++) {
				// 입력받은 문자열의 DNA와 H.D 가장짧은 DNA의 문자가 다르다면
				if (list.get(i).charAt(j) != res.charAt(j + 1)) {
					minSum++;
				}
			}
		}
		System.out.println(minSum);
//		bw.write(res + "\n" + minSum);
//		bw.flush();
//		bw.close();

	}
}
