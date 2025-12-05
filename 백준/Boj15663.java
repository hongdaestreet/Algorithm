// https://www.acmicpc.net/problem/15663

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static StringBuilder sb;
	static int[] arr;
	static int size;
	static boolean[] visited;
	static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		arr = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st1.nextToken());
		}
		Arrays.sort(arr);

		visited = new boolean[N];
		selected = new int[M];

		dfs(0);
		System.out.println(sb);

	}

	static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		int last = -10001;
		for (int i = 0; i < N; i++) {
			// 이번 depth에서 이미 이 숫자로 한 번 DFS 들어가봤다면,
			// 같은 숫자를 또 선택해서 새로운 가지를 만들지 말자
			if (!visited[i] && (arr[i] != last)) {  // 같은 depth에서 같은 값쓰면 pass
				last = arr[i];
				selected[depth] = arr[i];
				visited[i] = true;
				dfs(depth + 1);
				visited[i] = false;
			}
		}

	}

}
