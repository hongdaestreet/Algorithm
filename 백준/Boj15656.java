// https://www.acmicpc.net/problem/15656
// 소요시간: 3M
// 1. 단순 반복에는 visited 안써도 된다.

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

		DFS(0, 0);

		System.out.println(sb);

	}

	static void DFS(int start, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(bt[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			bt[depth] = arr[i];
			DFS(start,depth+1);
		}

	}

}
