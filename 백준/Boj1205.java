// https://www.acmicpc.net/problem/1205
// 소요시간: 49M / GPT
// 1. 정렬 개념 다시 상기하자 2. 분기 처리 똑바로 하자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int[] arr = new int[P];
		int min = 2_000_000_000 + 1;
		if (N > 0) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st1.nextToken());
				int idx = i; // 내림차순 확실하게
				min = Math.min(min, arr[i]);
				while (idx > 0 && arr[idx] > arr[idx - 1]) {
					int temp = arr[idx];
					arr[idx] = arr[idx - 1];
					arr[idx - 1] = temp;
					idx--;
				}
			}
		} else {
			min = 0;
		}

		int ans = 0;
		if (score < min) { // 최솟값일때
			if (N < P) {
				ans = N + 1;
			} else {
				ans = -1;
			}
		} else {
			for (int i = 0; i < N; i++) {
				if (score < arr[i])
					continue;
				if (score == min && N==P) {
					ans= -1;
				}else {
					ans = i + 1; // 순위는 +1;
				}
				break;
			}
		}
		if (N == 0) {
			ans = 1;
		}

		System.out.println(ans);

	}

}
