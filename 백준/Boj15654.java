// https://www.acmicpc.net/problem/15654

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] selected;
	static int M;
	static int N;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		selected = new int[N];
		visited = new boolean[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		sb = new StringBuilder();
		Arrays.sort(arr);
		dfs(0);
		System.out.println(sb);
	}
	
	static void dfs(int depth) {
		if (depth == M) {
			for(int i=0;i<M;i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<N;i++) {
			if (!visited[i]) {
				selected[depth] = arr[i];
				visited[i] = true;
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}


}
