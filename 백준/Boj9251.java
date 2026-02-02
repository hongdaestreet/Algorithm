// https://www.acmicpc.net/problem/9251
// 소요시간: 46M / GPT 도움
// 1. 누적되는 상황은 DP로 해결하려는 관점을 가져보자.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strX = br.readLine();
		String strY = br.readLine();
		char[] X = strX.toCharArray();
		char[] Y = strY.toCharArray();
		int xLen = X.length;
		int yLen = Y.length;
		int[][] dp = new int[xLen + 1][yLen + 1]; // i-1,j-1번째까지 누적되는 LCS길이

		for (int i = 1; i <= xLen; i++) {
			for (int j = 1; j <= yLen; j++) {
				if (X[i - 1] == Y[j - 1]) {  // X배열의 i-1번째와 Y배열의 j-1번째가 같으면
					dp[i][j] = dp[i - 1][j - 1] + 1;  // 누적된 곳에서 + 1
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
//				System.out.print(dp[i][j] + " ");
			}
//			System.out.println();
		}

		System.out.println(dp[xLen][yLen]);

	}

}
