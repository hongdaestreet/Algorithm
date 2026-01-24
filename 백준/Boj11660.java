// https://www.acmicpc.net/problem/11660
// 소요시간: 40M / 2트 (GPT 힌트)
// 1. DP로 풀어야 함 2. 이중 for문은 N^2이므로 시간초과 고려해야 함
// 처음에 for문으로 돌렸다가 시간초과나서 혼남. 
// 개선한 풀이: 누적합 배열 [maxX][maxY]에서 옆에 값 돌려깎기

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
//		System.out.println(N+" "+M);
		
		// 표 형성
		graph = new int[N][N];  // 누적합 표
		for(int i=0;i<N;i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				graph[i][j] = Integer.parseInt(st1.nextToken());
				if (j != 0)
					graph[i][j] += graph[i][j-1];
//				System.out.print(graph[i][j]+" ");
			}
//			System.out.println();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if (i != 0)
					graph[i][j] += graph[i-1][j];
			}
		}
		
		sb = new StringBuilder();
		
		for(int m=0;m<M;m++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st2.nextToken());
//			System.out.print(x1+" ");
			int y1 = Integer.parseInt(st2.nextToken());
//			System.out.print(y1+" ");
			int x2 = Integer.parseInt(st2.nextToken());
//			System.out.print(x2+" ");
			int y2 = Integer.parseInt(st2.nextToken());
//			System.out.print(y2);
			sb.append(prefixSum(x1,y1,x2,y2)).append("\n");
//			System.out.println();
		}
		
		System.out.println(sb);

	}
	
	
	static int prefixSum(int x1, int y1, int x2, int y2) {
		x1--; y1--; x2--; y2--;
		int sum = 0;
		
		int minX = Math.min(x1,x2);
		int maxX = Math.max(x1,x2);
		
		int minY = Math.min(y1,y2);
		int maxY = Math.max(y1,y2);
		
		int exX = 0; // 제외하는 ㅣ
		int exY = 0; // 제외하는 ㅡ
		int isV = 0;
		
		if (minX>0)
			exX = graph[minX-1][maxY];
		if (minY>0)
			exY = graph[maxX][minY-1];
		
		if (minX>0 && minY>0)
			isV = graph[minX-1][minY-1];
		
//		for(int i=x1;i<=x2;i++) {
//			for(int j=y1;j<=y2;j++) {
//				sum += graph[i][j];
//			}
//		}
		
		sum = graph[maxX][maxY] - exX - exY + isV;
		
		return sum;
	}
	

}
