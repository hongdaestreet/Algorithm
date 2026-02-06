// https://www.acmicpc.net/problem/2206
// 소요시간: 150M / AI 보조 구현
// 1.BFS는 “큐 1개로 레벨 순서대로” 밀어야 최단거리 보장이 됨 
// 2.visited,map 3차원으로 둬야 함. (r, c, 벽을 이미 부쉈는가?)으로 가야 함.
// ** 난 visited,map 2차원으로 bfs를 병렬처리하여 최단거리도 보장못하고 벽 뚫는 경우도 보장못함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static final int[] dr = { 1, -1, 0, 0 };
	static final int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		int ans = BFS();

		System.out.println(ans);

	}

	static int BFS() {
		boolean[][][] visited = new boolean[N][M][2]; // 행,열,벽 부순 여부 체크
		int[][][] dist = new int[N][M][2]; // 3열은 벽 부순 여부를 나누어 최단거리 보장

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, 0 });
		visited[0][0][0] = true;
		dist[0][0][0] = 1;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0], c = cur[1], broke = cur[2];

			if (r == N - 1 && c == M - 1) { // 도착하면 바로 출력 (한 queue로 바로 진행하니까)
				return dist[r][c][broke];
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M) // 범위 초과하면 pass
					continue;

				if (map[nr][nc] == 0 && !visited[nr][nc][broke]) { // 그냥 갈 수 있는 경우
					visited[nr][nc][broke] = true;
					dist[nr][nc][broke] = dist[r][c][broke] + 1;
					q.offer(new int[] { nr, nc, broke });
				} else { // 막혀있는 경우
					if (broke == 0 && !visited[nr][nc][1]) { // 아직 벽 뚫지 않았다면
						visited[nr][nc][1] = true;
						dist[nr][nc][1] = dist[r][c][broke] + 1; // 다음으로 넘기면서 벽 차원으로 이동
						q.offer(new int[] { nr, nc, 1 }); // 상태값 변경 (다음 broke는 1)
					}
				}
			}
		}

		return -1;
	}

}
