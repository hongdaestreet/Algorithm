// https://www.acmicpc.net/problem/24060
// 소요시간: 25M
// 1. 반복할 때마다 array를 만들면 시간 낭비가 심하다. 2. list.add는 무겁다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long cnt = 0;
	static int K;
	static int[] temp;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] A = new int[N];

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st1.nextToken());
		}

		temp = new int[N];
		ans = -1;
		merge_sort(A, 0, N - 1);
		System.out.println(ans);

	}

	static void merge_sort(int[] arr, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(arr, p, q);
			merge_sort(arr, q + 1, r);
			merge(arr, p, q, r);
		}
	}

	static void merge(int[] arr, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0; // 1 안함

		while (i <= q && j <= r) {
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		while (i <= q) {
			temp[t++] = arr[i++];
		}
		while (j <= r) {
			temp[t++] = arr[j++];
		}

		for (int x = p; x <= r; x++) {
			arr[x] = temp[x - p]; // +1 안함
			if (cnt++ == K - 1) {
				ans = arr[x];
			}
//			for(int s=0;s<N;s++) {  // 디버깅
//				System.out.print(arr[s]+" ");
//			}
//			System.out.println();
		}

	}

}
