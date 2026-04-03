// https://www.acmicpc.net/problem/3699
// 소요시간: 44M

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] building = new int[H][L];
			int[][] order = new int[H*L+1][2];  // 순서
			int[] ev = new int[H];  // 각 층  엘리베이터 idx
			for(int h=0;h<H;h++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for (int l=0;l<L;l++) {
					int curr = Integer.parseInt(st1.nextToken());
					building[h][l] = curr;
					if (curr>0) {
						order[curr][0] = h;
						order[curr][1] = l;
					}
				}
			}
			int time = 0;
			for (int i=1;i<H*L+1;i++) {
				int currH = order[i][0];
				int currL = order[i][1];
				if (currH == 0 && currL == 0)  // 손님 끝
					break;
//				System.out.println(currH+" "+currL);
				int currTime = 0;
				currTime += currH*2*10;  // 층 왔다갔다
				int big = Math.max(currL,ev[currH]);
				int small = Math.min(currL,ev[currH]);
				currTime += Math.min(big-small,(small+L-big))*5;
				
				ev[currH] = currL;
				time += currTime;
			}
			
			sb.append(time).append("\n");
		}
		System.out.println(sb);

	}

}
