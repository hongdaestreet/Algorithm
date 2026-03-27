// https://www.acmicpc.net/problem/11052
// 소요시간: 35M / AI
// 1.dp보는 과점을 기르자. 최적->dp로 바라보는 연습

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] p = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			// i개 카드 : j개 카드팩 + 최적의 (i-j)개
			for (int j = 0; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i - j] + p[j]);
			}

		}

		System.out.println(dp[N]);

	}

}
