// https://www.acmicpc.net/problem/26091
// 소요시간: 24M / AI(support)
// 1.2개합은 투 포인터 고민?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] power = new int[N];
		boolean[] visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			power[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(power);
		
		int cnt = 0;
		
		int left = 0;
		int right = N-1;
		
		while(left<right) {
			if (power[left]+power[right] < M) {
				left++;
			} else {
				left++;
				right--;
				cnt++;
			}
		}
		
		/*
		 * 완탐하면 시간 초과 걸림
		 * for(int i=0;i<N;i++) { if (visited[i]) continue;
		 * 
		 * for(int j=i+1;j<N;j++) { if (visited[j]) continue; if (power[i]+power[j] >=
		 * M) { visited[i] = true; visited[j] = true; cnt++; break; } } }
		 */
		
		
		
		System.out.println(cnt);
	}

}
