// https://www.acmicpc.net/problem/21736 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char[][] campus;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int r = -1;
		int c = -1;
		cnt = 0;

		campus = new char[N][M];
		for (int n = 0; n < N; n++) {
			char[] line = br.readLine().toCharArray();
			for (int i = 0; i < M; i++) {
				campus[n][i] = line[i];
				if (line[i] == 'I') {
					r = n;
					c = i;
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		campus[r][c]='X';

		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, -1, 0, 1 };

		while (!q.isEmpty()) {
			int[] rc = q.poll();
			r = rc[0];
			c = rc[1];
//			System.out.println("추가: "+r+" "+c);
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (check(nr, nc)) {
					q.offer(new int[] { nr, nc });
				}
			}

		}
		
		if (cnt == 0) {
			System.out.println("TT");
		} else {
			System.out.println(cnt);
		}

	}

	static boolean check(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M || campus[r][c] == 'X') {
//			if (!(r < 0 || r >= N || c < 0 || c >= M))
//			System.out.println("check탈락: "+r+" "+c+" "+ campus[r][c]);
			
			return false;
		}
		if (campus[r][c] == 'P')
			cnt++;
//		System.out.println("check통과: "+r+" "+c+" "+ campus[r][c]);
		campus[r][c]='X';
		return true;
	}

}
