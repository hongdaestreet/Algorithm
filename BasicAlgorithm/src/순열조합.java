package practice;

import java.util.Arrays;

public class 순열조합 {
	static int[] arr = { 1, 2, 3, 4, 5 };
	static int N = arr.length;
	static int r = 3; // r개 선택;
	static int[] output = new int[r]; // r개 고른 결과

	public static void main(String[] args) {
		boolean[] visited = new boolean[5];
//		System.out.println("순열 (사전식X)");
//		pmt(0,r);
		
		System.out.println("\n순열 (사전식)");
		pmt(visited,0,r);

//		System.out.println("\n중복순열");
//		pmtR(0,r);

//		System.out.println("\n조합");
//		comb(visited, 0, 0, r);

//		System.out.println("\n중복조합");
//		combR(0, 0, r);

	}

	// 순열 (사전식X)
	static void pmt(int depth, int r) {
		int N = arr.length;
		if (depth == r) { // 순열 다 만들어진 시점
			print(output);
			return;
		}
		// 재귀 진행
		for (int i = depth; i < N; i++) {
			swap(i, depth);
			output[depth] = arr[depth]; // swap하면 swap된 depth 인덱스 사용해야지
			pmt(depth + 1, r);
			swap(i, depth); // 다시 원복
		}
	}

	// 순열 (사전식)
	static void pmt(boolean[] visited, int depth, int r) {
		if (depth == r) { // 순열 완성 시점
			print(output);
			return;
		}
		// 재귀 진행
		for (int i = 0; i < N; i++) {  // 순열은 순서있으므로 0부터 다시 다 돌림
			if (!visited[i]) {
				visited[i] = true; // 방문 처리
				output[depth] = arr[i]; // output배열의 depth 인덱스에 arr[i] 할당
				pmt(visited, depth + 1, r); // 방문 처리된 채로 가기
				visited[i] = false; // 다시 방문할 수 있게 만들어줌
			}
		}
	}

	// 중복순열 (사전식)
	static void pmtR(int depth,int r) {
		if (depth == r) { // 중복순열 완성 시점
			print(output);
			return;
		}

		for (int i = 0; i < N; i++) { // depth부터가 아닌 처음부터 아예 쫙 반복해버림
			output[depth] = arr[i];
			pmtR(depth + 1,r);
		}
	}

	// 조합
	// visited 배열로 방문 처리하면서 배열에 등록함. 그리고 재귀를 실행하는데 다시 선택할 수 있도록 방문X 처리함
	static void comb(boolean[] visited, int start, int depth, int r) {

		if (depth == r) {
			print(output);
			return;
		}

		for (int i = start; i < N; i++) {  // 조합은 순서 지키므로 이전은 선택X
			if (!visited[i]) {
				visited[i] = true;  // 방문 처리
				output[depth] = arr[i];  // 등록
				comb(visited, i + 1, depth + 1, r); // 다음 차례(depth+1)에 자기 포함X (i+1)
				visited[i] = false; // 다시 방문을 하기 위해 방문X 처리 (백트래킹)

			}
		}

	}

	// 중복 조합
	// 중복으로 담을 것이므로 visited 배열 필요X
	// (start : 다음 대상을 선택할때 탐색 시작할 index)
	static void combR(int start, int depth, int r) {
		if (depth == r) {
			print(output);
			return;
		}

		for (int i = start; i < N; i++) {
			output[depth] = arr[i];  // 등록
			combR(i, depth + 1, r); // 다음 차례(depth+1)에도 자기 자신 포함함(i)
		}

	}

	// 원소 교환
	static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// 행렬 출력
	static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
