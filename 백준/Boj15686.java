// https://www.acmicpc.net/problem/15686
// 소요시간: 87M / AI(Support)
// 1.백트래킹 boolean 조건 처리 주의

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int totalDistance;
	static int homeLength;
	static int chickenLength;
	static int[][] dist;
	static boolean[] visited;

	static List<int[]> home;
	static List<int[]> chicken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] city = new int[N][N];

		home = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 1) {
					home.add(new int[] {i,j});
				} else if (city[i][j] == 2) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		
		// 집마다의 치킨집 거리 계산. 집 X 치킨 집
		homeLength = home.size();
		chickenLength = chicken.size();
		dist = new int[homeLength][chickenLength];
		
		for(int i=0;i<homeLength;i++) {
			int[] currHome = home.get(i);
			for(int j=0;j<chickenLength;j++) {
				int[] currChicken = chicken.get(j);
				dist[i][j] = Math.abs(currHome[0]-currChicken[0])+Math.abs(currHome[1]-currChicken[1]);
			}
		}
		
		totalDistance = Integer.MAX_VALUE;
		visited = new boolean[chickenLength];  // 치킨집 방문 여부
		
		DFS(0,0,0);
		System.out.println(totalDistance);

	}
	
	static void DFS(int depth,int visitChicken,int distance) {  // visitChicken: 치킨집 방문수
		
		if (depth == homeLength && visitChicken <= M) {
//			System.out.println("\n ======도착======\n"+distance+"\n ======도착======\n");
			totalDistance = Math.min(totalDistance, distance);
			return;
		} else if (depth >= homeLength || visitChicken > M) {
			return;
		}
		
		for(int i=0;i<chickenLength;i++) {
//			int[] ch =home.get(depth);
//			int[] ck =chicken.get(i);
			
			if(!visited[i]) {
				visited[i] = true;
//				System.out.print("방문X- ");
//				System.out.println(depth+"집("+ch[0]+","+ch[1]+") "+i+"치킨집("+ck[0]+","+ck[1]+") 연결. 거리: "+dist[depth][i]+"  거리: "+(distance+dist[depth][i])+" 방문 치킨집 수: "+ (visitChicken+1));
				
				DFS(depth+1,visitChicken+1,distance+dist[depth][i]);
				visited[i] = false;
			} else {
//				System.out.print("방문O- ");
//				System.out.println(depth+"집("+ch[0]+","+ch[1]+") "+i+"치킨집("+ck[0]+","+ck[1]+") 연결. 거리: "+dist[depth][i]+"  거리: "+(distance+dist[depth][i])+" 방문 치킨집 수: "+ visitChicken);
				
				DFS(depth+1,visitChicken,distance+dist[depth][i]);
			}
			
		}
		
	}
	

}
