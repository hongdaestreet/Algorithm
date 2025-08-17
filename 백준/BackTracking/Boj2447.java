// https://www.acmicpc.net/problem/2447
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		graph = new char[N][N];
		int time = 0;
		int K = N;
		while (K > 1) {
			K /= 3;
			time += 1;
		}
		for(int i=0;i<N;i++) {
			Arrays.fill(graph[i],' ');
		}
		graph[0][0] = '*';
		draw(0,0,N);
		
		StringBuilder sb = new StringBuilder();

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(graph[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void draw(int r,int c,int n) {
		if (n==1) {
			graph[r][c] = '*';
			return;
		}
		
		int m = n/3;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i == 1 && j == 1)
					continue;
				draw(r+i*m,c+j*m,m);
			}
		}
		
	}
}
