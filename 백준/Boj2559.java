// https://www.acmicpc.net/problem/2559

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] day = new int[N];

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int ans = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st1.nextToken());
			day[i] = num;
			sum += day[i];
			if (i >= K) {
				sum -= day[i - K];
			}
			if (i >= K-1) {
				ans = Math.max(ans, sum);
			}
		}
		ans = Math.max(ans, sum);
		System.out.println(ans);
	}
}
