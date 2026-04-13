// https://www.acmicpc.net/problem/18429
// 소요시간: 10M / 
// 1.  

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int cnt;
	static int[] kit;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		kit = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		
		cnt = 0;
		visited = new boolean[N];
		DFS(0,50);
		
		System.out.println(cnt);

	}
	
	static void DFS(int depth, int health) {
//		System.out.println("DFS: "+depth+","+health);
		if (depth == N) {
			cnt++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if ((health+kit[i]-K)<50 || visited[i])
				continue;
			visited[i] = true;
			DFS(depth+1,health+kit[i]-K);
			visited[i] = false;
		}
		
	}

}
