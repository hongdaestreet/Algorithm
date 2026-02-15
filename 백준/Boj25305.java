// https://www.acmicpc.net/problem/25305
// 소요시간: 11M / AI(조언)
// 1.int[]는 primitive라서 Comparator 사용불가 2.reverseOrder도 Comparator 차용하는거임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		Integer[] score = new Integer[N];
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st1.nextToken());
		}
		Arrays.sort(score, Comparator.reverseOrder());
		System.out.println(score[K-1]);
	}
}
