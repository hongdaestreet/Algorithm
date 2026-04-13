// https://www.acmicpc.net/problem/10971
// 소요시간: 26M / 
// 1.백트래킹은 저장해야 할 값이 있으면 argument로 넘겨라 2.테스트케이스 다 맞다고 정답이 아니다. 문제 똑바로 읽어라.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] city;
	static boolean[] visited;
	static int totalCost;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		city = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		totalCost = Integer.MAX_VALUE;
		visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
//			System.out.println("\n\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n "+i+"부터 시작!!!!!!!!!");
			visited[i] = true;
			DFS(1,i,0,i);
			visited[i] = false;
		}
		System.out.println(totalCost);

	}
	
	// 이전점을 기록해야 함 -> pre로 기록, 자기 자신은 방문하지 않음 -> visited 배열, 마지막에 자기 위치로 복귀 -> start
	static void DFS(int depth,int pre,int cost,int start) {  // 방문 횟수, 시작점, 비용
//		System.out.println(depth+" "+pre+" "+cost);
		if (depth == N && city[pre][start] > 0) {
			cost += city[pre][start];
//			System.out.println("\n=========\n최종 도달!!! 시작점:"+start+" 이전점:"+pre+" "+cost+"\n=========\n");
			totalCost = Math.min(cost,totalCost);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visited[i] || city[pre][i] == 0) // 시작점->종점이 0이면 못 가는곳임
				continue;
			visited[i] = true;
//			System.out.println("이동 "+depth+" 시작"+pre+"->"+i+" 비용: "+cost+"+"+city[pre][i]);
			DFS(depth+1,i,cost+city[pre][i],start);
			visited[i] = false;
		}
		
	}

}
