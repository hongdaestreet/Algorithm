// https://www.acmicpc.net/problem/9465
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9465 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][N];
			
			for(int i=0;i<2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 백트래킹 -> DP로 해야함(GPT)
			// N=100000까지 이므로 2^N하면 양이 ㅈㄴ많음
			// 열단위로 선택 여부만 확인하면 되는 DP가 맞음ㅇㅇ
			int upX = 0;
			int up0 = sticker[0][0];
			int up1 = sticker[1][0];
			
			int[] dpX = new int[N];  // 아무것도 선택X
			int[] dp0 = new int[N];  // 0행 선택
			int[] dp1 = new int[N];  // 1행 선택
			dp0[0] = up0;
			dp1[0] = up1;
			
			for(int i=1;i<N;i++) {
				dpX[i] = Math.max(dpX[i-1], Math.max(dp0[i-1],dp1[i-1]));
				dp0[i] = Math.max(dpX[i-1],dp1[i-1]) + sticker[0][i];
				dp1[i] = Math.max(dpX[i-1],dp0[i-1]) + sticker[1][i];
			}
			int ans = Math.max(dpX[N-1], Math.max(dp0[N-1],dp1[N-1]));
			System.out.println(ans);
		}
		

	}

}
