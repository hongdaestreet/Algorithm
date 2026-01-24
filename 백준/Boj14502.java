// https://www.acmicpc.net/problem/14502
// 소요시간: 48M / GPT 힌트받음 + 리팩토링
// 1. Queue나 배열 등은 변수 그대로 받아오면 참조라서 복사가 안된다. (Queue<int[]> q = virus; 안됨)
// + 따라서 배열 등은 하나하나 넣어줘야 함.
// 2. 최댓값 한계를 확인하고 시간초과 계산하기. 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int empty; // 0인 공간
	static Queue<int[]> virus; // 초기 바이러스

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] graph = new int[N][M];

		int ans = 0;

		List<int[]> list = new ArrayList<>(); // 빈 공간 넣기
		empty = -3; // 어차피 벽으로 3개 막을거임

		virus = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st1.nextToken());
				if (graph[i][j] == 0) {
					list.add(new int[] { i, j });
				} else if (graph[i][j] == 2) {
					virus.offer(new int[] { i, j });
				}
			}
		}
		int length = list.size();
		empty += length; // 빈공간 (나중에 벽 3개 뚫을거야)

		for (int i = 0; i < length; i++) {
			int[] f = list.get(i);
			graph[f[0]][f[1]] = 1;
			for (int j = i + 1; j < length; j++) {
				int[] s = list.get(j);
				graph[s[0]][s[1]] = 1;
				for (int k = j + 1; k < length; k++) {
					int[] t = list.get(k);
					graph[t[0]][t[1]] = 1;
					ans = Math.max(ans, area(graph));
					graph[t[0]][t[1]] = 0;
				}
				graph[s[0]][s[1]] = 0;
			}
			graph[f[0]][f[1]] = 0;
		}

		System.out.println(ans);
	}

	static int area(int[][] graph) {

//		int[][] map = graph;  // 이따구로 하면 안됨
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			map[i] = graph[i].clone();  // 1차원 배열 clone은 깊은 복사
		}
		
		int cnt = empty;
		// Queue<int[]> q = virus;  // 이따구로 하면 안됨
		Queue<int[]> q = new LinkedList<>();
		for(int[] v:virus) {
			q.offer(v);
		}
		// Queue<int[]> q = new LinkedList<>(virus);  // 이것도 가능

		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };

		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int curR = arr[0];
			int curC = arr[1];

			for (int n = 0; n < 4; n++) {
				int nR = curR + dr[n];
				int nC = curC + dc[n];
				if (check(nR, nC, map)) {
					q.offer(new int[] { nR, nC });
					map[nR][nC] = 2;
					cnt--;
				}
			}

		}

		return cnt;
	}

	static boolean check(int r, int c, int[][] map) {
		if (r < 0 || r >= N || c < 0 || c >= M || map[r][c] != 0) {
			return false;
		}
		return true;
	}

}
