// https://www.acmicpc.net/problem/1966
// 소요시간: 30M
// 1. 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] storage = new int[10]; // 중요도 개수
			Queue<int[]> q = new LinkedList<>();

			int max = -1;
			int cnt = 1;

			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				int num = Integer.parseInt(st1.nextToken());
				q.offer(new int[] { n, num });
				storage[num]++;
				max = Math.max(max, num);
			}
			while (true) {
				int[] cur = q.poll();
//				System.out.println(cur[0]+" "+cur[1]);
				if (cur[1] == max) { // 뺄 수 있는 상황
					storage[cur[1]]--; // 중요도 하나 빠짐
//					System.out.println(cur[0]+"번째 나감");
					if (cur[0] == M) { // 정답에서 멈춤
						break;
					}
					for (int i = cur[1]; i >= 0; i--) { // 중요도 최댓값 초기화
						if (storage[i] > 0) {
							max = i;
							break;
						}
					}
					cnt++;
				} else { // 못 빼면 다시 넣어
					q.offer(cur);
				}


			}

			System.out.println(cnt);
		}

	}

}
