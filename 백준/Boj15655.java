// https://www.acmicpc.net/problem/15655
// 소요시간: 24M
// 1.백트래킹 조건

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] arr;
	static int[] bt;
	static StringBuilder sb;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		bt = new int[M];
		sb = new StringBuilder();
		visited = new boolean[N];

		DFS(0, 0, 0);

		System.out.println(sb);

	}

	static void DFS(int idx, int depth, int pre) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(bt[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i] && i >= pre) {
				visited[i] = true;
				bt[idx] = arr[i];
				DFS(idx + 1, depth + 1, i);
				visited[i] = false;
			}
		}

	}

}
