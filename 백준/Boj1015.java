// https://www.acmicpc.net/problem/1015
// 소요시간: 44M /
// 1.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];

		int[] arr = new int[1001];
		
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
			arr[A[i]]++;
		}
		
		
		int idx = 0;  // P의 인덱스
		int score = 0;  // 적용할 score
		int[] P = new int[N];
		boolean[] visited = new boolean[N];
		while(idx<N) {
			while (arr[score]==0 && score<=1000) {
				score++;
			}
			for(int i=0;i<N;i++) {
				if (A[i] == score && !visited[i]) {
					P[i] = idx++;
					visited[i] = true;
					arr[score]--;
				}
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(P[i]).append(" ");
		}
		
		System.out.println(sb);
		
		
		
	}
}
