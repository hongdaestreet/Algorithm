// https://www.acmicpc.net/problem/17626
// AI
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		for(int i=1;i<N+1;i++) {
			dp[i] = 4;
			
			for(int j=1;j*j<=i;j++) {
				int sq = j*j;
				dp[i] = Math.min(dp[i],dp[i-sq]+1); // 자신-제곱수 뺀 값 dp로 이용 (횟수+1)
			}
		}
		System.out.println(dp[N]);
	}
}
